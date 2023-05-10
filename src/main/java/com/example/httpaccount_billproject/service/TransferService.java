package com.example.httpaccount_billproject.service;

import com.example.httpaccount_billproject.entity.Account;
import com.example.httpaccount_billproject.entity.Bill;
import com.example.httpaccount_billproject.exceptions.BillNotDefaultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountService accountService;
    @Autowired
    public TransferService(AccountService accountService) {
        this.accountService = accountService;
    }
    public Object transfer(Long accountIdFrom, Long accountIdTo, BigDecimal amount){
        Account accountFrom = accountService.getById(accountIdFrom);
        Account accountTo = accountService.getById(accountIdTo);
        Bill billFrom = findDefaultBill(accountFrom);
        Bill billTo = findDefaultBill(accountTo);
        billFrom.setAmount(billFrom.getAmount().subtract(amount));
        billTo.setAmount(billTo.getAmount().add(amount));
        accountService.updateAccount(accountFrom);
        accountService.updateAccount(accountTo);
        return "Successful transfer";
    }
    public Bill findDefaultBill(Account account){
        return account.getBills().stream()
                .filter(Bill::getIsDefault)
                .findAny()
                .orElseThrow(() -> new BillNotDefaultException("Bill is not default"));
    }
}
