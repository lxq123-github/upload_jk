<%@ page import="org.springframework.util.ResourceUtils" %>
<%@ page import="java.io.File" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getServletContext().getRealPath("/static/upload")%>
	<ul>
	<c:forEach items="${detailFile}" var="li">
		<%--${li.url}--%>
		<li><a href='${li.url }'>${li.filename}</a></li>
	</c:forEach>
	</ul>
</body>
</html>