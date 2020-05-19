package com.example.springsecuritylogin.Service;

import com.example.springsecuritylogin.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(int id);
    User saveUser(User user);
    void deleteUser(int id);
    void save(User user);
    User findByUsername(String username);
}
