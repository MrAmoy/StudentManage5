package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import bao.*;

public class updateStudentCheck1_jsp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
    	int i = Integer.parseInt(id);
    	Student student = new Student();
    	
        String studentNumber = request.getParameter("studentNumber");
        student.setStuId(studentNumber);
        
        String studentName = request.getParameter("studentName");
        student.setStuName(studentName);
        
        String studentSex = request.getParameter("studentSex");
        student.setStuSex(studentSex);
        
        String studentAge = request.getParameter("studentAge");
        student.setStuAge(studentAge);
        
        String studentWeight = request.getParameter("studentWeight");
        student.setStuWeight(studentWeight);
        
        HttpSession session = request.getSession(true);
        List list = (List)session.getAttribute("data");
        list.set(i, student);
        
        response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
        StudentDAO studentdao = new StudentDAO();
        if(studentdao.update(student)) {
        	out.println("<h3>已更新到数据库！<font size=" + "3" + " color=" + "red" + ">3</font>秒之后返回首页，若没有跳转<a href=" + "lookStudent.jsp" + ">请点这里</></h3>");
			response.setHeader("refresh", "3;url=lookStudent.jsp");
		} else {
			out.println("<h3>更新失败！<font size=" + 3 + " color=" + "red" + ">3</font>秒之后返回首页，若没有跳转<a href=" + "lookStudent.jsp" + ">请点这里</></h3>");
			response.setHeader("refresh", "3;url=lookStudent.jsp");
        }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
