package com.example.MySpringbootApp.Rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class Restcontroller {

    @Value("${bike.name}")
    private String bikeName;

    @Value("${car.name}")
    private String carName;

    @Value("${card.name}")
    private String cardName;

    @GetMapping("/")
    public String showInfo(){
        return "Hello!!! Local Zone Time is :"+ LocalDateTime.now();
    }
    @GetMapping("/bike")
    public String showBike(){
        return bikeName;
    }
    @GetMapping("/car")
    public String showCar(){
        return carName+" Thor";
    }
    @GetMapping("/cards")
    public String showCard(){
        return "Should Use "+cardName;
    }
}
