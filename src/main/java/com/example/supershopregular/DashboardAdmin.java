package com.example.supershopregular;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

import backend.LoginCheck;

import static backend.LoginCheck.accountName;
import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class DashboardAdmin {
    @FXML
    private Label accountHolder;



    @FXML
    public void onClickProducts(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("ProductDetails"));
    }

    @FXML
    public void onClickCmanager(ActionEvent event) throws IOException {
        System.out.println("Clicked on C Manager");
        scene.setRoot(loadFXML("showCmanagerList"));
    }

    @FXML
    public void onClickCustomer(ActionEvent event) throws IOException {
        System.out.println("Clicked on C Manager");
        scene.setRoot(loadFXML("ShowCustomers"));
    }
    @FXML
    public void onClickTransaction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("TransactionDetails"));
    }


}
