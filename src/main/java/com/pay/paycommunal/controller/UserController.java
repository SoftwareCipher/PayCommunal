package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.User;
import com.pay.paycommunal.service.impl.UserServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "/UserController", description = "UserController | Rest questions")
@RequestMapping("/user")
public class UserController {

    UserServiceInterface userServiceInterface;

    @Autowired
    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface = userServiceInterface;
    }

    @GetMapping("/users")
    @ApiOperation("Get all users")
    public List<User> getAllUsers(){
        return userServiceInterface.getAllUsers();
    }

    @PostMapping("/user")
    @ApiOperation("save users")
    public User saveOrUpdateUser(@RequestBody User user){
        userServiceInterface.saveOrUpdateUser(user);
        return user;
    }

    @GetMapping("/user/{id}")
    @ApiOperation("get user")
    public User getUser(@PathVariable long id){
        return userServiceInterface.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("delete user")
    public void deleteUser(@PathVariable long id){
        userServiceInterface.deleteUser(id);
    }
}
