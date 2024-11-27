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
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage=new Stage();
        scene = new Scene(loadFXML("AdminLogin"));
        stage.setHeight(340);
        stage.setWidth(560);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void onClickCmanager(ActionEvent event) throws IOException {
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage=new Stage();
        scene = new Scene(loadFXML("Cmanager"));
        stage.setHeight(340);
        stage.setWidth(560);
        stage.setScene(scene);
        stage.show();
    }
}
