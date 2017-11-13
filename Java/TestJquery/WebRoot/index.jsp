<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<script type="text/javascript">
		function Msg() {
			var username = document.getElementById("username").value;
			var reg = new RegExp("^[0-9]{8,16}$");
			if (!reg.test(username)) {
				document.getElementById("chkArea").innerHTML = "<font color = 'red'>" + username + "不合法</font>";
				return false;
			}
			document.getElementById("chkArea").innerHTML = "<font color = 'red'>" + username + "合法</font>";
		}
	
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    
    	<input type="text" id ="username" onblur="Msg()"/><div style="display: inline;" id= "chkArea"></div>
  </body>
</html>
