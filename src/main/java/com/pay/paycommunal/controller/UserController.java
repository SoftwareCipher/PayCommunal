package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.User;
import com.pay.paycommunal.service.impl.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userServiceInterface.getAllUsers();
    }

    @PostMapping("/user")
    public User saveOrUpdateUser(@RequestBody User user){
        userServiceInterface.saveOrUpdateUser(user);
        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        return userServiceInterface.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable long id){
        userServiceInterface.deleteUser(id);
    }
}
