package gcu.module.rbac.rest;

import gcu.module.rbac.daomain.User;
import gcu.module.rbac.service.RoleService;
import gcu.module.rbac.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
