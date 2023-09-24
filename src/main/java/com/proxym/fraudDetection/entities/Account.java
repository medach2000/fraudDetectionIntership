package com.proxym.fraudDetection.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;


    @OneToMany
    @JoinColumn(name="transactionIdFk")
    private List<Transaction> transactions;

    private double balance;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public List<Integer> beneficiaries;


    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account() {
        System.out.print("Account Constructor called");
        this.transactions = new ArrayList<Transaction>();
        this.beneficiaries = new ArrayList<Integer>();
        this.balance = 500000;
    }

    public List<Integer> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(List<Integer> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }
}
