package com.example.supershopregular;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import backend.RetrieveCManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;


public class ShowCmanagerList implements Initializable {


        @FXML
        private ResourceBundle resources;

        @FXML
        private URL location;
        @FXML
        private TableView<Cmanager> cmanagerTable;
        @FXML
        private TableColumn< Cmanager, String> cmAddress;

        @FXML
        private TableColumn<Cmanager, String> cmEmail;

        @FXML
        private TableColumn<Cmanager, Integer> cmId;

        @FXML
        private TableColumn<Cmanager, String> cmNID;

        @FXML
        private TableColumn<Cmanager, String> cmName;

        @FXML
        private TableColumn<Cmanager, String> cmPhone;

    @FXML
    private TableColumn<Cmanager, Date> cmDob;

    @FXML
    private TableColumn<Cmanager, Timestamp> cmJoiningDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmId.setCellValueFactory(new PropertyValueFactory<>("cmId"));
        cmName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        cmDob.setCellValueFactory(new PropertyValueFactory<>("dob")); // Add DOB
        cmNID.setCellValueFactory(new PropertyValueFactory<>("nid"));
        cmPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
//        cmJoiningDate.setCellValueFactory(new PropertyValueFactory<>("joiningDate")); // Add Joining Date

        // Fetch data and populate TableView
        RetrieveCManager retrieveCManager = new RetrieveCManager();
        ObservableList<Cmanager> cmanagerList;
        try {
            cmanagerList = retrieveCManager.getCManagers();
            cmanagerTable.setItems(cmanagerList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        cmanagerTable.setItems(cmanagerList);
    }

    @FXML
    public void onClickBackHome(ActionEvent event) throws IOException {

        scene.setRoot(loadFXML("DashboardAdmin"));
    }


}
