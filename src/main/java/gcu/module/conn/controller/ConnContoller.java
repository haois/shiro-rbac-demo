package gcu.module.conn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by haol on 2016/9/6.
 */
@Controller
@RequestMapping("/conn")
public class ConnContoller {


    private Logger logger = LoggerFactory.getLogger(ConnContoller.class);


    @RequestMapping("/home")
    public String index(Model model){
        return "/conn/home";
    }

    @RequestMapping("/to_rbac")
    public String goto_rbac(Model model){
        logger.info("跳转到rbac");
        return "/conn/home";
    }

}
