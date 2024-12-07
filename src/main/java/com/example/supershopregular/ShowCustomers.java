package com.example.supershopregular;

import backend.RetrieveCustomer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class ShowCustomers implements Initializable {
    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> cAddress;

    @FXML
    private TableColumn<Customer, String> cEmail;

    @FXML
    private TableColumn<Customer, Integer> cId;

//    @FXML
//    private TableColumn<Cmanager, String> cmNID;

    @FXML
    private TableColumn<Customer, String> cName;

    @FXML
    private TableColumn<Customer, String> cPhone;

    @FXML
    private TableColumn<Customer, Void> ops;

    @FXML
    private TableColumn<Customer, Double> cSpend;

    @FXML
    private TableColumn<Customer, Timestamp> cRegDate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cId.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        cName.setCellValueFactory(new PropertyValueFactory<>("cFirstName"));
//        cmNID.setCellValueFactory(new PropertyValueFactory<>("nid"));
        cPhone.setCellValueFactory(new PropertyValueFactory<>("cPhone"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("cEmail"));
        cAddress.setCellValueFactory(new PropertyValueFactory<>("cAddress"));
        cRegDate.setCellValueFactory(new PropertyValueFactory<>("cRegDate"));
        cSpend.setCellValueFactory(new PropertyValueFactory<>("totalSpend"));
        // Fetch data and populate TableView
        RetrieveCustomer retrieveCustomer = new RetrieveCustomer();
        ObservableList<Customer> customerList;
        try {
            customerList = retrieveCustomer.getCustomer();
            customerTable.setItems(customerList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Add Edit/Delete buttons in the 'ops' column
        ops.setCellFactory(param -> new TableCell<>() {
            private final Button editButton = new Button("Update");
            private final Button deleteButton = new Button("Remove");
            private final HBox buttonsBox = new HBox(editButton, deleteButton);

            {
                buttonsBox.setSpacing(10);
                editButton.setStyle("-fx-background-color: green; -fx-text-fill: white;-fx-cursor:hand;-fx-font-weight:bold");
                deleteButton.setStyle("-fx-background-color: red; -fx-text-fill: white;-fx-cursor:hand;-fx-font-weight:bold");
                editButton.setOnAction(event -> {
                    Customer selected = getTableView().getItems().get(getIndex());
                    handleEdit(selected);
                });

                deleteButton.setOnAction(event -> {
                    Customer selected = getTableView().getItems().get(getIndex());
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
    public void handleEdit(Customer cmanager) {
        System.out.println("Edit clicked for: " + cmanager.getCustomerID());
        // Implement your edit logic
    }

    // Define the delete action
    @FXML
    public void handleDelete(Customer cmanager) {
        System.out.println("Delete clicked for: " + cmanager.getCustomerID());
        // Implement your delete logic
    }

    @FXML
    public void onClickBackHome(ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("DashboardAdmin"));
    }
}
