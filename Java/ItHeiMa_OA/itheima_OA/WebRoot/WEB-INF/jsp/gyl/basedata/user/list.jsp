<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>
<body>
<table id="userwrap">
	<tr class="user">
        <td class="right">
        	<table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="900" style=" overflow:auto; height:40px;">
                <tr class="one" height="20">
                	<td><input type="checkbox"/></td>
                    <td width="300">姓名</td>
                    <td width="300">性别</td>
					<td width="300">电话</td>
					<td width="300">email</td>
					<td width="300">操作</td>
                </tr>
                <s:iterator value="users">
	                <tr class="two" align="center">
	                	<td><input type="checkbox"/></td>
	                    <td width="300"><s:property value="username"/></td>
	                    <td width="300"><s:property value="sex"/></td>
						<td width="300"><s:property value="phone"/></td>
						<td width="300"><s:property value="email"/></td>
						<td width="300" class="btn"><input  type="button" value="修改"/></td>
	                </tr>
                </s:iterator>
             </table>
        </td>
    </tr>
    <tr>
          <td class="btn" align="center"><input type="button" value="增加"/></td>
    </tr>
</table>
</body>
</html>