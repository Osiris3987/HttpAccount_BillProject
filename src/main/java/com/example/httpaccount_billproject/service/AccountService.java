package com.example.httpaccount_billproject.service;

import com.example.httpaccount_billproject.entity.Account;
import com.example.httpaccount_billproject.entity.Bill;
import com.example.httpaccount_billproject.exceptions.AccountNotFoundException;
import com.example.httpaccount_billproject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long save(String name, String email, List<Bill> bills) {
        Account account = new Account(name, email, bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account getById(Long accountId) {
        return accountRepository.findById(accountId).
                orElseThrow(() -> new AccountNotFoundException("AccountNotFound"));
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
