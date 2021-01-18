package com.springcloud.netflix.mspayroll.resources;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.springcloud.netflix.mspayroll.entities.Payment;
import com.springcloud.netflix.mspayroll.services.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payroll")
public class PayrollResource {

    private static Logger logger = LoggerFactory.getLogger(PayrollResource.class);

    @Autowired
    private PaymentService paymentService;

//    @Autowired
//    public PayrollResource(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }


//    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable long workerId, @PathVariable int days) {
        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative(long workerId, int days, Throwable e) {
        e.printStackTrace();
        Payment payment = new Payment("Romulo", 500.0, days);
        return ResponseEntity.ok(payment);
    }


}
