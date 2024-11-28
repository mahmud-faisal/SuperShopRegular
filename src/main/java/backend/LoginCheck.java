package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginCheck {
    private String userId;
    private String password;
    public LoginCheck(String userId,String password) {
        this.userId = userId;
        this.password = password;
    }

    public LoginCheck() {
    }

    public static boolean authLogin(String userId, String password, String table) throws SQLException, ClassNotFoundException {
        // Initialize the database connection
        DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
        Connection con = dbmsConnect.getConnection();


        String query = "SELECT EMAIL, PHONE, PASSWRD FROM " + table + " WHERE (EMAIL = ? OR PHONE = ?)";
        PreparedStatement stmt = con.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        stmt.setString(1, userId);
        stmt.setString(2, userId);


        ResultSet rs = stmt.executeQuery();


        boolean match = false;
        if (rs.next()) {
//            rs.previous();
            String dbPassword = rs.getString("PASSWRD");

            if (dbPassword.equals(password)) {
                match = true;
                System.out.println("Matched successfully.");
            }
        }


        rs.close();
        dbmsConnect.closeConnection(con, stmt);

        return match;
    }


}
