package com.example.springsecuritylogin.Service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
