package com.akash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = null;

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		UserBean ub = new UserBean();

		if (session.getAttribute("email") != null) {

			email = (String) session.getAttribute("email");

			System.out.println(email);
			// session.removeAttribute("email");
			// session.invalidate();
		}

		else {

			response.sendRedirect("login.jsp");
			return;
		}

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = Dbutil.getConnectionDBUtil();
			String query = "select * from registration where email=?";
			// Class.forName("com.mysql.jdbc.Driver");
			// conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/Test?user=root&password=root");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			ResultSet i = pstmt.executeQuery();

			while (i.next()) {
				ub.setName(i.getString("name"));
				ub.setEmail(i.getString("email"));
				ub.setMobile(i.getString("mobile"));
				ub.setAddress(i.getString("address"));
			}

			request.setAttribute("user", ub);
			// session.setAttribute("user", ub);

			RequestDispatcher r = request.getRequestDispatcher("/Welcome.jsp");
			r.forward(request, response);
			// response.sendRedirect("/Login_and_Registration_using_JSP/Welcome.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
