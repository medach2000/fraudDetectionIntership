package com.proxym.fraudDetection.repositories;

import com.proxym.fraudDetection.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> findByPayerId(int accountId);
    List<Transaction> findByPayeeId(int accountId);
    List<Transaction> findByPayerIdOrPayeeId(int accountId, int account2Id);
}
