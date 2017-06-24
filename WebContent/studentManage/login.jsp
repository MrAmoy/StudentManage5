<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>login.jsp</title>
</head>
<body bgcolor="CCCFFF">
	<center>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<%
			if(request.getAttribute("tip") != null) {
				out.println("<font color='red'>" + request.getAttribute("tip") + "</font>");
			}
		%>
		<form action="dologin.jsp" method="post">
			<table>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="登录" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
