<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/gyl/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<!--
    jquery日期样式的导入
-->
<link rel="stylesheet" href="js/jquery.datepick.css" type="text/css">
<script type="text/javascript" src="js/jquery.datepick.js"></script>
<script type="text/javascript" src="js/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("#wrap").data("url","xsyddAction_showAllXsydd.action?query_zhib.xsyddzhubid=");
			addEvent_Page();
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#dhrq').datepick({dateFormat: 'yy-mm-dd'}); 
			//$('#sxrq').datepick({dateFormat: 'yy-mm-dd'}); 
			
	});
	
	$(function(){
		$('.tab li').mouseover(function(){
			var num = $(this).index()-1;
			$(this).addClass('current').siblings().removeClass();
			$('this:eq(num)').remove('span');
		})
	})
	$(function(){
		$('li').mouseover(function(){
			$(this).addClass('current').siblings().removeClass('current');
		})
	})
	function data(){
		window.open("customer.html",100,200);
	}
</script>
</head>
<body>
<s:form action="xsyddAction_add.action">
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F">客户名称</td>
                    <td class="inp"><s:textfield id="sxrq" name="query_zhub.khmc" cssClass="current"></s:textfield></td>
                    <td class="one" style="width:66px;">订货日期</td>
                    <td class="inp"><s:textfield id="dhrq" name="query_zhub.dhrq"></s:textfield></td>
                    <td class="one">失效日期</td>
                    <td class="inp"><s:textfield id="sxrq" name="query_zhub.sxrq" cssClass="current"></s:textfield></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">销售部门</td>
                    <td class="inp"><s:textfield name="query_zhub.xsbm" cssClass="current"></s:textfield></td>
                    <td class="one" style="color:#00F">业务员</td>
                    <td class="inp"><s:textfield name="query_zhub.ywy" cssClass="current"></s:textfield></td>
                </tr>
                <tr>
                    <td style="color:#00F">开票单位</td>
                    <td class="inp"><s:textfield name="query_zhub.kpdw" cssClass="current"></s:textfield></td>
                    <td style="color:#00F">收货地区</td>
                    <td class="inp"><s:textfield name="query_zhub.shdq" cssClass="current"></s:textfield></td>
                    <td style="color:#00F">收货地址</td>
                    <td class="inp"><s:textfield name="query_zhub.shdq" cssClass="current"></s:textfield></td>
                </tr>
                <tr>
                    <td style="color:#00F">币种</td>
                    <td class="inp">人民币</td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td id="right_center" >
            <div  style="height:213px; width:1150px; overflow:auto;">
            <table cellspacing="0" cellpadding="0"  id="maintain-right"  style="font-size:12px;" width="5000">
                <tr class="two" align="center">
                    <td field="hh" >行号</td>
                    <td field="chbm">存货编码</td>
                    <td field="chmc">存货名称</td>
                    <td field="xh">型号</td>
                    <td field="dw">单位</td>
                    <td field="sl">数量</td>
                    <td field="shulv">税率</td>
                    <td field="dpkl">单品扣率</td>
					<td field="wsdj">无税单价</td>
					<td field="hsdj">含税单价</td>
					<td field="wsje">无税金额</td>
					<td field="hsje">含税金额</td>
					<td field="se">税额</td>
					<td field="zke">折扣额</td>
					<td field="pc">批次</td>
					<td field="gs">公司</td>
					<td field="fhck">发货仓库</td>
					<td field="shdw">收货单位</td>
					<td field="jhfhrq">计划发货日期</td>
					<td field="yqshrq">要求收货日期</td>
					<td field="spfl">商品分类</td>
					<td field="hstatus">行状态</td>
					<td field="zp">赠品</td>
                </tr>
                <input type="hidden" id="zhib" value="xsyddzhibs"/>
                <tr align="center">
                    <td style="width:30px; text-align:center; background:#E2E2E2;" item='hh'><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].hh" value="1"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chbm"><input type="text" style="width:100%;" name="xsyddzhibs[0].chbm"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chmc"><input type="text" style="width:100%;" name="xsyddzhibs[0].chmc"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="xh"><input type="text" style="width:100%;" name="xsyddzhibs[0].xh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dw"><input type="text" style="width:100%;" name="xsyddzhibs[0].dw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sl"><input type="text" style="width:100%;" name="xsyddzhibs[0].sl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shulv"><input type="text" style="width:100%;" name="xsyddzhibs[0].shulv"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dpkl"><input type="text" style="width:100%;" name="xsyddzhibs[0].dpkl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsdj"><input type="text" style="width:100%;" name="xsyddzhibs[0].wsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsdj"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].hsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsje"><input type="text" style="width:100%;" name="xsyddzhibs[0].wsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsje"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].hsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="se"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].se"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zke"><input type="text" style="width:100%;" readonly="true" name="xsyddzhibs[0].zke"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="pc"><input type="text" style="width:100%;" name="xsyddzhibs[0].pc"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="gs"><input type="text" style="width:100%;" name="xsyddzhibs[0].gs"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="fhck"><input type="text" style="width:100%;" name="xsyddzhibs[0].fhck"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shdw"><input type="text" style="width:100%;" name="xsyddzhibs[0].shdw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="jhfhrq"><input type="text" style="width:100%;" name="xsyddzhibs[0].jhfhrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="yqshrq"><input type="text" style="width:100%;" name="xsyddzhibs[0].yqshrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="yqshrq"><input type="text" style="width:100%;" name="xsyddzhibs[0].yqshrq"/></td></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hstatus"><input type="text" style="width:100%;" name="xsyddzhibs[0].hstatus"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zp"><input type="text" style="width:100%;" name="xsyddzhibs[0].zp"/></td>
                </tr>
            </table>
           </div>
    	</td>
    </tr>
    <tr>
    	<td id="right-bot">
            <table style="font-size:12px;">
                <tr>
                    <td class="bot_1" style="color:#00F">制单人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.zdr" cssClass="current"></s:textfield></td>
                    <td class="bot_1" style="color:#00F">修订人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.xgr" cssClass="current"></s:textfield></td>
                    <td class="bot_1">审批人</td>
                    <td class="inp_1"><s:textfield name="query_zhub.spr" cssClass="current"></s:textfield></td>
                    <td  width="77px">审批日期</td>
                    <td class="inp_1"><s:textfield name="query_zhub.spsj"></s:textfield></td>
                </tr>
                <tr>
                    <td>制单时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.zdsj"></s:textfield></td>
                    <td>修订时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.xgsj"></s:textfield></td>
                    <td>审批时间</td>
                    <td class="inp_2"><s:textfield name="query_zhub.spsj"></s:textfield></td>
                </tr>
            </table>
        </td>
    </tr>
     <tr class="save">
       <td height="30" align="right" style="padding-right"><input type="submit" value="保存" class="search"/></td>
     </tr>
</table>
</s:form>
<ul id="menu" style="position:absolute;display:none;">
   <li id="addRow">增行</li>
   <li id="deleteRow">删行</li>
 </ul>
</body>
</html>
