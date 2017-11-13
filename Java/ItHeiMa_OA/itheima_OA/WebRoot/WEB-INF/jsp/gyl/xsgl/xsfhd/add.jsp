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
<s:form action="xsfhdAction_add.action">
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px; width:1150px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F;">公司</td>
                    <td class="inp"><input type="text" name="query_zhub.gs"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">单据日期</td>
                    <td class="inp"><input type="text" name="query_zhub.djrq"/></td>
                    <td style="color:#00F">仓库</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right" name="query_zhub.ck"/></td>
                    <td style="color:#00F">库管员</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right" name="query_zhub.kgy"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">部门</td>
                    <td class="inp"><input type="text" name="query_zhub.bm"/></td>
                    <td class="one" style="color:#00F">客户</td>
                    <td class="inp"><input type="text" name="query_zhub.kh"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">单据状态</td>
                    <td class="inp"><input type="text" value="1.00" name="query_zhub.status"/></td>
                    <td class="one" style="color:#00F">审批人</td>
                    <td class="inp"><input type="text" name="query_zhub.shr"/></td>
					<td class="one" style="width:66px;">审批日期</td>
                    <td class="inp"><input type="text" id='dhrq' name="query_zhub.shrq"/></td>
                </tr>
				<tr>
					<td class="one" style="color:#00F">制单人</td>
                    <td class="inp"><input type="text" name="query_zhub.zdr"/></td>
					<td class="one" style="width:66px;">制单日期</td>
                    <td class="inp"><input type="text" name="query_zhub.zdrq"/></td>
					<td class="one" style="color:#00F">修改人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">修改日期</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
            </table>
           </div>
		</td>
    </tr>
    <tr>
    	<td id="right_center" >
            <div  style="height:213px; width:1150px; overflow:auto;">
            <table cellspacing="0" cellpadding="0"  id="maintain-right"  style="font-size:12px;">
                <tr class="two" align="center">
                    <td width="50" field="hh">行号</td>
                    <td style="color:#00F;border:1px solid #9EB6CE; border-left:0;"" width="100" field="chbm">存货编码</td>
                    <td width="200" field="chmc">存货名称</td>
                    <td width="100" field="xh">型号</td>
                    <td width="100" field="dw">单位</td>
                    <td width="100" field="pch">批次号</td>
                    <td width="100" field="scrq">生产日期</td>
					<td width="100" field="sxrq">失效日期</td>
					<td width="100" field="yfsl">应发数量</td>
					<td width="100" field="sfsl">实发数量</td>
					<td width="100" field="dj">单价</td>
					<td width="100" field="je">金额</td>
					<td width="100" field="ckrq">出库日期</td>
					<td width="200" field="zp">赠品</td>
					<td width="200" field="ytdjh">源头单据号</td>
					<td width="200" field="ythh">源头行号</td>
					<td width="200" field="ytdjh">来源单据号</td>
					<td width="200" field="ythh">来源行号</td>
					<td width="200" field="ljkpsl">累计开票数量</td>
					<td width="150" field="isckgb">是否发货关闭</td>
                </tr>
                <tr align="center">
                    <td style="width:30px; text-align:center; background:#E2E2E2;" item='hh'><input type="text" style="width:100%;" readonly="true" name="xsfhdzhibs[0].hh" value="1"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chbm"><input type="text" style="width:100%;" name="xsfhdzhibs[0].chbm"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chmc"><input type="text" style="width:100%;" name="xsfhdzhibs[0].chmc"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="xh"><input type="text" style="width:100%;" name="xsfhdzhibs[0].xh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dw"><input type="text" style="width:100%;" name="xsfhdzhibs[0].dw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="pch"><input type="text" style="width:100%;" name="xsfhdzhibs[0].pch"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="scrq"><input type="text" style="width:100%;" name="xsfhdzhibs[0].scrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sxrq"><input type="text" style="width:100%;" name="xsfhdzhibs[0].sxrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="yfsl"><input type="text" style="width:100%;" name="xsfhdzhibs[0].yfsl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sfsl"><input type="text" style="width:100%;" name="xsfhdzhibs[0].sfsl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dj"><input type="text" style="width:100%;" name="xsfhdzhibs[0].dj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="je"><input type="text" style="width:100%;" name="xsfhdzhibs[0].je"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ckrq"><input type="text" style="width:100%;" name="xsfhdzhibs[0].ckrq"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zp"><input type="text" style="width:100%;" name="xsfhdzhibs[0].zp"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ytdjh"><input type="text" style="width:100%;" name="xsfhdzhibs[0].ytdjh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ythh"><input type="text" style="width:100%;" name="xsfhdzhibs[0].ythh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ytdjh"><input type="text" style="width:100%;" name="xsfhdzhibs[0].lydjh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ythh"><input type="text" style="width:100%;" name="xsfhdzhibs[0].lyhh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ljkpsl"><input type="text" style="width:100%;" name="xsfhdzhibs[0].ljkpsl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="isckgb"><input type="text" style="width:100%;" name="xsfhdzhibs[0].isckgb"/></td>
                </tr>
                <tr class="other">
                   <td style="border:0"></td>
                </tr>
            </table>
           </div>
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
