package com.bankapp.entity;

import java.time.LocalDate;

public class Transaction {
    private LocalDate transactionDate;
    private String userId;
    private double transactionAmount;
    private String transactionType;
    private double initialBalance;
    private double finalBalance;
    private String transactionPerformedBy;

    public Transaction(LocalDate transactionDate, String userId, double transactionAmount, String transactionType, double initialBalance, double finalBalance, String transactionPerformedBy) {
        this.transactionDate = transactionDate;
        this.userId = userId;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
        this.transactionPerformedBy = transactionPerformedBy;
    }


    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate=" + transactionDate +
                ", userId='" + userId + '\'' +
                ", transactionAmount=" + transactionAmount +
                ", transactionType='" + transactionType + '\'' +
                ", initialBalance=" + initialBalance +
                ", finalBalance=" + finalBalance +
                ", transactionPerformedBy='" + transactionPerformedBy + '\'' +
                '}';
    }
}
