package ds.web.practice.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ds.web.practice.service.LoginService;
import ds.web.practice.service.RegisterService;

@Controller
@SessionAttributes("loginedAccount")
public class UserController {
    @Resource
    private LoginService loginService;
    @Resource
    private RegisterService registerService;

    @RequestMapping(method = { RequestMethod.GET }, path = { "/login" })
    public String loginPage() {
    	return "login";
    }
    
    @RequestMapping(method = { RequestMethod.POST }, path = { "/login" })
    public String login(Model model, String account, String password) {
        Map<String, String> errors = new HashMap<>();
        model.addAttribute("errors", errors);

        if (!loginService.verifyUser(account, password)) {
            errors.put("errorMessage", "帳號不存在或密碼錯誤");
            return "loginPage";
        }

        model.addAttribute("loginedAccount", account);
        return "index";
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/logout" })
    public String logout(SessionStatus status) {
        status.setComplete();
        return "index";
    }

    @RequestMapping(method = { RequestMethod.GET }, path = { "/register" })
    public String registerPage() {
    	return "register";
    }
    		
    @RequestMapping(method = { RequestMethod.POST }, path = { "/register" })
    public String register(Model model, String account, String password, String passwordConfirm) {
        Map<String, String> errors = new HashMap<>();
        model.addAttribute("errors", errors);

        if (!password.equals(passwordConfirm)) {
            errors.put("passwordConfirmError", "密碼不一致");
            return "registerPage";
        }

        if (!registerService.checkAccount(account)) {
            errors.put("accountError", "帳號名稱已被註冊");
            return "registerPage";
        }

        registerService.register(account, password);
        return "index";
    }

}
