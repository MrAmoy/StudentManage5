<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<html>
<head>
	<title>dologin.jsp</title>
</head>

<body>
	<%
		String usertype = request.getParameter("op");
		String user = request.getParameter("username");
		String pw = request.getParameter("password");
		
		session.setAttribute("usertype", usertype);
		session.setAttribute("user", user);
		session.setAttribute("pw", pw); 
		
		if(usertype.equals("student")) {
			response.sendRedirect("stuAdmin2.jsp");
		} else {
			response.sendRedirect("stuAdmin.jsp");
		}
	%>
</body>
</html>
