<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>login.jsp</title>
</head>
<body bgcolor="CCCFFF">
	<center>
		<br><br><br><br><br><br><br><br><h1>学生信息管理系统</h1><br><br><br><br>
		<form action="dologin.jsp" method="post">
			<table style="border-collapse:separate; border-spacing:0px 10px;">
				<tr>
					<td>身&nbsp;&nbsp;&nbsp;&nbsp;份&nbsp;&nbsp;</td>
					<td>
						<select name="op">
							<option value="student">学生</option>
							<option value="admin">系统管理员</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>账&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;&nbsp;</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input type="submit" value="登录" /></td>
				</tr>
			</table>
		</form>
		
		<%
			if(request.getAttribute("tip") != null) {
				out.println("<font size='2' color='red'>" + request.getAttribute("tip") + "</font>");
			}
		%>
	</center>
</body>
</html>
