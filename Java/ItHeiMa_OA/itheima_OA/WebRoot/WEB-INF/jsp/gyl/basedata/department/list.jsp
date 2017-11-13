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
                    <td width="300">部门名称</td>
                    <td width="300">描述</td>
					<td width="300">修改</td>
                </tr>
                <tr>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
				   <td class="btn" align="center"><input type="button" value="修改"/></td>
                </tr>
                <tr>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                </tr>
                <tr style="background:#ECF4FB;"  height="30">
                <td colspan="1" style="border-right:0;border-top:1px solid #8FAFD7;">&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页</td>
                 <td colspan="2" style="border-right:0; padding-right:80px;border-top:1px solid #8FAFD7;" align="right" class="page"><input type="button" value="首页"/>&nbsp;<input type="button" value="上一页" />&nbsp;<input type="button" value="下一页"/>&nbsp;<input type="button" value="尾页"/>&nbsp;<span>转到第 <input name="textfield" type="text" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" /> 页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
                </td>
                	</tr>
                    </table>
        </td>
    </tr>
</table>
</body>
</html>