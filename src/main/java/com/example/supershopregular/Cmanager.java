package com.example.supershopregular;

import java.sql.Date;
import java.sql.Timestamp;

public class Cmanager {
    private int cmId; // Primary Key
    private String name, nid, phone, email, address, password;
    private Date dob; // For MySQL DATE
    private Timestamp joiningDate; // For MySQL TIMESTAMP

    public Cmanager(int cmId, String name, Date dob, String nid, Timestamp joiningDate, String phone, String email, String address, String password) {
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

    // Getters and Setters
    public int getCmId() { return cmId; }
    public void setCmId(int cmId) { this.cmId = cmId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getNid() { return nid; }
    public void setNid(String nid) { this.nid = nid; }

    public Timestamp getJoiningDate() { return joiningDate; }
    public void setJoiningDate(Timestamp joiningDate) { this.joiningDate = joiningDate; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
