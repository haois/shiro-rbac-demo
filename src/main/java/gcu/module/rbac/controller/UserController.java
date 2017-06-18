package gcu.module.rbac.controller;

import gcu.module.rbac.daomain.Resource;
import gcu.module.rbac.daomain.Role;
import gcu.module.rbac.daomain.User;
import gcu.module.rbac.service.ResourceService;
import gcu.module.rbac.service.RoleService;
import gcu.module.rbac.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haol on 2016/9/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;
        @Autowired
        private ResourceService resourceService;
        @Autowired
        private RoleService roleService;

        private Logger logger = LoggerFactory.getLogger(UserController.class);

        @RequestMapping("/noAuthority")
        public String noAuthority() {
                return "/rbac/noAuthority";
        }

        @RequestMapping("/add")
        public String add(Model model) {
                List<Role> roles = roleService.getRoleList();
                model.addAttribute("roleList", roles);
                return "/rbac/user/add";
        }

        @RequestMapping("/list")
        public String list(Model model) {
                List<User> users = userService.getUserList();
                model.addAttribute("userList", users);

                return "/rbac/user/list";
        }

        @RequestMapping("/res/{id}")
        public String res(Model model, @PathVariable int id) {
                User user = userService.queryUserById(id);
                List<Resource> resources = resourceService.queryResourceByUser(id);
                model.addAttribute("resList", resources);
                model.addAttribute("user", user);
                return "/rbac/user/res";
        }

        @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
        public String update(Model model, @PathVariable int id) {
                User user = userService.queryUserById(id);
                List<Role> roles = roleService.getRoleList();
                List<Role> my_roles = roleService.queryRoleByUser(id);
                List<Integer> rids = new ArrayList<Integer>();
                for (Role role : my_roles) {
                        rids.add(role.getId());
                }
                model.addAttribute("user", user);
                model.addAttribute("roleList", roles);
                model.addAttribute("my_roles", rids);
                return "/rbac/user/update";
        }

        @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
        public String del(@PathVariable int id) {
                userService.delete(id);
                roleService.deleteUserRoleByUser(id);
                return "redirect:/user/list";
        }

        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String update(Model model, User user) {
                String roles = user.getRolesitems();
                if (user.getUsername().equals("gcu")){
                        return "redirect:/user/list";
                }
                if (user.getId() == 0) {
                        userService.add(user);
                        int id = userService.getLastId();
                        user.setId(id);
                } else {
                        userService.update(user);
                }
                if (StringUtils.isNotEmpty(roles)) {
                        String[] strs = roles.split(",");
                        roleService.deleteUserRoleByUser(user.getId());
                        for (String str : strs) {
                                int roleId = Integer.parseInt(str);
                                roleService.addUserRole(user.getId(), roleId);
                        }
                }
                return "redirect:/user/list";
        }

        @RequestMapping("/info")
        public String info(Model model) {
                Subject subject = SecurityUtils.getSubject();
                String username = subject.getPrincipal().toString();
                User user = userService.queryUserByName(username);
                if (user == null) {
                        return "/rbac/user/info";
                }
                int id = user.getId();
                List<Role> roles = roleService.queryRoleByUser(id);
                List<Resource> resources = resourceService.queryResourceByUser(id);

                model.addAttribute("roleList", roles);
                model.addAttribute("resList", resources);
                return "/rbac/user/info";
        }
}
