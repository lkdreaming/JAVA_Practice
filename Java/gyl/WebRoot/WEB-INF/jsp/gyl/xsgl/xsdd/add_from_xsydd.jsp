<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link type="text/css" rel="stylesheet" href="css/style.css"/>
<link rel="stylesheet" href="css/style_customer.css" type="text/css"/>
</head>
<script language="javascript">
	$().ready(function(){
		$(".searRR").click(function(){
			$("#seek").show();
		});
	});
</script>
<body>
<s:form action="xsddAction_addFromXsydd.action">
<table id="userwrap">
	<tr class="user">
        <td class="right">
        	<table>
            	<tr>
                	<td class="one">来源订单号：</td>
                    <td class="inp">
	                    <div class="inp_search">
	                    	<s:textfield name="xsyddzhubQuery.ddh" cssClass="bdnone"></s:textfield>
	                        <span class="searRR"></span>
	                    </div>
	                    <div id="seek">
	                    	<div class="seek_con_top">
	                        	<h5>公司信息</h5>
	                            <span class="seek_close" onclick="allclose()"></span>
	                        </div>
	                        <div class="seek_con">
	                            <div class="seek_top">
	                                <span><a href="#" class="clear">刷新</a><a href="#" class="programa">栏目</a></span>			
	                                <input type="text" class="seek_inp"/>
	                            </div>
	                            <div  style="overflow:scroll; overflow-x:hidden; height:275px;border:1px solid #898989;width:800px">
	                            <table cellpadding="0" cellspacing="0">
	                                <tr style="text-align:center; background:url(images/seek_tab_bg.png) repeat-x;">
	                                    <td class="num_1" style="border:1px solid #9EB6CE; border-left:0"></td>
	                                    <td class="num_2" style="border:1px solid #9EB6CE; border-left:0">模板类型编码</td>
	                                    <td class="num_3" style="border:1px solid #9EB6CE; border-left:0">模板类型</td>
	                                </tr>
	                                <tr>
	                                    <td class="num_1_1">3</td>
	                                    <td class="num_2_1">100404</td>
	                                    <td class="num_3_1">会计期间</td>
	                                </tr>
	                                <tr>
	                                    <td class="num_1_1">4</td>
	                                    <td class="num_2_1">100405</td>
	                                    <td class="num_3_1">会计期间调整期</td>
	                                </tr>
	                            </table>
	                            </div>
	                            <div class="btns">
	                                <button  class="btn" onclick="allclose()">取消</button><button  class="btn">确定</button>
	                            </div>
	                        </div>
	                    </div>
                    </td>
                </tr>
				<tr>
					<td class="one">收现款金额:</td>
                    <td class="two"><s:textfield name="query_zhub.sxkje"/></td>
				</tr>
                <tr><td>&nbsp;</td></tr>
                <tr><td>&nbsp;</td></tr>
                <tr>
                	<td colspan="3"></td>
                    <td class="btn"><input type="submit" value="生成销售订单"/>
                </tr>
            </table>
        </td>
    </tr>
</table>
</s:form>
</body>
</html>
