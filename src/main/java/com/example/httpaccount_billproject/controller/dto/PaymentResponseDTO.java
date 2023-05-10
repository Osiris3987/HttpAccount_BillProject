package com.example.httpaccount_billproject.controller.dto;

import com.example.httpaccount_billproject.entity.Payments;
import lombok.Value;

import java.math.BigDecimal;
@Value
public class PaymentResponseDTO {
    Long accountIdForPayment;
    BigDecimal amount;
    String status;

    public PaymentResponseDTO(Payments payments){
        this.accountIdForPayment = payments.getPaymentId();
        this.amount = payments.getAmount();
        this.status = payments.getStatus();
    }

}
