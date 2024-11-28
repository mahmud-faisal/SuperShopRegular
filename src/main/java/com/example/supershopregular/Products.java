package com.example.supershopregular;

public class Products {
int pID,quanityStock,supplierId;
double price;
String pName,pCategory,pBrand,pDesc,pExpireDate,pAddedDate;

    public Products(int pID, int quanityStock, int supplierId, double price, String pName, String pCategory, String pBrand, String pDesc, String pExpireDate, String pAddedDate) {
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

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
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

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpCategory() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory = pCategory;
    }

    public String getpBrand() {
        return pBrand;
    }

    public void setpBrand(String pBrand) {
        this.pBrand = pBrand;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public String getpExpireDate() {
        return pExpireDate;
    }

    public void setpExpireDate(String pExpireDate) {
        this.pExpireDate = pExpireDate;
    }

    public String getpAddedDate() {
        return pAddedDate;
    }

    public void setpAddedDate(String pAddedDate) {
        this.pAddedDate = pAddedDate;
    }
}
