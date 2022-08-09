package com.pay.paycommunal.service.applicationProcessingLogic;

import com.pay.paycommunal.entities.Pay;
import com.pay.paycommunal.service.PayService;
import com.pay.paycommunal.service.impl.StatusPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@EnableAsync
public class PayCommunalProcessor {

    PayService payService;

    @Autowired
    public PayCommunalProcessor(PayService payService) {
        this.payService = payService;
    }

    @Scheduled(fixedRate = 1000)
    @Async
    public void payStatus() {
        List<Pay> newPayments = payService.payStatusNew();
        for (int i = 0; i < newPayments.size(); i++) {
            Long id = newPayments.get(i).getId();
            if (payService.getPay(id).getStatus().equals(StatusPay.NEW.name())) {
                assignNewStatus(id);
            }
        }
    }

    private void assignNewStatus(long item) {
        int a = (int) (Math.random() * 3);
        Pay pay = payService.getPay(item);
        StatusPay status = StatusPay.NEW;
        switch (a) {
            case 1:
                status = StatusPay.PAID;
                break;
            case 2:
                status = StatusPay.FAILED;
        }
        payService.updateStatusPay(pay, status);
    }
}
