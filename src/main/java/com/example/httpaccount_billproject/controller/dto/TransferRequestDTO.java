package com.example.httpaccount_billproject.controller.dto;

import java.math.BigDecimal;

public class TransferRequestDTO {
    private Long accountFrom;
    private Long accountTo;
    private BigDecimal amount;
    public Long getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Long accountFrom) {
        this.accountFrom = accountFrom;
    }

    public Long getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Long accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
