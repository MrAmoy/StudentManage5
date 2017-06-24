package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import bao.*;

public class updateStudentCheck_jsp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		byte b[] = id.getBytes("ISO-8859-1");
		id = new String(b, "UTF-8");
		int i = Integer.parseInt(id);
		
		HttpSession session = request.getSession(true);
		List list = (List)session.getAttribute("data");
		Student student = (Student)list.get(i);
		request.setAttribute("stu", student);
		request.getRequestDispatcher("updateStudentCheck.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
