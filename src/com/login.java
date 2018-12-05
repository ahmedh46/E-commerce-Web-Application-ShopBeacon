package com;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Properties;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {

			// 1. Load the properties file
			Properties props = new Properties();
			// props.load(new FileInputStream("demo.properties"));
			props.load(new FileInputStream("C:/Users/workspace/OnlineShoppingStore/src/com/demo.properties"));
			// 2. Read the props
			
			String theUser = props.getProperty("user");
			String thePassword = props.getProperty("password");
			String theDburl = props.getProperty("dburl");

			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theDburl);
			System.out.println("User: " + theUser);

			// 3. Get a connection to database
			Class.forName("com.mysql.jdbc.Driver");
			myConn = DriverManager.getConnection(theDburl, theUser, thePassword);

			System.out.println("\nConnection successful!\n");

			// 4. Create a statement
			myStmt = myConn.createStatement();

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			// 5. Execute SQL query
			myRs = myStmt.executeQuery("select firstname from tblusers where email ='" + email +"' AND password ='" + password +"' ");
			
			// 6. Process the result set
			
			if(myRs.next()) {
				System.out.println(myRs.getString("firstname"));
				String result = myRs.getString("firstname");
				session.setAttribute("firstname", result);
				request.setAttribute("loginerror", "Welcome " + result);
			}
			else {
				request.setAttribute("loginerror", "Email/Password is incorrect");
			}
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
			

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
