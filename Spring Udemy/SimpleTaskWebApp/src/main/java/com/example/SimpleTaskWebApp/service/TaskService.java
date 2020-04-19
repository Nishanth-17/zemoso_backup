package com.example.SimpleTaskWebApp.service;

import com.example.SimpleTaskWebApp.model.TaskApp;

import java.util.List;

public interface TaskService {
    public List<TaskApp> findAll();
    public TaskApp findById(int id);
    public void save(TaskApp task);
    public void delete(int id);
}
