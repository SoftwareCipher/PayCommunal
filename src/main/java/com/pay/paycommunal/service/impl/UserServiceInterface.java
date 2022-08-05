package com.pay.paycommunal.service.impl;

import com.pay.paycommunal.entities.User;
import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUsers();

    void saveOrUpdateUser(User user);

    User getUser(long id);

    void deleteUser(long id);
}
