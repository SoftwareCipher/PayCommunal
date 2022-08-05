package com.pay.paycommunal.service.impl;

import com.pay.paycommunal.entities.UserAddress;
import java.util.List;

public interface UserAddressServiceInterface {
    List<UserAddress> getAllAddress();

    void saveOrUpdateAddress(UserAddress address);

    UserAddress getAddress(long id);

    void deleteAddress(long id);
}
