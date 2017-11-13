<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!--  定义struts2-jquery的标签-->
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!--这句话必须加上  -->
<sj:head compressed="false"/>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

	
<link rel="stylesheet" href="../css/style.css" type="text/css"/>


</head>

<body>
	<table class="imgtable">
		<s:iterator value = "orgs">
     		<s:if test="orgs == null">
     			<tr>
     				<td class="imgtd">
     					没有可显示的记录
     				</td>
     			</tr>
     		</s:if>
    		<s:else>
    			<tr>
     				<td class="imgtd">
     					<s:property value = "name"/>
     				</td>
     			</tr>
    		</s:else>
    		
    	</s:iterator> <br> 
  
    
</body>
</html>