package com.example.SimpleTaskWebApp.controller;

import com.example.SimpleTaskWebApp.model.TaskApp;
import com.example.SimpleTaskWebApp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class demoController {
    @Autowired
    TaskService service;

    @GetMapping("/list")
    public String getTasks(Model myModel){
        List<TaskApp> taskList=service.findAll();
        myModel.addAttribute("allTasks",taskList);
        return "list-tasks";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        TaskApp taskApp = new TaskApp();

        theModel.addAttribute("taskModel", taskApp);

        return "task-form";
    }

    @PostMapping("/save")
    public String saveTask(@ModelAttribute("taskModel") TaskApp taskApp) {

        // save the Task
        service.save(taskApp);

        // use a redirect to prevent duplicate submissions
        return "redirect:/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id,
                                    Model theModel) {

        // get the employee from the service
        TaskApp taskApp = service.findById(id);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("task", taskApp);

        // send over to our form
        return "list-form";
    }
    @GetMapping("/delete")
    public String deleteTask(@RequestParam("id") int theId){

        service.delete(theId);
        return "redirect:list-tasks";
    }

}
