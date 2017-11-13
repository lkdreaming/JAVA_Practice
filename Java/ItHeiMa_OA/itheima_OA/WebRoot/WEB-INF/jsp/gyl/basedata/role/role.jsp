<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" href="zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="js/jquery-ztree-2.5.js"></script>
<script type="text/javascript" src="js/role.js"></script>
</head>
<body>
<table id="user">
    <tr>
    	<td class="left">
        	<div align="center">
				<ul id="tree" class="tree" style="width:230px; overflow:auto;"></ul>
			</div>
    	</td>
    </tr>
</table>
<ul id="rMenu" class="two" style="position:absolute;display:none;">
   <li id="addRole" class="two">增加</li>
   <li id="updateRole" class="two">修改</li>
   <li id="deleteRole" class="two">删除</li>
</ul>
</body>
</html>