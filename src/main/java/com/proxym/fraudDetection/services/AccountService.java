package com.proxym.fraudDetection.services;

import com.proxym.fraudDetection.entities.Account;
import com.proxym.fraudDetection.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {

        Account newAccount = accountRepository.save(account);
        return newAccount;
    }
}
