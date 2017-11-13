<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<script language="javascript" src="${pageContext.request.contextPath}/js/duty.js"></script>
<link rel="stylesheet" href="css/style/style.css" type="text/css"/>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'duty.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<BODY>
	<TABLE border=0 height=600px align=left>
		<TR>
			<TD width=230px align=left valign=top
				style="BORDER-RIGHT: #999999 1px dashed">
				<ul id="dutyTree" class="tree" style="width:230px; overflow:auto;"></ul>
			</TD>
		</TR>
	</TABLE>
	<div  id="rMenu" class="addnodes" style="position:absolute; display:none;overflow: hidden">
		<ul>
			<li id="addDuty" onclick="addTreeNode();" style="background: url(${pageContext.request.contextPath}/css/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">增加职务</li>
			<li id="deleteDuty" onclick="addTreeNode();" style="background: url(${pageContext.request.contextPath}/css/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">删除职务</li>
			<li id="updateDuty" onclick="addTreeNode();" style="background: url(${pageContext.request.contextPath}/css/images/jia.jpg) 10px 5px no-repeat;border-bottom:1px solid #8ab2e6;cursor:pointer;">修改职务</li>
			
		</ul>
	</div>
</BODY>

</html>
