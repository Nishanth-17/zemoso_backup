package com.example.crudspringboot.Rest;

import com.example.crudspringboot.Entity.Employee;
import com.example.crudspringboot.Service.EmployeeService;
import com.example.crudspringboot.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
            return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee emp=employeeService.findById(employeeId);
        if(emp == null){
            throw new RuntimeException("Employee ID not found - "+employeeId);
        }
        return emp;
    }
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee){
        //In case id is passed in JSON
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);
        return theEmployee;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee temp = employeeService.findById(employeeId);
        if (temp == null)
            throw new RuntimeException("Employee ID not found - "+employeeId);
        employeeService.deleteById(employeeId);
        return "Customer with id - " + employeeId + " is deleted.";
    }
}
