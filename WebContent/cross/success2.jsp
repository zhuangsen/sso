<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String basePath = request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CROSS_DEMO2</title>
</head>
<body>
欢迎访问CROSS_DEMO2，这是CROSS_DEMO2的主页！
<c:forEach var="url" items="${hiddenUrl }">
	<iframe src="${url }" width="0px" height="0px" style="display: none;"></iframe>
</c:forEach>
</body>
</html>