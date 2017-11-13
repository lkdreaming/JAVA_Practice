<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@page import="com.lk.spring.registration.model.User" %>
<%@page import="com.lk.spring.registration.service.UserService" %>
<%@page import="com.lk.spring.registration.service.impl.UserServiceImpl" %>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String passwordc = request.getParameter("passwordconform");
	if (!password.equals(passwordc)) {
		response.sendRedirect("fail.jsp");
		return; 
	} else {
		UserService userService = new UserServiceImpl();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		if(userService.userExists(user)) {
	response.sendRedirect("fail.jsp"); 
	return;
		} else {
	userService.add(user);
	response.sendRedirect("success.jsp"); 
		}
	} 
/* 	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/register", "root", "root");
	
	String sqlQuery = "select count(*) from user where username = ?";
	PreparedStatement psQuery = conn.prepareStatement(sqlQuery);
	psQuery.setString(1, StrUsername);
	ResultSet rs = psQuery.executeQuery();
	rs.next();
	int cont = rs.getInt(1);
	//out.println(cont);
	if (cont > 0) {
		response.sendRedirect("fail.jsp");
		psQuery.close();
		conn.close();
		return;
	}
	String sql = "insert into user values(null,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, StrUsername);
	ps.setString(2, StrUserpwd);
	ps.executeUpdate();
	ps.close();
	conn.close();
	response.sendRedirect("success.jsp");  */
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>




</body>
</html>