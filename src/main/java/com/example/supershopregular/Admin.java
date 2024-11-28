package com.example.supershopregular;

public class Admin {
    private int adminId;       // Primary key
    private String adminName,adminDob,adminNid,adminPhone,adminEmail,adminAddress,adminPassword;

    public Admin(int adminId, String adminName, String adminDob, String adminNid, String adminPhone, String adminEmail, String adminAddress, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminDob = adminDob;
        this.adminNid = adminNid;
        this.adminPhone = adminPhone;
        this.adminEmail = adminEmail;
        this.adminAddress = adminAddress;
        this.adminPassword = adminPassword;
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminDob() {
        return adminDob;
    }

    public void setAdminDob(String adminDob) {
        this.adminDob = adminDob;
    }

    public String getAdminNid() {
        return adminNid;
    }

    public void setAdminNid(String adminNid) {
        this.adminNid = adminNid;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}
