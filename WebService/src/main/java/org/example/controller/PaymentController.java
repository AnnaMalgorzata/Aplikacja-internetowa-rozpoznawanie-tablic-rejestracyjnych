package org.example.controller;

import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @PostMapping("/payment")
    public int paymentAdd(@RequestBody Payment payment) {
        Payment savedPayment = paymentRepository.save(payment);
        return savedPayment.getId();
    }
}
