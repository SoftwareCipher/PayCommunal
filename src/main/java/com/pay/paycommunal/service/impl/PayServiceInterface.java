package com.pay.paycommunal.service.impl;

import com.pay.paycommunal.entities.Pay;
import java.util.List;

public interface PayServiceInterface {
    List<Pay> getAllPays();

    void saveOrUpdatePay(Pay pay);

    Pay getPay(long id);

    void deletePay(long id);
}
