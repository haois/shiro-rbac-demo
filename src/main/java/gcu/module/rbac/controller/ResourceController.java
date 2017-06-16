package gcu.module.rbac.controller;

import gcu.module.rbac.daomain.Resource;
import gcu.module.rbac.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by haol on 2016/9/10.
 */
@Controller
@RequestMapping("/res")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(String name,String url,String permission){
        Resource resource = new Resource();
        resource.setName(name);
        resource.setUrl(url);
        resource.setPermission(permission);
        resourceService.addRes(resource);
        return "redirect:/res/list";
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(String name,String url,String permission,int id){
        Resource resource = new Resource();
        resource.setId(id);
        resource.setName(name);
        resource.setUrl(url);
        resource.setPermission(permission);
        resourceService.updateRes(resource);
        return "redirect:/res/list";
    }
    @RequestMapping("/list")
    public String list(Model model){
       List<Resource> resources =  resourceService.getResourceList();
        model.addAttribute("resList",resources);
        return "/rbac/res/list";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable int id,Model model){
        Resource resource =resourceService.queryResById(id);
        model.addAttribute("res",resource);
        return "/rbac/res/update";
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String del(@PathVariable int id){
        resourceService.deleteRes(id);
        resourceService.deletetRoleResByRes(id);
        return "redirect:/res/list";
    }
}
