package com.example.supershopregular;

import java.sql.Date;
import java.sql.Timestamp;

public class Products {
int pID,quanityStock,supplierId;
double price;
String pName,pCategory,pBrand,pDesc;
Date pExpireDate;
Timestamp pAddedDate;

    public Products(int pID, int quanityStock, int supplierId, double price, String pName, String pCategory, String pBrand, String pDesc, Date pExpireDate, Timestamp pAddedDate) {
        this.pID = pID;
        this.quanityStock = quanityStock;
        this.supplierId = supplierId;
        this.price = price;
        this.pName = pName;
        this.pCategory = pCategory;
        this.pBrand = pBrand;
        this.pDesc = pDesc;
        this.pExpireDate = pExpireDate;
        this.pAddedDate = pAddedDate;
    }

    public int getPID() {
        return pID;
    }

    public void setPID(int pID) {
        this.pID = pID;
    }

    public int getQuanityStock() {
        return quanityStock;
    }

    public void setQuanityStock(int quanityStock) {
        this.quanityStock = quanityStock;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getPCategory() {
        return pCategory;
    }

    public void setPCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getPBrand() {
        return pBrand;
    }

    public void setPBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getPDesc() {
        return pDesc;
    }

    public void setPDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public Date getPExpireDate() {
        return pExpireDate;
    }

    public void setPExpireDate(Date pExpireDate) {
        this.pExpireDate = pExpireDate;
    }

    public Timestamp getPAddedDate() {
        return pAddedDate;
    }

    public void setPAddedDate(Timestamp pAddedDate) {
        this.pAddedDate = pAddedDate;
    }
}
