package com.example.supershopregular;
import backend.DBMSConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static com.example.supershopregular.HelloApplication.loadFXML;

public class AdminLogin {
    @FXML
    public void logInAdmin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
        Connection con = null;
        con = dbmsConnect.getConnection();
    }

}
