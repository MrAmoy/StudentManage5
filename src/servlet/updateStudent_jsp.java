package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;
import bao.*;

public class updateStudent_jsp extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		String curpage = request.getParameter("curpage");
		byte p[] = curpage.getBytes("ISO-8859-1");
		curpage = new String(p, "UTF-8");
		
		HttpSession session = request.getSession(true);
		if(session.getAttribute("data") == null) {
			StudentDAO studentdao = new StudentDAO();
			List list = studentdao.queryAll();
	 		session.setAttribute("data", list);
		}
		
		PageBean pagebean = new PageBean();
		//设置当前页页数
		pagebean.setCurPage(Integer.parseInt(curpage));	
		//设置总行数
		pagebean.setMaxRowCount(( (List)(session.getAttribute("data")) ).size());
		//设置总页数
		pagebean.maxPageSet();
		//计算起止行数用于循环
		pagebean.calculate();
		
		session.setAttribute("page",pagebean);		
		request.getRequestDispatcher("updateStudent.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doGet(request, response);
	}
}
