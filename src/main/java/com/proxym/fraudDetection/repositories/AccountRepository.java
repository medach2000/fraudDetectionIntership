package com.proxym.fraudDetection.repositories;

import com.proxym.fraudDetection.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account getByAccountId(int payeeId);
}
