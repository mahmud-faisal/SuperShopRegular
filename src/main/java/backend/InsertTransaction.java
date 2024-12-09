package backend;

import com.example.supershopregular.Products;
import com.example.supershopregular.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertTransaction {
    public void insertTransaction(Transaction transaction) {
        try {
            DBMSConnection dbmsConnect = new DBMSConnection("jdbc:mysql://localhost:3306/shopease", "root", "");
            Connection con = dbmsConnect.getConnection();

            String sql = "INSERT INTO transactions (transactionDate, totalAmount, remarks) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setTimestamp(1, transaction.getTransactionDate());
            stmt.setDouble(2, transaction.getTotalAmount());
            stmt.setString(3, transaction.getRemark());


            int i = stmt.executeUpdate();
            System.out.println("Inserted rows: " + i);
            dbmsConnect.closeConnection(con, stmt);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

