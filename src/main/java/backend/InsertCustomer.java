package backend;

import com.example.supershopregular.Cmanager;
import com.example.supershopregular.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertCustomer {
    public void insertCustomer(Customer customer) {
        try {
            DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
            Connection con = dbmsConnect.getConnection();

            String sql = "INSERT INTO customer (INSERT INTO customer (firstName, lastName, email, phone, address, totalSpend, regDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, customer.getCFirstName());
            stmt.setString(2, customer.getCLastName());
            stmt.setString(3, customer.getCEmail());
            stmt.setString(4, customer.getCPhone());
            stmt.setString(5, customer.getCAddress());
            stmt.setDouble(6, customer.getTotalSpend());
            stmt.setTimestamp(7, customer.getCRegDate());



            int i = stmt.executeUpdate();
            System.out.println("Inserted rows: " + i);
            dbmsConnect.closeConnection(con, stmt);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
