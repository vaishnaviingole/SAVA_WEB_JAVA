package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButils {
	 private static Connection con;
	 
	 public static void openConnection() throws SQLException,ClassNotFoundException{
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 System.out.println("Driver Loaded");
	 
	 con=DriverManager.getConnection("jdbc:mysql://localhost:3307/bankJd","root","root123");
	 System.out.println("Connection Created");
	 }
	 public static Connection getCon() {
		 return con;
	 }
	 public static void closeConnection() throws SQLException{
		 if(con!=null);
		 con.close();
	 }

}
