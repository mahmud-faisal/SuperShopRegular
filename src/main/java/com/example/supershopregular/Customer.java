package com.example.supershopregular;

import java.sql.Timestamp;

public class Customer {
    int customerID;
    String cFirstName,cLastName,cEmail,cPhone, cAddress;
    double totalSpend;
    private Timestamp cRegDate;

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCFirstName() {
        return cFirstName;
    }

    public void setCFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCPhone() {
        return cPhone;
    }

    public void setCPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }

    public Timestamp getCRegDate() {
        return cRegDate;
    }

    public void setCRegDate(Timestamp cRegDate) {
        this.cRegDate = cRegDate;
    }

    public Customer(int customerID, String cFirstName, String cLastName, String cEmail, String cPhone, String cAddress, Timestamp cRegDate, double totalSpend) {
        this.customerID = customerID;
        this.cFirstName = cFirstName;
        this.cLastName = cLastName;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cRegDate = cRegDate;
        this.totalSpend = totalSpend;
    }


}
