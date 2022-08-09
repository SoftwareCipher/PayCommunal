package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.Pay;
import com.pay.paycommunal.service.impl.PayServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pay")
public class PayController {

    PayServiceInterface payServiceInterface;

    @Autowired
    public PayController(PayServiceInterface payServiceInterface) {
        this.payServiceInterface = payServiceInterface;
    }

    @GetMapping("/pays")
    public List<Pay> getAllPays() {
        return payServiceInterface.getAllPays();
    }

    @PostMapping("/pay")
    public Pay saveOrUpdatePay(@RequestBody Pay pay) {
       payServiceInterface.saveOrUpdatePay(pay);
       return pay;
    }

    @GetMapping("/pay/{id}")
    public Pay getPay(@PathVariable long id) {
        return payServiceInterface.getPay(id);
    }

    @DeleteMapping("/pay/{id}")
    public void deletePay(@PathVariable long id) {
        payServiceInterface.deletePay(id);
    }

    @GetMapping("/paymentsStatusNew")
    public List<Pay> getPaymentsStatusNew(){
        return payServiceInterface.payStatusNew();
    }
}
