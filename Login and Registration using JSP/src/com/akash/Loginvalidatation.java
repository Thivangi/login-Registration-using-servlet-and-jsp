package com.akash;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loginvalidatation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String pass="";
	Connection conn = null;
	PreparedStatement pstmt = null;
	String query = "select email,password from registration where email=? and password=?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String email = request.getParameter("email");
		pass = request.getParameter("password");
		byte[] b = null;
		byte[] newpassword = null;
		MessageDigest md5 = null;
		if (pass != null && email != null) {

			try {
				b = pass.getBytes();
				md5 = MessageDigest.getInstance("MD5");
				md5.update(b);
				newpassword = md5.digest();
				System.out.println("check");
				conn = Dbutil.getConnectionDBUtil();

				pstmt = conn.prepareStatement(query);

				pstmt.setString(1, email);
				pstmt.setBytes(2, newpassword);

				ResultSet i = pstmt.executeQuery();
				if (i.next()) {
					// request.getSession(true);
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					//RequestDispatcher r = request.getRequestDispatcher("/Login_and_Registration_using_JSP/Welcome");
					//r.forward(request, response);
					response.sendRedirect("/Login_and_Registration_using_JSP/Welcome");
				} else {
					out.println("sorry your email or password is not correct ");
					RequestDispatcher r = request.getRequestDispatcher("login.jsp");
					r.include(request, response);
					// response.sendRedirect("login.jsp");

				}

			} catch (SQLException | NoSuchAlgorithmException | NullPointerException e) {
				e.printStackTrace();
			} finally {
				// Dbutil.closeConnection();
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
			}
		}
		 else {
				out.println("Email and Password required ");
				RequestDispatcher r = request.getRequestDispatcher("login.jsp");
				r.include(request, response);
				//response.sendRedirect("login.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
