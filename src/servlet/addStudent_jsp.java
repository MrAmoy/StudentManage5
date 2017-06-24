package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import bao.*;

public class addStudent_jsp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		StudentDAO studentdao = new StudentDAO();
		Student student = new Student();
    	
		request.setCharacterEncoding("utf-8");
		
        String studentNumber = request.getParameter("studentNumber");
        student.setStuId(studentNumber);
        
        String studentName = request.getParameter("studentName");
        student.setStuName(studentName);
        
        String studentSex = request.getParameter("studentSex");
        student.setStuSex(studentSex);
        
        String studentAge = request.getParameter("studentAge");
        student.setStuAge(studentAge);
        
        String studentWeight=request.getParameter("studentWeight");
        student.setStuWeight(studentWeight);
        
        HttpSession session = request.getSession(true);
        List list = null;
        if(session.getAttribute("data") == null) {
			list = studentdao.queryAll();
	 		session.setAttribute("data", list);
		} else {
			list = (List)session.getAttribute("data");
		}
        list.add(student);
        
        PageBean pagebean = new PageBean();	
		//设置总行数
		pagebean.setMaxRowCount(( (List)(session.getAttribute("data")) ).size());
		//设置总页数
		pagebean.maxPageSet();
		//计算起止行数
		pagebean.calculate(); 
		session.setAttribute("page",pagebean);
        
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        
        if(studentdao.insert(student)) {
			out.println("<h3>新的数据已经成功添加到数据库中！<font size=" + "5" + " color=" + "red"  + ">5</font>秒之后返回首页，若没有跳转<a href=" + "lookStudent.jsp" + ">请点这里</></h3>");
        	response.setHeader("refresh", "5;url=lookStudent.jsp");
        } else {
        	out.println("<h3>添加失败！<font size=" + "5" + " color=" + "red"  + ">5</font>秒之后返回首页，若没有跳转<a href=" + "lookStudent.jsp" + ">请点这里</></h3>");
        	response.setHeader("refresh", "5;url=lookStudent.jsp");
        }
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
	}
}
