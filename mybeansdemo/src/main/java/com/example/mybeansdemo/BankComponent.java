package com.example.mybeansdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
@Scope("prototype")
@Slf4j
public class BankComponent {

    @Autowired
   // @Qualifier("savingsAccountService")
    private List<BankAccountsService> services;

    public void deposit(Double amount, String serviceName){
        log.info("Component received deposit of {}", amount);
        for(BankAccountsService service: services) {
            if (service instanceof  SavingsAccountService && serviceName.equals("savings")) {
                SavingsAccountService sa = (SavingsAccountService)service;
                sa.deposit(amount);
                break;
            } else if (service instanceof  CurrentAccountService && serviceName.equals("CURRENT")){
                CurrentAccountService sa = (CurrentAccountService)service;
                sa.deposit(amount);
                break;
            }
        }
    }
}
