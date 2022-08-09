package com.pay.paycommunal.service;

import com.pay.paycommunal.entities.Pay;
import com.pay.paycommunal.repository.PayRepository;
import com.pay.paycommunal.service.impl.PayServiceInterface;
import com.pay.paycommunal.service.impl.StatusPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PayService implements PayServiceInterface {

    PayRepository payRepository;

    @Autowired
    public PayService(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    @Override
    public List<Pay> getAllPays() {
        return null;
    }

    @Override
    public void saveOrUpdatePay(Pay pay) {
        pay.setStatus(String.valueOf(StatusPay.NEW));
        pay.setCreateTime(LocalDateTime.now());
        pay.setChangeTime(LocalDateTime.now());
        payRepository.saveAndFlush(pay);
    }

    @Override
    public Pay getPay(long id) {
        Pay pay = null;
        Optional<Pay> optional = payRepository.findById(id);
        if(optional.isPresent()){
            pay = optional.get();
        }else{
            System.out.println("Error! Pay " + id + " not found!");
        }
        return pay;
    }

    @Override
    public void deletePay(long id) {
        payRepository.deleteById(id);
    }

    @Override
    public List<Pay> payStatusNew() {
        return payRepository.payStatusNew();
    }

    @Override
    public void updateStatusPay(Pay pay, StatusPay statusPay) {
        pay.setStatus(statusPay.name());
        pay.setChangeTime(LocalDateTime.now());
        payRepository.save(pay);
    }
}
