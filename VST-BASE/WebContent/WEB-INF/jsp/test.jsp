<%@page import="org.springframework.web.context.WebApplicationContext,org.springframework.web.servlet.support.RequestContextUtils,com.webschool.vst.dao.Test,com.webschool.vst.dao.MenuDAOImpl,org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<%

ApplicationContext context = RequestContextUtils.getWebApplicationContext(request);

out.println(((Test)context.getBean("d")).getTable());

%>
</body>
</html>