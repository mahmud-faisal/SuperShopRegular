package com.example.supershopregular;

import backend.InsertProduct;
import backend.UpdateProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.Timestamp;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.ProductDetails.dataGur;


public class EditProduct {
    @FXML
    private TextField epaBrand;
    @FXML
    private TextField epaCategory;
    @FXML
    private TextField epaDesc;
    @FXML
    private DatePicker epaExpire;
    @FXML
    private TextField epaName;
    @FXML
    private TextField epaPrice;
    @FXML
    private TextField epaQuantity;
    @FXML
    private TextField epaSupplierID;


    @FXML
    public void editProductDetails(ActionEvent event) {
        String name = epaName.getText();
        String category = epaCategory.getText();
        String brand = epaBrand.getText();
        String desc = epaDesc.getText();
        double price = Double.parseDouble(epaPrice.getText());
        int quantity = Integer.parseInt(epaQuantity.getText());
        int supplierID = Integer.parseInt(epaSupplierID.getText());
        Date expireDate = Date.valueOf(epaExpire.getValue());
        Timestamp addedDate = new Timestamp(System.currentTimeMillis());
        EditProduct emp = new EditProduct();
        int rcvDataGur = dataGur;
        Products product = new Products(rcvDataGur, quantity, supplierID, price, name, category, brand, desc, expireDate, addedDate);

        UpdateProduct updater = new UpdateProduct();
        updater.updateProduct(product);
        Stage nstage = new Stage();
        Scene nscene = null;
        try {
            nscene = new Scene(loadFXML("UpdateConfirmation"));
        } catch (Exception _) {
        }
        nstage.setScene(nscene);
        nstage.show();
        System.out.println("Edit Successful");
    }


}
