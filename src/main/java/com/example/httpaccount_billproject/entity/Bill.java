package com.example.httpaccount_billproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long billId;
    private Boolean isDefault;
    private BigDecimal amount;

    public Bill(Boolean isDefault, BigDecimal amount) {
        this.isDefault = isDefault;
        this.amount = amount;
    }
    public Bill(){}
}
