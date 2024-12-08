package backend;

import com.example.supershopregular.Products;

import java.sql.*;

public class InsertProduct {
    public void insertProduct(Products product) {
        try {
            DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
            Connection con = dbmsConnect.getConnection();

            String sql = "INSERT INTO products (productName, category, brand, description, price, quantityInStock, supplierID, expirationDate, addedDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, product.getPName());
            stmt.setString(2, product.getPCategory());
            stmt.setString(3, product.getPBrand());
            stmt.setString(4, product.getPDesc());
            stmt.setDouble(5, product.getPrice());
            stmt.setInt(6, product.getQuanityStock());
            stmt.setInt(7, product.getSupplierId());
            stmt.setDate(8, product.getPExpireDate());
            stmt.setTimestamp(9, product.getPAddedDate());

            int i = stmt.executeUpdate();
            System.out.println("Inserted rows: " + i);
            dbmsConnect.closeConnection(con, stmt);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
