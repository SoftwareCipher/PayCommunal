package com.pay.paycommunal.repository;

import com.pay.paycommunal.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
