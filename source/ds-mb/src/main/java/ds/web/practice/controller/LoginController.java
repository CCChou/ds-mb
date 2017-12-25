package ds.web.practice.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ds.web.practice.service.LoginService;

@Controller
@RequestMapping(path= {"/login.controller"})
public class LoginController {
    @Resource
    private LoginService loginService;
    
    @RequestMapping(method= {RequestMethod.GET})
    public String login(Model model) {
        // verify user
        System.out.println(loginService.verifyPwd("dennis",""));
        return "Index.html";
    }
    
}
