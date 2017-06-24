<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>

<html>
<head>
	<title>dologin.jsp</title>
</head>

<body>
	<%
		String user = request.getParameter("username");
		String pw = request.getParameter("password");
		session.setAttribute("user", user);
		session.setAttribute("pw", pw); 
		response.sendRedirect("stuAdmin.jsp");
	%>
</body>
</html>
