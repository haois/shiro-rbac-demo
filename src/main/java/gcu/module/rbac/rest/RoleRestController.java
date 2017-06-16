package gcu.module.rbac.rest;

import gcu.module.rbac.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by haol on 2016/9/12.
 */
@RestController
@RequestMapping("/rest/role")
public class RoleRestController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/res/update",method = RequestMethod.POST)
    public String updateRes(int aOrd, int roleId,int resId) {
        if (aOrd == 0){
            resourceService.delRoleResource(roleId,resId);
        }else {
            resourceService.addRoleResource(roleId,resId);
        }
        return "redirect:/role/list";
    }
}
