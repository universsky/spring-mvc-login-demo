<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>
<title>注册新用户</title>
</head>

<body>
	<form action="<c:url value="regist.html"/>" method="post">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"/></td>
			</tr>
			
			<tr>
				<td
				   colspan="1">
				   <input type="submit" name="提交注册"/>
				</td>
				
			</tr>	
			
		</table>
	</form>
</body>
</html>