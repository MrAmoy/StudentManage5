<%@page import="bao.*, java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生信息查询</title>
</head>
<body bgcolor="CCCFFF">
	<jsp:useBean id="student" class="bao.Student" scope="page" />
	<%
			PageBean pagebean = (PageBean)session.getAttribute("page");
			List list = (List)session.getAttribute("data");
	%>
	<center>
		<br> <br> <br> <br> <br> <br> <h3>你要查询的学生数据表中共有 <font size="5" color="red"><%=list.size() %></font> 人</h3>
		<table border="0" bgcolor="CCCEEE" width="600">
			<tr bgcolor="CCCCCC" align="center">
				<th>记录条数</th>
				<th>学号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>体重</th>
			</tr>
			<%
				for(int i = pagebean.getStartRow(); i < pagebean.getStopRow(); i++) {
					student = (Student)list.get(i);			 
			%>
			<tr align="center">
				<td><%=i+1 %></td>
				<td><%=student.getStuId()%></td>
				<td><%=student.getStuName()%></td>
				<td><%=student.getStuSex()%></td>
				<td><%=student.getStuAge()%></td>
				<td><%=student.getStuWeight()%></td>
			</tr>
			<%
				}
			%>
		</table><br>
		<font size="3">
			每页&nbsp;<%=pagebean.getRowsPerPage() %>&nbsp;行&nbsp;&nbsp;&nbsp;&nbsp;
			共&nbsp;<%=pagebean.getMaxRowCount() %>&nbsp;行&nbsp;&nbsp;&nbsp;&nbsp;
			第&nbsp;<font color="red"><%=pagebean.getCurPage() %></font>&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
			共&nbsp;<%=pagebean.getMaxPage() %>&nbsp;页
		</font>
		<h4>
			<% if(pagebean.getCurPage() == 1) { %>
				首页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
			<% } else { %>
				<a href="lookStudent_jsp?curpage=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="lookStudent_jsp?curpage=<%=pagebean.getCurPage() - 1%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<% } if(pagebean.getCurPage() == pagebean.getMaxPage()) { %>
				下一页&nbsp;&nbsp;&nbsp;&nbsp;页尾
			<% } else { %>
				<a href="lookStudent_jsp?curpage=<%=pagebean.getCurPage() + 1%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="lookStudent_jsp?curpage=<%=pagebean.getMaxPage()%>">页尾</a>
			<% } %>
		</h4>
	</center>
</body>
</html>
