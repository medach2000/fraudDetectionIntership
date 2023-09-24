package com.proxym.fraudDetection.controllers;

import com.proxym.fraudDetection.entities.Transaction;
import com.proxym.fraudDetection.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequestMapping("api/transaction")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @GetMapping("/{id}")
    public ResponseEntity<List<Transaction>> disp(@PathVariable("id") int id){
        List<Transaction> transactions = transactionService.getTransactionsByAccountId(id);
        return ResponseEntity.ok(transactions);
    }
    @PostMapping(value = "/{id}/transaction")
    public ResponseEntity<String> newTransaction(@RequestBody Transaction transaction,@PathVariable("id") int id){
        Transaction tran = new Transaction();
        System.out.println(tran.getTransactionId());
        tran.setAmount(transaction.getAmount());
        tran.setPayeeId(transaction.getPayeeId());
        tran.setPayerId(transaction.getPayerId());
        tran.setTransactionType(transaction.getTransactionType());
        tran.setTransactionDate(new Date(System.currentTimeMillis()).toString());
        System.out.print(tran.getTransactionDate());
        tran.setRemarks(transaction.getRemarks());
        transactionService.createTransaction(tran,id);
        return ResponseEntity.ok("done");
    }
}
