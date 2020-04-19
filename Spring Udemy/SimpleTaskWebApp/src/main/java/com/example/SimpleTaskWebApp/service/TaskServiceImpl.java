package com.example.SimpleTaskWebApp.service;

import com.example.SimpleTaskWebApp.dao.TaskRepository;
import com.example.SimpleTaskWebApp.model.TaskApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repository;
    @Override
    public List<TaskApp> findAll() {
        return repository.findAll();
    }

    @Override
    public TaskApp findById(int id) {
        Optional<TaskApp> result=repository.findById(id);
        TaskApp taskApp =null;
        if (result.isPresent()) {
            taskApp = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find  id - " + id);
        }
        return taskApp;
    }

    @Override
    public void save(TaskApp task) {
        repository.save(task);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
