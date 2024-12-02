package com.example.supershopregular;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class DashboardAdmin {
    @FXML
    public void onClickCmanager(ActionEvent event) throws IOException {
        System.out.println("Clicked on C Manager");
        scene.setRoot(loadFXML("showCmanagerList"));
    }

}
