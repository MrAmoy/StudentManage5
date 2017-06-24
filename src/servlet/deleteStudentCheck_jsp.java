package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import bao.*;

public class deleteStudentCheck_jsp extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		byte b[] = id.getBytes("ISO-8859-1");
		id = new String(b, "UTF-8");
		int i = Integer.parseInt(id);
		
		HttpSession session = request.getSession(true);
		List list = (List) session.getAttribute("data");
		Student student = (Student)list.get(i);
		list.remove(i);
		
		PageBean pagebean = (PageBean)session.getAttribute("page");
		pagebean.setMaxRowCount(list.size()-1); 	//删除一行数据后，就要重新设置总行数

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StudentDAO studentdao = new StudentDAO();
		if (studentdao.delete(student)) {
			out.println("<h3>已从数据库中删除！<font size=" + "3" + " color=" + "red" + ">3</font>秒之后返回首页，若没有跳转<a href=" + "lookStudent.jsp" + ">请点这里</></h3>");
			response.setHeader("refresh", "3;url=lookStudent.jsp");
		} else {
			out.println("<h3>删除失败！<font size=" + 3 + " color=" + "red" + ">3</font>秒之后返回首页，若没有跳转<a href=" + "lookStudent.jsp" + ">请点这里</></h3>");
			response.setHeader("refresh", "3;url=lookStudent.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
