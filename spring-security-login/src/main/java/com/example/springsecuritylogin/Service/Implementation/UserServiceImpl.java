package com.example.springsecuritylogin.Service.Implementation;

import com.example.springsecuritylogin.Entity.User;
import com.example.springsecuritylogin.Repository.UserRepository;
import com.example.springsecuritylogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUsers(){
        List<User> userList= (List<User>) userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user=userRepository.findById(id).orElse(null);
        if(user==null) {
            return null;
        }
        return user;
    }

    @Override
    public User saveUser(User user){
        //boolean value=userRepository.isUserEmailExist(userEmail);
        //if(value==false) {
        //    return null;
        //}
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user= userRepository.findByUsername(username);
        return user;
    }
}
