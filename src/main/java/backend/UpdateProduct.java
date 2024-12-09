package backend;

import com.example.supershopregular.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProduct {
    public void updateProduct(Products product) {
        try {
            DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
            Connection con = dbmsConnect.getConnection();

            String sql = "UPDATE products SET productName = ?, category = ?, brand = ?, description = ?, price = ?, " +
                    "quantityInStock = ?, supplierID = ?, expirationDate = ?, addedDate = ? WHERE productID = ?";
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
            stmt.setInt(10, product.getPID()); // Adding the WHERE condition

            int rowsUpdated = stmt.executeUpdate();
            System.out.println("Updated rows: " + rowsUpdated);

            dbmsConnect.closeConnection(con, stmt);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
