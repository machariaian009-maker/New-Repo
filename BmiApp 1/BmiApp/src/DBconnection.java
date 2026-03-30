/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author enckk
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnection {

    private static final String URL = "jdbc:mysql://localhost:3306/bmi_app";
    private static final String USER = "root";
    private static final String PASS = "your_mysql_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}

    

