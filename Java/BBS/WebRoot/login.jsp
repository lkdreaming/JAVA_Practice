<%@ page pageEncoding="GB18030"%>

<%
	boolean logined = false;
	String action = request.getParameter("action");
	String username = "";
	String password = "";
	if (action != null && action.trim().equals("login")) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		if (username == null || !username.equals("admin")) {
			out.println("username is incorrect!");
		} else if (password == null || !password.equals("admin")) {
			out.println("password is incorrect!");
		} else {
		/* 如果登录成功,将session的logined值设置成true		*/
			session.setAttribute("logined", "true");
			response.sendRedirect("articleFlat.jsp");
		
		}
	}
%>


<head>
<title>登录</title>

</head>
<body>
	<form action="login.jsp" method="post">

		<table align="center">
			<input type="hidden" name="action" value="login" />
			<tr>
				<td align="right">用户名:</td>
				<td><input type="text" name="username" value="<%=username%>" />
				</td>
			<tr>
				<td align="right">密码:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"><input type="submit" value="提交" /><input name="reset" type="reset" value="重置"></td>
				<!-- 			<td> -->
				<!-- 				<input name="reset" type="reset" value="重置"> -->
				<!-- 			</td> -->
			</tr>


		</table>




	</form>
</body>