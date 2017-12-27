package ds.web.practice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ds.web.practice.service.LoginService;
import ds.web.practice.service.RegisterService;

@Controller
public class UserController {
    @Resource
    private LoginService loginService;
    @Resource
    private RegisterService registerService; 
    private static String successPage = "";
    private static String errorPage = "";
    
    @RequestMapping(method= {RequestMethod.POST}, path= {"/login.controller"})
    public String login(Model model, String account, String password) {
        Map<String, String> errors = new HashMap<>();
        
        if (!loginService.verifyUser(account, password)) {
            errors.put("", "帳號不存在或密碼錯誤");
            return errorPage;
        }
        
        return successPage;
    }
    
    @RequestMapping(method= {RequestMethod.POST}, path= {"/register.controller"})
    public String register(Model model, String account, String password, String passwordConfirm) {
        Map<String, String> errors = new HashMap<>();

        if(password.equals(passwordConfirm)) {
            errors.put("", "密碼不一致");
            return errorPage;
        }
        
        if(!registerService.checkAccount(account)) {
            errors.put("", "帳號名稱已被註冊");
            return errorPage;
        }
        
        registerService.register(account, password);
        return successPage;
    }
    
}
