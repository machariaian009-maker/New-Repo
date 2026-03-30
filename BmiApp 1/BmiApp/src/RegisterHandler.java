
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
    //Register Handler
  public  class RegisterHandler {

    public static boolean registerUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Connect to MySQL
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmi_database", "root", "");


            // Check if user exists
            pstmt = conn.prepareStatement("SELECT * FROM regtable WHERE username = ?");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                return false; // User already exists
            }

            // Insert new user
            pstmt = conn.prepareStatement("INSERT INTO regtable (username, password) VALUES (?, ?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password); // You can hash it later for security
            int rows = pstmt.executeUpdate();

            return rows > 0;

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

    

