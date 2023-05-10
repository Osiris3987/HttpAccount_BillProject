package com.example.httpaccount_billproject.service;

import com.example.httpaccount_billproject.controller.dto.PaymentStatus;
import com.example.httpaccount_billproject.entity.Account;
import com.example.httpaccount_billproject.entity.Bill;
import com.example.httpaccount_billproject.entity.Payments;
import com.example.httpaccount_billproject.exceptions.BillNotDefaultException;
import com.example.httpaccount_billproject.exceptions.PaymentNotFoundException;
import com.example.httpaccount_billproject.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {
    private final AccountService accountService;
    private final PaymentRepository paymentRepository;
    @Autowired
    public PaymentService(AccountService accountService, PaymentRepository paymentRepository){
        this.accountService = accountService;
        this.paymentRepository = paymentRepository;
    }

    public Object makePayment(Long accountIdForPayment, BigDecimal amount){
        Account account = accountService.getById(accountIdForPayment);
        Payments payments = new Payments();
        Bill bill = findDefaultBill(account);

        if(bill.getAmount().compareTo(amount) >= 0){
            payments.setStatus(PaymentStatus.SUCCESS.toString());
            bill.setAmount(bill.getAmount().subtract(amount));
            accountService.updateAccount(account);
        }
        else payments.setStatus(PaymentStatus.FAILED.toString());

        payments.setAmount(amount);
        paymentRepository.save(payments);
        return "Successful";
    }
    public Bill findDefaultBill(Account account){
        return account.getBills().stream()
                .filter(Bill::getIsDefault)
                .findAny()
                .orElseThrow(() -> new BillNotDefaultException("Bill is not default"));
    }
    /*public Long savePayments(BigDecimal amount){
        Payments payments = new Payments(amount);
        return paymentRepository.save(payments).getPaymentId();
    }*/
    public Payments getPaymentsById(Long id){
        return paymentRepository.findById(id).orElseThrow(() -> new PaymentNotFoundException("There is no such payment in this service"));
    }


}
