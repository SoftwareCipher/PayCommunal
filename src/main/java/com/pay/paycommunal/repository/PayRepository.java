package com.pay.paycommunal.repository;

import com.pay.paycommunal.entities.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Long> {
}
