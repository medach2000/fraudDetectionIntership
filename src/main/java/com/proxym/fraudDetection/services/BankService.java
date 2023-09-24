package com.proxym.fraudDetection.services;

import com.proxym.fraudDetection.entities.Account;
import com.proxym.fraudDetection.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public Account getAccount(int accountId){
        Optional<Account> opt = accountRepository.findById(accountId);
        Account account = opt.get();
        return account;
    }
}
