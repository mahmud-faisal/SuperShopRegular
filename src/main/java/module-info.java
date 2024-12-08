module com.example.supershopregular {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;


    opens com.example.supershopregular to javafx.fxml;
    exports com.example.supershopregular;
}