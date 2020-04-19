package com.example.MySpringbootApp.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class Restcontroller {
    @GetMapping("/")
    public String showInfo(){
        return "Hello!!! Local Zone Time is :"+ LocalDateTime.now();
    }
    @GetMapping("/bike")
    public String showBike(){
        return "Kawasaki ZX10R";
    }
    @GetMapping("/car")
    public String showCar(){
        return "Audi R8";
    }
}
