package com.example.httpaccount_billproject.controller.dto;

import java.math.BigDecimal;

public class BillRequestDTO {
    private BigDecimal amount;
    private Boolean isDefault;
    private String status;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }
}
