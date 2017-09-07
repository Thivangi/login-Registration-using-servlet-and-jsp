package com.akash;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String password;
	int i;
	String name, email, address, mobile;
	Connection conn = null;
	PreparedStatement pstmt = null;
	String query = "insert into registration(name,email,mobile,password,address) values(?,?,?,?,?) ";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println(request.getClass().getCanonicalName());

		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");

			name = request.getParameter("name");
			email = request.getParameter("email");
			mobile = request.getParameter("mobile");

			password = request.getParameter("password");
			byte[] b = password.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(b);
			byte[] newpassword = md5.digest();
			
			//password=new String(newpassword);
			

			address = request.getParameter("address");
			varification v = new varification();
			Collection<String> l = v.validate(mobile);
			if (!(l.isEmpty())) {
				System.out.println(l);
				RequestDispatcher rd = request.getRequestDispatcher("/Registration.jsp");
				rd.include(request, response);
				return;
				// response.getWriter().print("Invalid Mobile");
			}

			else {
				conn = Dbutil.getConnectionDBUtil();
				// Class.forName("com.mysql.jdbc.Driver");
				// conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Test?user=root&password=root");
				pstmt = conn.prepareStatement(query);

				pstmt.setString(1, name);
				pstmt.setString(2, email);
				pstmt.setString(3, mobile);
				pstmt.setBytes(4, newpassword);
				pstmt.setString(5, address);

				i = pstmt.executeUpdate();

				if (i != 0) {

					response.sendRedirect("login.jsp");

				}

			}

		} catch (SQLException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Dbutil.closeConnection();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}