package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import bao.*;

public class updatePassword extends HttpServlet  {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		HttpSession session = request.getSession(true);
		String sno = (String)session.getAttribute("user");
		String npw = request.getParameter("npw");
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBGet.getConnection();
			String sql = "update users set password=? where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, npw); 
			ps.setString(2, sno);
			int num = ps.executeUpdate();
			if(num > 0) {
				session.setAttribute("pw", npw); 
				response.sendRedirect("success.jsp"); 
			} else {
				response.sendRedirect("error.jsp"); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBGet.closePreparedStatement(ps);
			DBGet.closeConnection(conn);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
	}
}
