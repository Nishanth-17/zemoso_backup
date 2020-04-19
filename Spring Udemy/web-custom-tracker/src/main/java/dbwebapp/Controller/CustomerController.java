package dbwebapp.Controller;
import dbwebapp.dao.CustomerDAO;
import dbwebapp.entity.Customer;
import dbwebapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Customer")
public class CustomerController {

    //inject customer service
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/list")
    public String listCustomers(Model model) {

        //get customers from the Service
        List<Customer> theCustomers=customerService.getCustomers();
        //add to the model object
        model.addAttribute("customer",theCustomers);
        return "list-customers";
    }
    @GetMapping("/ShowFormForAdd")
    public String showFormforAdd(Model theModel){

        //Create model attribute to bind form data
        Customer theCustomer=new Customer();
        theModel.addAttribute("customer",theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
        customerService.saveCustomer(theCustomer);
        return "redirect:/Customer/list";
    }
    @RequestMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
        //get the customer from our service
        Customer theCustomer = customerService.getCustomer(theId);
        //Set customer as a model attribute to re populate the form
        model.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId){
        customerService.deleteCustomer(theId);
        return "redirect:/Customer/list";
    }
}
