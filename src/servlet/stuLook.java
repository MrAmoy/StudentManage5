package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import bao.*;

public class stuLook extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		HttpSession session = request.getSession(true);
		String user = (String)session.getAttribute("user");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBGet.getConnection();
			String sql = "select * from stu where stuID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user); 
			rs = ps.executeQuery();
			Student stu;
			if(rs.next()) {
				stu = new Student();
				stu.setStuId(rs.getString("stuID"));
				stu.setStuName(rs.getString("stuName")); 
				stu.setStuSex(rs.getString("stuSex")); 
				stu.setStuAge(rs.getString("stuAge")); 
				stu.setStuWeight(rs.getString("stuWeight"));
				request.setAttribute("stu", stu); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBGet.closeResultSet(rs);
			DBGet.closePreparedStatement(ps);
			DBGet.closeConnection(conn);
		}
		request.getRequestDispatcher("stuLook.jsp").forward(request, response); 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
	}
}

