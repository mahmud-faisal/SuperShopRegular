package com.example.supershopregular;


import backend.InsertProduct;
import javafx.scene.control.*;
import javafx.fxml.FXML;

import java.sql.*;


public class AddProduct {
    @FXML
    private TextField paBrand;

    @FXML
    private TextField paCategory;

    @FXML
    private TextField paDesc;

    @FXML
    private DatePicker paExpire;
    @FXML
    private TextField paName;

    @FXML
    private TextField paPrice;

    @FXML
    private TextField paQuantity;

    @FXML
    private TextField paSupplierID;

    @FXML
    private Label wrongAlert;


    @FXML
    private void handleAddProduct() {
        try {
            String name = paName.getText();
            String category = paCategory.getText();
            String brand = paBrand.getText();
            String desc = paDesc.getText();
            double price = Double.parseDouble(paPrice.getText());
            int quantity = Integer.parseInt(paQuantity.getText());
            int supplierID = Integer.parseInt(paSupplierID.getText());
            Date expireDate = Date.valueOf(paExpire.getValue());
            Timestamp addedDate = new Timestamp(System.currentTimeMillis());

            Products product = new Products(0, quantity, supplierID, price, name, category, brand, desc, expireDate, addedDate);
            InsertProduct inserter = new InsertProduct();
            inserter.insertProduct(product);

            wrongAlert.setText("Product added successfully!");
        } catch (Exception e) {
            wrongAlert.setText("Error: " + e.getMessage());
        }
    }
}
