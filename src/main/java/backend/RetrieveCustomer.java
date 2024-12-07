package backend;

import com.example.supershopregular.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.sql.SQLException;

public class RetrieveCustomer {
    public ObservableList<Customer> getCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<Customer> customerList = FXCollections.observableArrayList();
        String query = "SELECT * FROM customer";

        DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
        Connection con = dbmsConnect.getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            customerList.add(new Customer(
                    rs.getInt("customerID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getTimestamp("registrationDate"), // MySQL TIMESTAMP column
                    rs.getDouble("totalSpend")
            ));
        }
        System.out.println("Data retrieved successfully.");
        return customerList;
    }
}
