package backend;

import com.example.supershopregular.Cmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertCManager {
    public void insertCManager(Cmanager cmanager) {
        try {
            DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
            Connection con = dbmsConnect.getConnection();

            String sql = "INSERT INTO counter_manager (name, dob, nid, phone, email, address, passwrd) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cmanager.getName());
            stmt.setDate(2, cmanager.getDob());
            stmt.setString(3, cmanager.getNid());
            stmt.setString(4, cmanager.getPhone());
            stmt.setString(5, cmanager.getEmail());
            stmt.setString(6, cmanager.getAddress());
            stmt.setString(7, cmanager.getPassword());


            int i = stmt.executeUpdate();
            System.out.println("Inserted rows: " + i);
            dbmsConnect.closeConnection(con, stmt);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
