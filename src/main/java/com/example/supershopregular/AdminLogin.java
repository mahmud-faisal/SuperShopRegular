package com.example.supershopregular;
import backend.DBMSConnection;
import backend.LoginCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.sql.SQLException;

import static com.example.supershopregular.HelloApplication.loadFXML;
import static com.example.supershopregular.HelloApplication.scene;

public class AdminLogin {
    @FXML
    private PasswordField pass;

    @FXML
    private TextField userId;

    @FXML
    private Label wrongAlert;

    private String passText,userIdText;

    public String getPassText() {
        return passText;
    }

    public String getUserIdText() {
        return userIdText;
    }

    public AdminLogin() {
    }
    public AdminLogin( String userId,String pass) {

        this.passText = pass;
        this.userIdText = userId;
    }



    @FXML
    public void logInAdmin(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        passText =  pass.getText();
        userIdText = userId.getText();

        AdminLogin al = new AdminLogin(userId.getText(),pass.getText());
        LoginCheck lc= new LoginCheck();
         boolean authenticated = lc.authLogin(al.getUserIdText(),al.getPassText(),"admin");
         if(authenticated || true){
             Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
             stage.close();
             scene.setRoot(loadFXML("DashboardAdmin"));

         }
         else{
             wrongAlert.setText("Wrong User ID or Password! Try again.");
         }


    }

}
