<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册页面</title>
</head>

<body>
<form action="user.action" method="post" name="register">
	账号:<input name="username" type="text" />
    <br />
   	密码: <input name="password" type="password" /> 
    <br />
  	 确认密码: <input name="passwordc" type="password" />
    <br />
    <input type="submit" value="提交" />

</form>
</body>
</html>