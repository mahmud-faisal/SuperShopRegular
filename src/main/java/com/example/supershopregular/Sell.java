package com.example.supershopregular;

import backend.DBMSConnection;
import backend.InsertCManager;
import backend.InsertCustomer;
import backend.InsertTransaction;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.*;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class Sell {
    @FXML
    private TextField paQuantity;

    @FXML
    private TextField sAddress;

    @FXML
    private TextField sCName;

    @FXML
    private TextField sEmail;

    @FXML
    private TextField sPID;

    @FXML
    private TextField sPhone;
    @FXML
    private TextField sRemark;

//    @FXML
//    private Label sQuan;
    private Timestamp sellDate = new Timestamp(System.currentTimeMillis());
    private static double soldPrice;
    public void priceAndStock(int pID) throws SQLException, ClassNotFoundException {
        DBMSConnection dbmsConnect=new DBMSConnection("jdbc:mysql://localhost:3306/shopease","root","");
        Connection con=dbmsConnect.getConnection();
        double unitPrice = 0;
        int quantity = 0;
        String query = "SELECT price,quantityInStock FROM products WHERE productID = ?";
        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, pID);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            quantity = rs.getInt("quantityInStock");
            unitPrice = rs.getDouble("price");

        }
        else {
            System.out.println("No matching rows found.");
        }


        int updatedQuantity;
        double totalPrice;
        int soldQuan;
        soldQuan = Integer.parseInt(paQuantity.getText());
        totalPrice  = soldQuan *  unitPrice ;
        updatedQuantity =  quantity - soldQuan;
        String sql="UPDATE products SET quantityInStock = ? WHERE productID = ?";
        PreparedStatement statements = con.prepareStatement(sql);
        statements.setInt(1, updatedQuantity);
        statements.setInt(2, pID);
        int rowsUpdated = statements.executeUpdate();
        soldPrice=totalPrice;

    }

    @FXML
    public void handleSell(javafx.event.ActionEvent event){
//        double price = Double.parseDouble(sTotal.getText());
        Transaction sellTrans = new Transaction(0,0,sellDate,sRemark.getText(),soldPrice);
        InsertTransaction insTran = new InsertTransaction();
        insTran.insertTransaction(sellTrans);
        Customer sellCustomer = new Customer(0,sCName.getText(),"",sEmail.getText(),sPhone.getText(),sAddress.getText(),sellDate,soldPrice);
        InsertCustomer insCos = new InsertCustomer();
        insCos.insertCustomer(sellCustomer);
    }
    @FXML
    public void onClickBackHome(javafx.event.ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("DashboardAdmin"));
    }
}
