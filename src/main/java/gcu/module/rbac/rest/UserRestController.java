package gcu.module.rbac.rest;

import gcu.module.rbac.daomain.User;
import gcu.module.rbac.service.LoginService;
import gcu.module.rbac.service.RoleService;
import gcu.module.rbac.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by haol on 2016/9/4.
 */
@RestController
@RequestMapping("/rest/user")
public class UserRestController {

    private Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @RequestMapping( value = "/update",method = RequestMethod.POST)
    public boolean update(Model model,@RequestBody User user){
        String roleitems = user.getRolesitems();
        if (StringUtils.isNotEmpty(roleitems)){
            String[] strs = roleitems.split(",");
            roleService.deleteUserRoleByUser(user.getId());
            for (String str:strs){
                int roleId = Integer.parseInt(str);
                roleService.addUserRole(user.getId(), roleId);
            }
        }
        if(user.getId() == 0){
            userService.add(user);
        }else {
            userService.update(user);
        }
       return true;
    }

    @RequestMapping(value = "/checkNameUnique",method = RequestMethod.POST)
    public boolean checkNameUnique(String username){
        User user = userService.queryUserByName(username);
        if (user == null){
            logger.info("可添加");
            return true;
        }else {
            logger.info("不可添加");
            return false;
        }
    }

}
