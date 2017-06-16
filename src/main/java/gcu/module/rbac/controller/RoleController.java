package gcu.module.rbac.controller;

import gcu.module.rbac.daomain.Resource;
import gcu.module.rbac.daomain.Role;
import gcu.module.rbac.service.ResourceService;
import gcu.module.rbac.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haol on 2016/9/10.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(String name, String sn) {
        Role role = new Role();
        role.setName(name);
        role.setSn(sn);
        roleService.addRole(role);
        logger.info("增加了角色名[{}]角色sn[{}]", name, sn);
        return "redirect:/role/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<Role> roles = roleService.getRoleList();
        model.addAttribute("roleList", roles);
        return "/rbac/role/list";
    }

    @RequestMapping("/res/{roleId}")
    public String res(@PathVariable int roleId, Model model) {
        Role role = roleService.loadRoleById(roleId);
        List<Resource> resources = resourceService.queryResourceByRole(roleId);
        model.addAttribute("role", role);
        model.addAttribute("resList", resources);
        return "/rbac/role/res";
    }
    @RequestMapping("/res/update/{roleId}")
    public String updateRes(@PathVariable int roleId, Model model) {
        Role role = roleService.loadRoleById(roleId);
        List<Resource> resources = resourceService.getResourceList();
        List<Resource> role_res = resourceService.queryResourceByRole(roleId);
        model.addAttribute("role", role);
        model.addAttribute("role_res",role_res);
        model.addAttribute("resList", resources);
        return "/rbac/role/updateRes";
    }
    @RequestMapping(value = "/delete/{roleId}", method = RequestMethod.GET)
    public String del(@PathVariable int roleId) {
        roleService.deleteRole(roleId);
        resourceService.deleteRoleResByRole(roleId);
        roleService.deletetUserRoleByRole(roleId);
        return "redirect:/role/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id,Model model) {
        Role role = roleService.loadRoleById(id);
        model.addAttribute("role",role);
        return "/rbac/role/update";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(String name,String sn,int id) {
        Role role = new Role();
        role.setId(id);
        role.setSn(sn);
        role.setName(name);
        roleService.updateRole(role);
        return "redirect:/role/list";
    }
}
