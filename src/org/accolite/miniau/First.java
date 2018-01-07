package org.accolite.miniau;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.legacy.connection.USLPort;


/**
 * Servlet implementation class First
 */
@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public First() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub    
		try {
			String name = request.getParameter("name").toString();
			System.out.println(name);
			String username = request.getParameter("username").toString();
			System.out.println(username);
			Connection connection= DataConnection.getConnection();
			Statement statement= connection.createStatement();
			statement.execute("insert into users (name,username) values ('"+name+"','"+username+"');");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Second");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("name").toString();
			System.out.println(name);
			String username = request.getParameter("username").toString();
			System.out.println(username);
			Connection connection= DataConnection.getConnection();
			Statement statement= connection.createStatement();
			statement.execute("insert into users (name,username) values ('"+name+"','"+username+"');");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Second");
			requestDispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
