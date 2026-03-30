
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginHandler {
  //login handler
   

    public static boolean loginUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Connect to your MySQL database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi_database", "root", "");

            // Check if user with given username and password exists
            String sql = "SELECT * FROM regtable WHERE username = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password); // In real apps, passwords should be hashed!

            rs = pstmt.executeQuery();

            return rs.next(); // true if match found

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }
    }
}  

