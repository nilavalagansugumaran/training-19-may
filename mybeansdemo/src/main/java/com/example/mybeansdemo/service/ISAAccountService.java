package com.example.mybeansdemo.service;


import com.example.mybeansdemo.repository.BankRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;

@Slf4j
public class ISAAccountService implements BankAccountsService {

    @Autowired
    private BankRepository repository;


    @Autowired
    private ApplicationArguments applicationArguments;

    @Override
    public void deposit(Double amount) {
        log.info("ISA Account Deposit received {}", amount);
        repository.saveTransaction(amount + (amount*0.2));
    }

    public void printArguments() {

        log.info(" getOptionNames {}", applicationArguments.getOptionNames());
        log.info(" getNonOptionArgs {}", applicationArguments.getNonOptionArgs());
        log.info(" getSourceArgs {}", applicationArguments.getSourceArgs());
        log.info(" getNonOptionArgs {}", applicationArguments.getOptionValues("name"));

    }
}
