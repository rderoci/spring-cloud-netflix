package com.springcloud.netflix.mspayroll.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.springcloud.netflix.mspayroll.entities.Payment;
import com.springcloud.netflix.mspayroll.entities.Worker;
import com.springcloud.netflix.mspayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

//    @Autowired
//    public PaymentService(WorkerFeignClient workerFeignClient) {
//        this.workerFeignClient = workerFeignClient;
//    }


    public Payment getPayment(long workerId, int days) {
        Worker worker = workerFeignClient.getById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }


}
