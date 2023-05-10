package com.example.httpaccount_billproject.controller;

import com.example.httpaccount_billproject.controller.dto.PaymentRequestDTO;
import com.example.httpaccount_billproject.controller.dto.PaymentResponseDTO;
import com.example.httpaccount_billproject.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping("/pay")
    public Object makePayment(@RequestBody PaymentRequestDTO paymentRequestDTO){
        return paymentService.makePayment(
                paymentRequestDTO.getAccountIdForPayment(),
                paymentRequestDTO.getAmount());
    }
    @GetMapping("/pay/{paymentId}")
    public PaymentResponseDTO getPayment(@PathVariable Long paymentId){
        return new PaymentResponseDTO(paymentService.getPaymentsById(paymentId));
    }
}
