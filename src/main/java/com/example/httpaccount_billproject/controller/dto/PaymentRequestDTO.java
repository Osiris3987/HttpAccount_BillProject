package com.example.httpaccount_billproject.controller.dto;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class PaymentRequestDTO {
    Long accountIdForPayment;
    BigDecimal amount;
}
