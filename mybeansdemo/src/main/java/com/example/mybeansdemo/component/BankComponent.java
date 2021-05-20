package com.example.mybeansdemo.component;

import com.example.mybeansdemo.service.BankAccountsService;
import com.example.mybeansdemo.service.CurrentAccountService;
import com.example.mybeansdemo.service.SavingsAccountService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
@Scope("prototype")
@Slf4j
@Data
public class BankComponent {

    @Autowired
    private Contact contact;

    @Value("${missing: 100}") //to inject property
    private Integer missing;

    @Autowired
    private ApplicationArguments applicationArguments;

    @Autowired
   // @Qualifier("savingsAccountService")
    private List<BankAccountsService> services;

    public void deposit(Double amount, String serviceName){

        log.info("contact name = {}, postcode = {}, contact object {}", contact.getName(), contact.getAddress().getPostcode(), contact);
        log.info("missing value {} ", missing);
        log.info("Component received deposit of {}", amount);
        for(BankAccountsService service: services) {
            if (service instanceof SavingsAccountService && serviceName.equals("savings")) {
                SavingsAccountService sa = (SavingsAccountService)service;
                sa.deposit(amount);
                break;
            } else if (service instanceof CurrentAccountService && serviceName.equals("CURRENT")){
                CurrentAccountService sa = (CurrentAccountService)service;
                sa.deposit(amount);
                break;
            }
        }
    }


    public void printArguments() {

        log.info(" getOptionNames {}", applicationArguments.getOptionNames());
        log.info(" getNonOptionArgs {}", applicationArguments.getNonOptionArgs());
        log.info(" getSourceArgs {}", applicationArguments.getSourceArgs());
        log.info(" getNonOptionArgs {}", applicationArguments.getOptionValues("name"));

    }
}
