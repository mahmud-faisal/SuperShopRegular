package com.example.supershopregular;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import backend.RemoveEntity;
import backend.RetrieveCManager;
import backend.RetrieveProducts;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;


public class ProductDetails implements Initializable {
    @FXML
    private TableView<Products> productTable;

    @FXML
    private TableColumn<Products, String> pBrand;

    @FXML
    private TableColumn<Products, String> pCategory;

    @FXML
    private TableColumn<Products, String> pDesc;

    @FXML
    private TableColumn<Products, Timestamp> pExpire;

    @FXML
    private TableColumn<Products, Integer> pID;

    @FXML
    private TableColumn<Products, String> pName;

    @FXML
    private TableColumn<Products, Double> pPrice;

    @FXML
    private TableColumn<Products, Integer> pStock;

    @FXML
    private TableColumn<Products, Void> ops;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pID.setCellValueFactory(new PropertyValueFactory<>("pID"));
        pName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        pDesc.setCellValueFactory(new PropertyValueFactory<>("pDesc"));
        pStock.setCellValueFactory(new PropertyValueFactory<>("quanityStock"));
        pCategory.setCellValueFactory(new PropertyValueFactory<>("pCategory"));
        pBrand.setCellValueFactory(new PropertyValueFactory<>("pBrand"));
        pPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        pExpire.setCellValueFactory(new PropertyValueFactory<>("pExpireDate"));

        RetrieveProducts retrieveProducts = new RetrieveProducts();
        ObservableList<Products> productList;
        try {
            productList = retrieveProducts.getProducts();
            productTable.setItems(productList);
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
                    Products selected = getTableView().getItems().get(getIndex());
                    handleEdit(selected);
                });

                deleteButton.setOnAction(event -> {
                    Products selected = getTableView().getItems().get(getIndex());
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
    public void handleEdit(Products product) {
        System.out.println("Edit clicked for: " + product.getPName());
        // Implement your edit logic
    }

    // Define the delete action
    @FXML
    public void handleDelete(Products product) {
        System.out.println("Delete clicked for: " + product.getPName());
        RemoveEntity removeEty = new RemoveEntity();
        removeEty.removeEntity(product.pID, "productID", "products");
        Stage nstage = new Stage();
        Scene nscene = null;
        try {
            nscene = new Scene(loadFXML("RemoveConfirmation"));
        } catch (Exception _) {
        }
        nstage.setScene(nscene);
        nstage.show();
    }

    @FXML
    public void onClickBackHome(ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("DashboardAdmin"));
    } @FXML
    public void onClickRefresh(ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("ProductDetails"));
    }
    @FXML
    public void onClickAddProduct(ActionEvent event) throws IOException {
        System.out.println("Clicked on Add Product");
        Stage stage = new Stage();
        Scene newScene = new Scene(loadFXML("AddProduct"));
        stage.setHeight(640);
        stage.setWidth(560);
        stage.setScene(newScene);
        stage.show();
    }
    }
