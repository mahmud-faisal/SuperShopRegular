package com.example.supershopregular;

import backend.DBMSConnection;
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
    private TextField sQuantity;

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
    private final Timestamp sellDate = new Timestamp(System.currentTimeMillis());
    private static double soldPrice;
    private java.lang.Integer Integer;

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
            System.out.println("Okay 5454");

        }
        else {
            System.out.println("No matching rows found.");
        }


        int updatedQuantity;
        double totalPrice;

        System.out.println("Haha:"+sQuantity.getText());
        int soldQuan = Integer.parseInt(sQuantity.getText());
        System.out.println(soldQuan);
        totalPrice  = soldQuan *  unitPrice ;
        updatedQuantity =  quantity - soldQuan;
        String sql="UPDATE products SET quantityInStock = ? WHERE productID = ?";
        PreparedStatement statements = con.prepareStatement(sql);
        statements.setInt(1, updatedQuantity);
        statements.setInt(2, pID);
        int rowsUpdated = statements.executeUpdate();
        soldPrice=totalPrice;
        System.out.println("Sold price:" + soldPrice);
    }

    @FXML
    public void handleSell(javafx.event.ActionEvent event) throws SQLException, ClassNotFoundException {
//        double price = Double.parseDouble(sTotal.getText());
        Sell sell = new Sell();
        sell.priceAndStock(java.lang.Integer.parseInt(sPID.getText()));
        Transaction sellTrans = new Transaction(0,0,sellDate,sRemark.getText(),soldPrice);
        InsertTransaction insTran = new InsertTransaction();
        insTran.insertTransaction(sellTrans);
        Customer sellCustomer = new Customer(0,sCName.getText(),"",sEmail.getText(),sPhone.getText(),sAddress.getText(),sellDate,soldPrice);
        InsertCustomer insCos = new InsertCustomer();
        insCos.insertCustomer(sellCustomer);
        System.out.println("Sold");
    }
    @FXML
    public void onClickBackHome(javafx.event.ActionEvent event) throws IOException {
        scene.setRoot(loadFXML("DashboardAdmin"));
    }
}
