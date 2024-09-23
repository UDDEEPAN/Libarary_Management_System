/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libarary_management_syste.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class DbConnection {

    private static DbConnection dbconnection;
    private Connection connection;

    private DbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management", "root", "January#2003");
    }

    public static DbConnection getInstance() throws ClassNotFoundException, SQLException {
        if (dbconnection == null) {
            dbconnection = new DbConnection();
        }
        return dbconnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
