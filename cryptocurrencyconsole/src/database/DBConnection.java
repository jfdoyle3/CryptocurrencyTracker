package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBConnection {

	public static void connectDB() {

		try {

			String jdbcUrl="jdbc:mysql://192.168.1.201:3306/cryptocurrencytracker?useSSL=false";
			String user="jfdoyle3";
			String pass="Fl1pp3r6467";
		
				System.out.println("Connecting to database: "+jdbcUrl);
				
				Connection myConn= DriverManager.getConnection(jdbcUrl, user, pass);
				
				System.out.println("Connection successful!!!");
				myConn.close();
			}
			catch(Exception exc) {
				exc.printStackTrace();
			}
		}
	
	}

