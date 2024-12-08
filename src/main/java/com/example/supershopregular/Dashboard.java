package com.example.supershopregular;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class Dashboard {
    @FXML
    public void onClickProducts(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("ProductDetails"));
    }
    @FXML
    public void onClickTransaction(ActionEvent event) throws IOException {
        System.out.println("Clicked on Product Detail");
        scene.setRoot(loadFXML("TransactionDetails"));
    }

}
