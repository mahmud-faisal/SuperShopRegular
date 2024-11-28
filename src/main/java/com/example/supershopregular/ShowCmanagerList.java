package com.example.supershopregular;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ShowCmanagerList {

        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;

        @FXML
        private TableColumn< ?, ?> cmAddress;

        @FXML
        private TableColumn<?, ?> cmEmail;

        @FXML
        private TableColumn<?, ?> cmId;

        @FXML
        private TableColumn<?, ?> cmNID;

        @FXML
        private TableColumn<?, ?> cmName;

        @FXML
        private TableColumn<?, ?> cmPhone;

        @FXML
        void initialize() {
            assert cmAddress != null : "fx:id=\"cmAddress\" was not injected: check your FXML file 'showCmanagerList.fxml'.";
            assert cmEmail != null : "fx:id=\"cmEmail\" was not injected: check your FXML file 'showCmanagerList.fxml'.";
            assert cmId != null : "fx:id=\"cmId\" was not injected: check your FXML file 'showCmanagerList.fxml'.";
            assert cmNID != null : "fx:id=\"cmNID\" was not injected: check your FXML file 'showCmanagerList.fxml'.";
            assert cmName != null : "fx:id=\"cmName\" was not injected: check your FXML file 'showCmanagerList.fxml'.";
            assert cmPhone != null : "fx:id=\"cmPhone\" was not injected: check your FXML file 'showCmanagerList.fxml'.";

        }



}
