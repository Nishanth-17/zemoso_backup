package com.example.springsecuritylogin.Controller;

import com.example.springsecuritylogin.Entity.Item;
import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Service.ItemService;
import com.example.springsecuritylogin.Service.SecurityService;
import com.example.springsecuritylogin.Service.UserService;
import com.example.springsecuritylogin.Validator.UserValidator;
import com.sun.media.sound.AiffFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        //securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/","/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/updateForm")
    public String showUpdateUserForm(Model model, Authentication authentication){
        String name=authentication.getName();
        User user=userService.findByUsername(name);
        model.addAttribute("user",user);
        return "update-form";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("user") User user,Authentication authentication){
        String name=authentication.getName();
        User newuser=userService.findByUsername(name);
        userService.deleteUser(newuser.getUserId());
        userService.save(user);
        return "redirect:/login";
    }
    @GetMapping("/showInfo")
    public String showInfo(Model model,Authentication authentication){
        String name=authentication.getName();
        User user=userService.findByUsername(name);
        model.addAttribute("user",user);
        return "user-info";
    }

    @RequestMapping("/list")
    public String list(Model model, Authentication authentication){
        String name=authentication.getName();
        User user=userService.findByUsername(name);
        List<Item> items=itemService.getItemsByUser(user.getUserId());
        model.addAttribute("item",items);
        return "list-item";
    }
    @GetMapping("/showFormForAdd")
    public String itemForm(Model model){
        Item item=new Item();
        model.addAttribute("item",item);
        return "item-form";
    }
    @PostMapping("/save")
    public String saveItem(@ModelAttribute("item") Item item,Authentication authentication){
        String name=authentication.getName();
        User user=userService.findByUsername(name);
        itemService.addItems(item,user);
        return "redirect:/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") int id){
        itemService.deleteItemById(id);
        return "redirect:/list";
    }
}
