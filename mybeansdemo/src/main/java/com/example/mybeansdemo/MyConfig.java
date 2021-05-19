package com.example.mybeansdemo;

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
