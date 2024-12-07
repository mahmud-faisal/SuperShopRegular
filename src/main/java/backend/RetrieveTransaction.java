package backend;

import com.example.supershopregular.Cmanager;
import com.example.supershopregular.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class RetrieveTransaction {
    public ObservableList<Transaction> getTransactions() throws SQLException, ClassNotFoundException {
        ObservableList<Transaction> transactionList = FXCollections.observableArrayList();
        String query = "SELECT * FROM transactions";

        DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
        Connection con = dbmsConnect.getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            transactionList.add(new Transaction(
                    rs.getInt("transactionID"),
                    rs.getInt("customerID"),
                    rs.getTimestamp("transactionDate"), // MySQL TIMESTAMP column
                    rs.getString("remarks"),
                    rs.getDouble("totalAmount")
            ));
        }
        System.out.println("Transaction Data retrieved successfully.");
        return transactionList;
    }
    }
