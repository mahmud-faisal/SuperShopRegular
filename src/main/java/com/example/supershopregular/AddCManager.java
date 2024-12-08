package com.example.supershopregular;

import backend.InsertCManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;
import java.sql.Timestamp;


public class AddCManager {
    @FXML
    private TextField naAddress;

    @FXML
    private DatePicker naDOB;

    @FXML
    private TextField naEmail;

    @FXML
    private TextField naNID;

    @FXML
    private TextField naName;

    @FXML
    private TextField naPassword;

    @FXML
    private TextField naPhone;
    @FXML
    private Label wrongAlert;

    @FXML
    private void handleAddProduct() {
        try {
            String name = naName.getText();
            String address = naAddress.getText();
            String email = naEmail.getText();
            String nid = naNID.getText();
            String phone = naPhone.getText();
            String password = naPassword.getText();
            Date dob = Date.valueOf(naDOB.getValue());
            Timestamp addedDate = new Timestamp(System.currentTimeMillis());

            Cmanager cmanager = new Cmanager(0,name,dob, nid, addedDate, phone, email, address, password);
            InsertCManager inserter = new InsertCManager();
            inserter.insertCManager(cmanager);

            wrongAlert.setText("Counter Manager added successfully!");
        } catch (Exception e) {
            wrongAlert.setText("Error: " + e.getMessage());
        }
    }
}
