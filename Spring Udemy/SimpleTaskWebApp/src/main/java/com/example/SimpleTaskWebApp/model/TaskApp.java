package com.example.SimpleTaskWebApp.model;

import javax.persistence.*;

@Entity
@Table(name = "simpletask")
public class TaskApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "task")
    private String task;
    @Column(name = "priority")
    private String priority;

    public TaskApp() {
    }

    public TaskApp(int id, String task, String priority) {
        this.id = id;
        this.task = task;
        this.priority = priority;
    }

    public TaskApp(String task, String priority) {
        this.task = task;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
