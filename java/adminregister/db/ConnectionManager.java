/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminregister.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class ConnectionManager {
    static Connection con;
    private static final String DB_DRIVER = "com.oracle.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:oracle://localhost/taka3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
                
    
    public static Connection getConnection() throws SQLException {
        try {
				
		Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE ", "taka3","system");
				
		try {
			con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                            System.out.println("Connected");
		}catch(SQLException e){
			e.printStackTrace();
				}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return con;
        
    }
}
