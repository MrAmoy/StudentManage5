<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>修改密码成功</title>
	</head>
<body>
	<br><br><br><br><br><br><br>
	<center>
		密码修改成功！请<a href="login.jsp"><font color="red">重新登录！</font></a>(3秒后自动跳转……)
		<%
			response.setHeader("refresh", "3;url=login.jsp");
		%>
	</center>
</body>
</html>