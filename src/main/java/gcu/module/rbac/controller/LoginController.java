package gcu.module.rbac.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by haol on 2016/9/4.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String login(){
        return "/rbac/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String checkLogin(@RequestParam String username, @RequestParam String password, Model model){
        logger.info("go into UserCon");
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            return "redirect:/user/list";
        }catch (AuthenticationException e){
            logger.error(e.getMessage());
            model.addAttribute("account",username);
            model.addAttribute("error",e.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage());
            model.addAttribute("account",username);
            model.addAttribute("error","系统发生错误");
        }
        return "/rbac/login";
        }

    @RequestMapping(value = "/logout")
    public String logout() {
        /*SecurityContextHolder.destroy();*/
        /*不用shiro框架用上面的，用了shiro之后用下面*/
        SecurityUtils.getSubject().logout();
        return "redirect:/login/index";
    }
}
