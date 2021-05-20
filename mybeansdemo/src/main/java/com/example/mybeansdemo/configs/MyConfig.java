package com.example.mybeansdemo.configs;

import com.example.mybeansdemo.service.BankAccountsService;
import com.example.mybeansdemo.service.CurrentAccountService;
import com.example.mybeansdemo.service.ISAAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean({"isa","iSAAccountService"})
    public BankAccountsService bankAccountsService(){
      return new ISAAccountService();
    }

    @Bean({"anotherBankAccountsService"})
    public BankAccountsService anotherBankAccountsService(){
        return new CurrentAccountService();
    }
}
