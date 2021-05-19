package com.example.mybeansdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SavingsAccountService implements BankAccountsService {

    @Autowired
    private BankRepository repository;

    @Override
    public void deposit(Double amount) {
        log.info("Savings Account Deposit received {}", amount);
        repository.saveTransaction(amount + (amount*0.1));
    }
}
