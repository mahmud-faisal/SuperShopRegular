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
import javafx.scene.layout.HBox;

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
    private TableColumn<Cmanager, String> cmAddress;

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
    private TableColumn<Cmanager, Void> ops;

    @FXML
    private TableColumn<Cmanager, Date> cmDob;

    @FXML
    private TableColumn<Cmanager, Timestamp> cmJoiningDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmId.setCellValueFactory(new PropertyValueFactory<>("cmId"));
        cmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cmNID.setCellValueFactory(new PropertyValueFactory<>("nid"));
        cmPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        // Fetch data and populate TableView
        RetrieveCManager retrieveCManager = new RetrieveCManager();
        ObservableList<Cmanager> cmanagerList;
        try {
            cmanagerList = retrieveCManager.getCManagers();
            cmanagerTable.setItems(cmanagerList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Add Edit/Delete buttons in the 'ops' column
        ops.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Update");
            private final Button deleteButton = new Button("Delete");
            private final HBox buttonsBox = new HBox(editButton, deleteButton);

            {
                buttonsBox.setSpacing(10);
                editButton.setStyle("-fx-background-color: green; -fx-text-fill: white;-fx-cursor:hand;-fx-font-weight:bold");
                deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-cursor:hand;-fx-font-weight:bold");
                editButton.setOnAction(event -> {
                    Cmanager selected = getTableView().getItems().get(getIndex());
                    handleEdit(selected);
                });

                deleteButton.setOnAction(event -> {
                    Cmanager selected = getTableView().getItems().get(getIndex());
                    handleDelete(selected);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getTableView().getItems().get(getIndex()) == null) {
                    setGraphic(null);
                } else {
                    setGraphic(buttonsBox);
                }
            }
        });
    }

    // Define the edit action
    @FXML
    public void handleEdit(Cmanager cmanager) {
        System.out.println("Edit clicked for: " + cmanager.getName());
        // Implement your edit logic
    }

    // Define the delete action
    @FXML
    public void handleDelete(Cmanager cmanager) {
        System.out.println("Delete clicked for: " + cmanager.getName());
        // Implement your delete logic
    }

    @FXML
    public void onClickBackHome(ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("DashboardAdmin"));
    }
}
