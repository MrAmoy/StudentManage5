<%@page import="bao.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<title>stuLook</title>
	</head>
	<body bgcolor="CFE8ED">
		<%
			Student student = (Student)request.getAttribute("stu"); 
		%>
		<center>
		<br> <br> <br> <br> <br> <br> <h3>你的信息</h3>
		<table border="0" bgcolor="CCCEEE" width="600">
			<tr bgcolor="CCCCCC" align="center">
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>体重</th>
			</tr>
			<tr align="center">
				<td><%=student.getStuId()%></td>
				<td><%=student.getStuName()%></td>
				<td><%=student.getStuSex()%></td>
				<td><%=student.getStuAge()%></td>
				<td><%=student.getStuWeight()%></td>
			</tr>
		</table><br>
		</center>
	</body>
</html>