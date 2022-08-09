package com.pay.paycommunal.repository;

import com.pay.paycommunal.entities.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PayRepository extends JpaRepository<Pay, Long> {

    @Query("select p from Pay p where p.status = 'NEW'")
    List<Pay> payStatusNew();
}
