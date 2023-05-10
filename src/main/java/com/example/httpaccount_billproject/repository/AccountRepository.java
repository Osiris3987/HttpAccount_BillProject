package com.example.httpaccount_billproject.repository;

import com.example.httpaccount_billproject.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
