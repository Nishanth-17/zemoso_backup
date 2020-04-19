package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showCustomFormLogin")
    public String showCustomFormLogin(){
        return "fancy-login";
    }
}
