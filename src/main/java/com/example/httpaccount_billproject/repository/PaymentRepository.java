package com.example.httpaccount_billproject.repository;

import com.example.httpaccount_billproject.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payments, Long> {
}
