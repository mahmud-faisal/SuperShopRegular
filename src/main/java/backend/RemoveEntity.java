package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RemoveEntity {
    public void removeEntity(int id,String selector,String table){
        try {
            DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
            Connection con = dbmsConnect.getConnection();

            String sql = "DELETE FROM " + table + " WHERE "+ selector +" = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            System.out.println("ID:"+id);
            dbmsConnect.closeConnection(con, stmt);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
