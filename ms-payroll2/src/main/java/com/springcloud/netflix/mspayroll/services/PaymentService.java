package com.springcloud.netflix.mspayroll.services;

import com.springcloud.netflix.mspayroll.entities.Payment;
import com.springcloud.netflix.mspayroll.entities.Worker;
import com.springcloud.netflix.mspayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private WorkerFeignClient workerFeignClient;

//    @Autowired
//    public PaymentService(PaymentService paymentService, WorkerFeignClient workerFeignClient) {
//        this.paymentService = paymentService;
//        this.workerFeignClient = workerFeignClient;
//    }

    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.getById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
