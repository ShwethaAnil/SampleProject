package com.mphasis.pms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	private static Connection con=null;
	private DbUtil() {
		
	}
	public static Connection createConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 con=DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java185","java185");
				//prepared query
		}catch(SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
