package com.example.supershopregular;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.supershopregular.HelloApplication.loadFXML;

public class Home {
    private Stage stage;
    private Scene scene;

    @FXML
    public void onClickAdmin(ActionEvent event) throws IOException {
        // Open AdminLogin in a new window (Stage)
        stage = new Stage();
        scene = new Scene(loadFXML("AdminLogin"));
        stage.setHeight(340);
        stage.setWidth(560);
        stage.setScene(scene);
        stage.setTitle("Admin Login");
        stage.show();
    }

    @FXML
    public void onClickCmanager(ActionEvent event) throws IOException {
        // Handle other actions similarly
        stage = new Stage();
        scene = new Scene(loadFXML("CManagerLogin"));
        stage.setHeight(340);
        stage.setWidth(560);
        stage.setScene(scene);
        stage.show();
    }
}
