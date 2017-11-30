package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Properties;



public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {

			// 1. Load the properties file
			Properties props = new Properties();
			//props.load(new FileInputStream("demo.properties"));
			props.load(new FileInputStream("C:/Users/Ahmed/workspace/OnlineShoppingStore/src/com/demo.properties"));

			// 2. Read the props
			String theUser = props.getProperty("user");
			String thePassword = props.getProperty("password");
			String theDburl = props.getProperty("dburl");
			
			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theDburl);
			System.out.println("User: " + theUser);
			
			// 3. Get a connection to database
			myConn = DriverManager.getConnection(theDburl, theUser, thePassword);

			System.out.println("\nConnection successful!\n");
			
			// 4. Create a statement
			myStmt = myConn.createStatement();
			
			// 5. Execute SQL query
			myRs = myStmt.executeQuery("select * from tblusers");
			
			// 6. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("firstname"));
				String result = myRs.getString("firstname");
				
			}
			

		} catch (Exception exc) {
			exc.printStackTrace();
		} 
	
		
	}
}



	







	
