package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.UserAddress;
import com.pay.paycommunal.service.impl.UserAddressServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "/UserAddressController", description = "UserAddressController | Rest questions")
@RequestMapping("/address")
public class UserAddressController {
    UserAddressServiceInterface userAddressServiceInterface;

    @Autowired
    public UserAddressController(UserAddressServiceInterface userAddressServiceInterface) {
        this.userAddressServiceInterface = userAddressServiceInterface;
    }

    @GetMapping("/addresses")
    @ApiOperation("Get all addresses")
    public List<UserAddress> getAllAddress(){
        return userAddressServiceInterface.getAllAddress();
    }

    @PostMapping("/address")
    @ApiOperation("save address")
    public UserAddress saveOrUpdateAddress(@RequestBody UserAddress address){
        userAddressServiceInterface.saveOrUpdateAddress(address);
        return address;
    }

    @GetMapping("/address/{id}")
    @ApiOperation("get address")
    public UserAddress getAddress(@PathVariable long id){
       return userAddressServiceInterface.getAddress(id);
    }

    @DeleteMapping("/address/{id}")
    @ApiOperation("delete address")
    public void deleteAddress(@PathVariable long id){
        userAddressServiceInterface.deleteAddress(id);
    }
}
