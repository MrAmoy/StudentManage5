<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>用户注册</title>
</head>
<body bgcolor="CFE8ED">
	<center>
		<br><br><br><br><br><h2>你的学号是<font color="red">${sessionScope.user}</font>，请修改你的密码</h2><br><br><br>
		<form action="updatePassword" method="post">
			<table style="border-collapse: separate; border-spacing: 0px 10px;">
				<tr>
					<td>新&nbsp;&nbsp;密&nbsp;&nbsp;码&nbsp;</td>
					<td><input type="text" name="npw"></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交" />
					&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>