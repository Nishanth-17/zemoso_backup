package com.wct.springdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		return "list-customers";
	}
}
