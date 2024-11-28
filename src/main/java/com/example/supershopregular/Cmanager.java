package com.example.supershopregular;

public class Cmanager {
    private int cmId;             // Primary Key
    private String name,dob,nid,joiningDate,phone,email,address,password;

    public Cmanager(int cmId, String name, String dob, String nid, String joiningDate, String phone, String email, String address, String password) {
        this.cmId = cmId;
        this.name = name;
        this.dob = dob;
        this.nid = nid;
        this.joiningDate = joiningDate;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public int getCmId() {
        return cmId;
    }

    public void setCmId(int cmId) {
        this.cmId = cmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
