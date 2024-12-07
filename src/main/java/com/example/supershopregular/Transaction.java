package com.example.supershopregular;

import java.sql.Timestamp;

public class Transaction {
    int transactionId,customerId;
    String remark;
    Timestamp transactionDate;
    double totalAmount;


    public Transaction(int transactionId, int customerId, Timestamp transactionDate, String remark, double totalAmount) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.transactionDate = transactionDate;
        this.remark = remark;
        this.totalAmount = totalAmount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
