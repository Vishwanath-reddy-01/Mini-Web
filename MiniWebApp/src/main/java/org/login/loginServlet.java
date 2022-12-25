package org.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.Jdbc;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = Jdbc.getconnection();
		
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		
		String query = "select * from user_info where email=? and pwd=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet result = pstmt.executeQuery();
			
			if(result.next()) {
				
				RequestDispatcher reqDispatch = request.getRequestDispatcher("home.jsp");
				reqDispatch.forward(request, response);
			}else {
				
				PrintWriter docWrite = response.getWriter();
				docWrite.println("<font color=red size=18>Incorect email or password..!<br>");
				docWrite.println("<a href=loginn.jsp>Try Again..?</a>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
