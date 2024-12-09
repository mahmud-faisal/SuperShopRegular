package com.example.supershopregular;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static backend.LoginCheck.accountName;
import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class Dashboard {
    @FXML
    public void onClickProducts(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("ProductDetails"));
    }
    @FXML
    private Label accountHolder;

    @FXML
    public void initialize() {
        accountHolder.setText(accountName);  // Set the account name when the view is initialized
    }
    @FXML
    public void onClickTransaction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("TransactionDetails"));
    }

    @FXML
    public void onClickSell(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("Sell"));
    }

}
