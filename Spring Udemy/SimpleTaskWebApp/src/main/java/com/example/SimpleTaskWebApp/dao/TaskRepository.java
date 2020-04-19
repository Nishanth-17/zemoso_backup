package com.example.SimpleTaskWebApp.dao;
import com.example.SimpleTaskWebApp.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskApp,Integer> {
}
