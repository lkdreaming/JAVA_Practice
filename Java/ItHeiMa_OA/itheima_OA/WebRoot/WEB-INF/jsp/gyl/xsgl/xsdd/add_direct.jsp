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
			$("#wrap").data("url","xsddAction_showXsdd.action?query_zhib.xsddzhubid=");
			//addEvent_Page();
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#dhrq').datepick({dateFormat: 'yy-mm-dd'}); 
			$('#sxrq').datepick({dateFormat: 'yy-mm-dd'}); 
			
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
<s:form action="xsddAction_add.action">
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="width:66px;">订货日期</td>
                    <td class="inp"><s:textfield name="dhrq" id="dhrq"></s:textfield></td>
                    <td class="one">失效日期</td>
                    <td class="inp"><s:textfield name="sxrq" id="sxrq" cssClass="current"></s:textfield></td>
                </tr>
                <tr>
                    <td style="color:#00F">客户名称</td>
                    <td class="inp"><s:textfield name="khmc"></s:textfield></td>
                    <td style="color:#00F">整单扣率</td>
                    <td class="inp"><s:textfield name="zdkl"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">销售部门</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td class="one" style="color:#00F">业务员</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">开票单位</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td style="color:#00F">收货地区</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td style="color:#00F">收货地址</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">币种</td>
                    <td class="inp">人民币</td>
					<td class="one" style="color:#00F">审批人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">审批日期</td>
                    <td class="inp"><input type="text" id='dhrq'/></td>
                </tr>
				<tr>
					<td class="one" style="color:#00F">制单人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">制单日期</td>
                    <td class="inp"><input type="text"/></td>
					<td class="one" style="color:#00F">修改人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">修改日期</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">整单税价合计</td>
                    <td class="inp"><input type="text"/></td>
                    <td class="one" style="width:66px;">收现款金额</td>
                    <td class="inp"><input type="text"/></td>
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
                    <td width="50" field="hh">行号</td>
                    <td width="100" field="chbm">存货编码</td>
                    <td width="200" field="chmc">存货名称</td>
                    <td width="100" field="xh">型号</td>
                    <td width="100" field="dw">单位</td>
                    <td width="100" field="sl">数量</td>
                    <td width="100" field="shulv">税率</td>
                    <td width="100" field="dpzk">单品扣率</td>
					<td width="100" field="wsdj">无税单价</td>
					<td width="100" field="hsdj">含税单价</td>
					<td width="100" field="wsje">无税金额</td>
					<td width="100" field="hsje">含税金额</td>
					<td width="100" field="se">税额</td>
					<td width="200" field="zke">折扣额</td>
					<td width="200" field="pc">批次</td>
					<td width="200" field="gs">公司</td>
					<td width="200" field="fhck">发货仓库</td>
					<td width="200" field="shdw">收货单位</td>
					<td width="150" field="jhfhrq">计划发货日期</td>
					<td width="150" field="yqshrq">要求收货日期</td>
                </tr>
                <input type="hidden" id="zhib" value="xsddzhibs"/>
                <tr align="center">
                    <td style="width:30px; text-align:center; background:#E2E2E2;" item='hh'><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].hh" value="1"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chbm"><input type="text" style="width:100%;" name="xsddzhibs[0].chbm"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chmc"><input type="text" style="width:100%;" name="xsddzhibs[0].chmc"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="xh"><input type="text" style="width:100%;" name="xsddzhibs[0].xh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dw"><input type="text" style="width:100%;" name="xsddzhibs[0].dw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sl"><input type="text" style="width:100%;" name="xsddzhibs[0].sl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shulv"><input type="text" style="width:100%;" name="xsddzhibs[0].shulv"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dpkl"><input type="text" style="width:100%;" name="xsddzhibs[0].dpkl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsdj"><input type="text" style="width:100%;"  name="xsddzhibs[0].wsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsdj"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].hsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsje"><input type="text" style="width:100%;"  name="xsddzhibs[0].wsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsje"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].hsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="se"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].se"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zke"><input type="text" style="width:100%;" readonly="true" name="xsddzhibs[0].zke"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="pc"><input type="text" style="width:100%;"  name="xsddzhibs[0].pc"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="gs"><input type="text" style="width:100%;"  name="xsddzhibs[0].gs"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="fhck"><input type="text" style="width:100%;"  name="xsddzhibs[0].fhck"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shdw"><input type="text" style="width:100%;"  name="xsddzhibs[0].shdw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="jhfhrq"><input type="text" style="width:100%;"  name="xsddzhibs[0].jhfhrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="yqshrq"><input type="text" style="width:100%;"  name="xsddzhibs[0].yqshrq"/></td>
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
