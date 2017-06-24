<%@page import="bao.*,java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>学生信息添加</title>
    </head>
    <body bgcolor="CCCFFF">
    	<%
            Student student = (Student)request.getAttribute("stu");
        %>
        <center>
            <br><br><br><br><br><br>
            <h3>&nbsp;&nbsp;修改学生信息</h3>
            <form action="updateStudentCheck1_jsp"  method="post">
                <table border="0" width="200">
                	<tr>
                		<input type="hidden" name="id" value="<%=request.getParameter("id") %>">
                	</tr>
                	<tr>
                        <td>学号</td>
                        <td><input type="text" name="studentNumber" value=<%=student.getStuId() %>></td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td><input type="text" name="studentName" value=<%=student.getStuName() %>></td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td><input type="text" name="studentSex" value=<%=student.getStuSex() %>></td>
                    </tr>
                    <tr>
                        <td>年龄</td>
                        <td><input type="text" name="studentAge" value=<%=student.getStuAge() %>></td>
                    </tr>
                    <tr>
                        <td>体重</td>
                        <td><input type="text" name="studentWeight" value=<%=student.getStuWeight() %>></td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input name="sure" type="submit" value="提      交">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <input name="clear" type="reset" value="取消修改">
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
