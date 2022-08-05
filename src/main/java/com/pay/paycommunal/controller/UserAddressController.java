package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.UserAddress;
import com.pay.paycommunal.service.impl.UserAddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class UserAddressController {
    UserAddressServiceInterface userAddressServiceInterface;

    @Autowired
    public UserAddressController(UserAddressServiceInterface userAddressServiceInterface) {
        this.userAddressServiceInterface = userAddressServiceInterface;
    }

    @GetMapping("/addresses")
    public List<UserAddress> getAllAddress(){
        return userAddressServiceInterface.getAllAddress();
    }

    @PostMapping("/address")
    public UserAddress saveOrUpdateAddress(@RequestBody UserAddress address){
        userAddressServiceInterface.saveOrUpdateAddress(address);
        return address;
    }

    @GetMapping("/address/{id}")
    public UserAddress getAddress(@PathVariable long id){
       return userAddressServiceInterface.getAddress(id);
    }

    @DeleteMapping("/address/{id}")
    public void deleteAddress(@PathVariable long id){
        userAddressServiceInterface.deleteAddress(id);
    }
}
