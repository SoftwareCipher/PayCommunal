package com.pay.paycommunal.controller;

import com.pay.paycommunal.entities.Pay;
import com.pay.paycommunal.service.impl.PayServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Api(tags = "PayController", description = "PayController | Rest questions")
@RequestMapping("/pay")
public class PayController {

    PayServiceInterface payServiceInterface;

    @Autowired
    public PayController(PayServiceInterface payServiceInterface) {
        this.payServiceInterface = payServiceInterface;
    }

    @GetMapping("/pays")
    @ApiOperation("Get all pays")
    public List<Pay> getAllPays() {
        return payServiceInterface.getAllPays();
    }

    @PostMapping("/pay")
    @ApiOperation("save pay")
    public Pay saveOrUpdatePay(@RequestBody Pay pay) {
       payServiceInterface.saveOrUpdatePay(pay);
       return pay;
    }

    @GetMapping("/pay/{id}")
    @ApiOperation("get pay")
    public Pay getPay(@PathVariable long id) {
        return payServiceInterface.getPay(id);
    }

    @DeleteMapping("/pay/{id}")
    @ApiOperation("delete pay")
    public void deletePay(@PathVariable long id) {
        payServiceInterface.deletePay(id);
    }

    @GetMapping("/paymentsStatusNew")
    @ApiOperation("save change pay")
    public List<Pay> getPaymentsStatusNew(){
        return payServiceInterface.payStatusNew();
    }
}
