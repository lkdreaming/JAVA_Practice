
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.lk.spring.registration.action.UserAction"%>
<%@ page import="com.lk.spring.registration.model.User"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%--   <%
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    		UserAction ua = (UserAction) ctx.getBean("user");
    		ua.list();
    		List<User> users = ua.getUsers();
        	Iterator<User> it = users.iterator();
        	
        	while(it.hasNext()) {
        	User user = it.next();
    %>
    
     	用户名:<%=user.getUsername()%> 
     	密码:<%=user.getPassword() %>
     	
     	<br/>
     <%	} %> --%>
     <s:iterator value = "users">
     	<s:property value = "username"/><br/>
     </s:iterator>
     <s:debug></s:debug>
  </body>
</html>
