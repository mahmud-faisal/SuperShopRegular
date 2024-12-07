package backend;

import com.example.supershopregular.Cmanager;
import com.example.supershopregular.Products;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class RetrieveProducts {
    public ObservableList<Products> getProducts() throws SQLException, ClassNotFoundException {
        ObservableList<Products> productList = FXCollections.observableArrayList();
        String query = "SELECT * FROM products";

        DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
        Connection con = dbmsConnect.getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            productList.add(new Products(
                    rs.getInt("productID"),
                    rs.getInt("quantityInStock"),
                    rs.getInt("supplierID"),
                    rs.getDouble("price"),
                    rs.getString("productName"),
                    rs.getString("category"),
                    rs.getString("brand"),
                    rs.getString("description"),
                    rs.getDate("expirationDate"), // MySQL DATE column

                    rs.getTimestamp("addedDate") // MySQL TIMESTAMP
            ));
        }
        System.out.println("Product Data retrieved successfully.");
        return productList;
    }
}
