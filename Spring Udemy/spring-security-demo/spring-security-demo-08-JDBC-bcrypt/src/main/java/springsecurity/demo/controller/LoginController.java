package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @GetMapping("/showCustomFormLogin")
    public String showCustomFormLogin(){
        return "fancy-login";
    }
    @GetMapping("/access-denied")
    public String showAccessdenied(){
        return "access-denied";
    }
}
