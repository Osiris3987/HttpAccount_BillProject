package com.example.httpaccount_billproject.entity;

import com.example.httpaccount_billproject.controller.dto.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.data.annotation.Reference;

import java.math.BigDecimal;
@Data
@Entity
@NoArgsConstructor
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    private BigDecimal amount;
    private String status;

    public Payments(BigDecimal amount, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.status = paymentStatus.toString();
    }

    public Payments(BigDecimal amount) {
    }
}
