package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.Jdbc;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h2>Welcom to MyFirstServlet </h2>");
		
		String fname = request.getParameter("FirstName");
		String lname = request.getParameter("LastName");
		String email = request.getParameter("email");
		String password = request.getParameter("psw");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String d_o_b= request.getParameter("DOB");
		
		out.println("<h2>"+fname +"</h2>");
		out.println("<h2>"+ lname+"</h2>");
		out.println("<h2>"+email +"</h2>");
		out.println("<h2>"+password +"</h2>");
		out.println("<h2>"+address +"</h2>");
		out.println("<h2>"+gender +"</h2>");
		out.println("<h2>"+d_o_b +"</h2>");
		
		 Connection con = Jdbc.getconnection();
		
		String query = "insert into user_info values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			
			pstm.setString(1, fname);
			pstm.setString(2, lname );
			pstm.setString(3, email);
			pstm.setString(4, password);
			pstm.setString(5, address);
			pstm.setString(6, gender);
			pstm.setString(7, d_o_b);
			
			pstm.executeUpdate();
			
			RequestDispatcher reqDispatch = request.getRequestDispatcher("login.jsp");
			reqDispatch.forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
