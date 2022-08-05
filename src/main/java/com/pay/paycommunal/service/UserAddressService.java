package com.pay.paycommunal.service;

import com.pay.paycommunal.entities.UserAddress;
import com.pay.paycommunal.repository.UserAddressRepository;
import com.pay.paycommunal.service.impl.UserAddressServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService implements UserAddressServiceInterface {

    UserAddressRepository userAddressRepository;

    @Autowired
    public UserAddressService(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    @Override
    public List<UserAddress> getAllAddress() {
        return userAddressRepository.findAll();
    }

    @Override
    public void saveOrUpdateAddress(UserAddress address) {
        userAddressRepository.saveAndFlush(address);
    }

    @Override
    public UserAddress getAddress(long id) {
        UserAddress userAddress = null;
        Optional<UserAddress> optional = userAddressRepository.findById(id);
        if(optional.isPresent()){
            userAddress = optional.get();
        }else{
            System.out.println("Error! Address " + id + " not found!");
        }
        return userAddress;
    }

    @Override
    public void deleteAddress(long id) {
        userAddressRepository.deleteById(id);
    }
}
