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
<s:form action="xskpAction_add.action">
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px; width:1150px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F;">公司</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.gs"/></td>
                    <td class="one" style="color:#00F;">发票号</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.fph"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">开票日期</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.kprq"/></td>
                    <td style="color:#00F">开票类型</td>
                    <td class="inp"><input type="text" style="text-align:right" name="query_zhub.fplx"/></td>
                    <td style="color:#00F">会计年度</td>
                    <td class="inp"><input type="text" style="text-align:right" name="query_zhub.kjnd"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">客户</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.kh"/></td>
                    <td class="one" style="color:#00F">客户打印名称</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.khdymc"/></td>
                	<td class="one" style="color:#00F">部门</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.bm"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">业务员</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right" name="query_zhub.ywy"/></td>
                    <td class="one" style="color:#00F">收货单位</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.shdw"/></td>
					<td class="one" style="width:66px;">收货地址</td>
                    <td class="inp"><input type="text" id='dhrq' name="query_zhub.shdz"/></td>
                </tr>
				<tr>
					<td class="one" style="color:#00F">整单折扣</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" name="query_zhub.zdzk"/></td>
					<td class="one" style="width:66px;">仓库</td>
                    <td class="inp"><input type="text" name="query_zhub.ck"/></td>
					<td class="one" style="color:#00F">币种</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">发票总金额</td>
                    <td class="inp"><input type="text" name="query_zhub.fpzje"/></td>
                    <td class="one" style="width:66px;">状态</td>
                    <td class="inp"><input type="text" name="query_zhub.status"/></td>
                    <td class="one" style="width:66px;">制单人</td>
                    <td class="inp"><input type="text" name="query_zhub.zdr"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">制单时间</td>
                    <td class="inp"><input type="text" name="query_zhub.zdsj"/></td>
                    <td class="one" style="width:66px;">审批人</td>
                    <td class="inp"><input type="text" name="query_zhub.spr"/></td>
                    <td class="one" style="width:66px;">审批时间</td>
                    <td class="inp"><input type="text" name="query_zhub.spsj"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">修改人</td>
                    <td class="inp"><input type="text" name="query_zhub.xgr"/></td>
                    <td class="one" style="width:66px;">修改时间</td>
                    <td class="inp"><input type="text" name="query_zhub.xgsj"/></td>
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
                    <td style="color:#00F;border:1px solid #9EB6CE; border-left:0;"" width="100" field="spbm">商品编码</td>
                    <td width="200" field="spmc">商品名称</td>
                    <td width="100" field="xh">型号</td>
                    <td width="100" field="dw">单位</td>
                    <td width="100" field="sl">数量</td>
                    <td width="100" field="zpkl">单品扣率</td>
					<td width="100" field="shulv">税率</td>
					<td width="100" field="wsdj">无税单价</td>
					<td width="100" field="hsdj">含税单价</td>
					<td width="100" field="hsje">含税金额</td>
					<td width="100" field="wsje">无税金额</td>
					<td width="200" field="zke">折扣额</td>
					<td width="200" field="ytdjh">源头单据号</td>
					<td width="200" field="ythh">源头行号</td>
					<td width="200" field="lydjh">来源单据号</td>
					<td width="200" field="lyhh">来源行号</td>
					<td width="150" field="zp">赠品</td>
					<td width="150" field="ck">仓库</td>
					<td width="150" field="shdw">收货单位</td>
					<td width="150">币种</td>
					<td width="150" field="iskpjs">是否开票结束</td>
					<td width="150" field="isskjs">是否收款结束</td>
					<td width="150" field="status">行状态</td>
                </tr>                
                <tr align="center">
                    <td style="width:30px; text-align:center; background:#E2E2E2;" item='hh'><input type="text" style="width:100%;" readonly="true" name="xskpzhibs[0].hh" value="1"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chbm"><input type="text" style="width:100%;" name="xskpzhibs[0].chbm"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="chmc"><input type="text" style="width:100%;" name="xskpzhibs[0].chmc"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="xh"><input type="text" style="width:100%;" name="xskpzhibs[0].xh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dw"><input type="text" style="width:100%;" name="xskpzhibs[0].dw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="sl"><input type="text" style="width:100%;" name="xskpzhibs[0].sl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="dpkl"><input type="text" style="width:100%;" name="xskpzhibs[0].dpkl"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shulv"><input type="text" style="width:100%;"  name="xskpzhibs[0].shulv"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsdj"><input type="text" style="width:100%;"  name="xskpzhibs[0].wsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsdj"><input type="text" style="width:100%;"  name="xskpzhibs[0].hsdj"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="hsje"><input type="text" style="width:100%;" name="xskpzhibs[0].hsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="wsje"><input type="text" style="width:100%;" name="xskpzhibs[0].wsje"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zke"><input type="text" style="width:100%;" name="xskpzhibs[0].zke"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ytdjh"><input type="text" style="width:100%;"  name="xskpzhibs[0].ytdjh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ythh"><input type="text" style="width:100%;"  name="xskpzhibs[0].ythh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="lydjh"><input type="text" style="width:100%;"  name="xskpzhibs[0].lydjh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="lyhh"><input type="text" style="width:100%;"  name="xskpzhibs[0].lyhh"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="zp"><input type="text" style="width:100%;"  name="xskpzhibs[0].zp"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="ck"><input type="text" style="width:100%;"  name="xskpzhibs[0].ck"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="shdw"><input type="text" style="width:100%;"  name="xskpzhibs[0].shdw"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;">人民币</td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="iskpjs"><input type="text" style="width:100%;"  name="xskpzhibs[0].iskpjs"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="isskjs"><input type="text" style="width:100%;"  name="xskpzhibs[0].isskjs"/></td>
                    <td style="border-collapse:collapse;  empty-cells:show;" item="status"><input type="text" style="width:100%;"  name="xskpzhibs[0].status"/></td>
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
</body>
</html>