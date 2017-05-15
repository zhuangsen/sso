<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String basePath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<center>
		<h1>请登录</h1>
		<form action="http://check.x.com:9090<%=basePath%>/xsso/doLogin.action" method="post">
			<span>用户名：</span><input type="text" name="username" />
			<span>密码：</span><input type="password" name="password" />
			<input type="hidden" name="gotoUrl" value="${gotoUrl }"/>
			<input type="submit" />
		</form>
	</center>
</body>
</html>