package com.example.supershopregular;

public class Customer {
    int customerID;
    String cFirstName,cLastName,cEmail,cPhone, cAddress,cRegDate;
    double totalSpend;

    public Customer(int customerID, String cFirstName, String cLastName, String cEmail, String cPhone, String cAddress, String cRegDate, double totalSpend) {
        this.customerID = customerID;
        this.cFirstName = cFirstName;
        this.cLastName = cLastName;
        this.cEmail = cEmail;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cRegDate = cRegDate;
        this.totalSpend = totalSpend;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getcFirstName() {
        return cFirstName;
    }

    public void setcFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getcLastName() {
        return cLastName;
    }

    public void setcLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcRegDate() {
        return cRegDate;
    }

    public void setcRegDate(String cRegDate) {
        this.cRegDate = cRegDate;
    }

    public double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(double totalSpend) {
        this.totalSpend = totalSpend;
    }
}
