package com.example.supershopregular;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import backend.RetrieveProducts;
import backend.RetrieveTransaction;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class TransactionDetails implements Initializable{
    @FXML
    private TableView<Transaction> transactionTable;
    @FXML
    private TableColumn<Transaction, Integer> cID;

    @FXML
    private TableColumn<Transaction, Void> ops;

    @FXML
    private TableColumn<Transaction, Double> tAmount;

    @FXML
    private TableColumn<Transaction, Timestamp> tDate;

    @FXML
    private TableColumn<Transaction, Integer> tID;

    @FXML
    private TableColumn<Transaction, String> tRemark;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tID.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        cID.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        tDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        tRemark.setCellValueFactory(new PropertyValueFactory<>("remark"));
        tAmount.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        RetrieveTransaction retrieveTransaction = new RetrieveTransaction();
        ObservableList<Transaction> transactionList;
        try {
            transactionList = retrieveTransaction.getTransactions();
            transactionTable.setItems(transactionList);
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
                    Transaction selected = getTableView().getItems().get(getIndex());
                    handleEdit(selected);
                });

                deleteButton.setOnAction(event -> {
                    Transaction selected = getTableView().getItems().get(getIndex());
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

    @FXML
    public void handleEdit(Transaction transaction) {
        System.out.println("Edit clicked for: " + transaction.getTransactionId());
        // Implement your edit logic
    }

    // Define the delete action
    @FXML
    public void handleDelete(Transaction transaction) {
        System.out.println("Delete clicked for: " + transaction.getTransactionId());
        // Implement your delete logic
    }

    @FXML
    public void onClickBackHome(ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("DashboardAdmin"));
    }
}
