package backend;

import com.example.supershopregular.Cmanager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class RetrieveCManager {
    public ObservableList<Cmanager> getCManagers() throws SQLException, ClassNotFoundException {
        ObservableList<Cmanager> cmanagerList = FXCollections.observableArrayList();
        String query = "SELECT * FROM counter_manager";

        DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
        Connection con = dbmsConnect.getConnection();
        PreparedStatement stmt = con.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            cmanagerList.add(new Cmanager(
                    rs.getInt("cmId"),
                    rs.getString("name"),
                    rs.getDate("dob"), // MySQL DATE column
                    rs.getString("nid"),
                    rs.getTimestamp("joining_date"), // MySQL TIMESTAMP column
                    rs.getString("phone"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("passwrd") // Column name corrected
            ));
        }
        System.out.println("Data retrieved successfully.");
        return cmanagerList;
    }
}
