package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			String firstname = request.getParameter("firstname");
			String password = request.getParameter("password");
			// 5. Execute SQL query
			int numberOfResults = 0;
			myRs = myStmt.executeQuery("select email from tblusers where email ='" + email +"'");
			while(myRs.next()) {
			    numberOfResults++;
			}
			// 5. Check if user already exists
			if(numberOfResults == 0) {
				myStmt.executeUpdate("insert into tblusers values(NULL ,'"+firstname+"','"+email+"','"+password+"','"+0+"')");
				request.setAttribute("error", "Account created for " + firstname);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				System.out.println("Account created");
				
			}
			else {
				request.setAttribute("error", "Email Address already exists");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				System.out.println("Not created");
			}
			
			

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
