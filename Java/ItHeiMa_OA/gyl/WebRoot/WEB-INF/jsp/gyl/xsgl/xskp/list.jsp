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
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">开票日期</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td style="color:#00F">开票类型</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td style="color:#00F">会计年度</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">客户</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td class="one" style="color:#00F">客户打印名称</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                	<td class="one" style="color:#00F">部门</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">业务员</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td class="one" style="color:#00F">收货单位</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">收货地址</td>
                    <td class="inp"><input type="text" id='dhrq'/></td>
                </tr>
				<tr>
					<td class="one" style="color:#00F">整单折扣</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
					<td class="one" style="width:66px;">仓库</td>
                    <td class="inp"><input type="text"/></td>
					<td class="one" style="color:#00F">币种</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">发票总金额</td>
                    <td class="inp"><input type="text"/></td>
                    <td class="one" style="width:66px;">状态</td>
                    <td class="inp"><input type="text"/></td>
                    <td class="one" style="width:66px;">制单人</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">制单时间</td>
                    <td class="inp"><input type="text"/></td>
                    <td class="one" style="width:66px;">审批人</td>
                    <td class="inp"><input type="text"/></td>
                    <td class="one" style="width:66px;">审批时间</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
				<tr>
					<td class="one" style="width:66px;">修改人</td>
                    <td class="inp"><input type="text"/></td>
                    <td class="one" style="width:66px;">修改时间</td>
                    <td class="inp"><input type="text"/></td>
				</tr>
				<tr>
                	<td colspan="5"></td>
                    <td height="40" align="center"><input type="button" value="查询" class="search"/></td>
                </tr>
            </table>
           </div>
		</td>
    </tr>
	<tr>
    	<td id="rig_top" >
            <div   style=" overflow:auto; height:230px; width:1150px;">
            <table cellspacing="0" cellpadding="0" id="maintain-top" align="center"  width="2000"  style="font-size:12px;">
                <tr class="one">
                    <td width="90">公司</td>
                    <td width="90">发票号</td>
                    <td width="180">开票日期</td>
                    <td width="90">开票类型</td>
                    <td style="color:#00F;" width="90">会计年度</td>
                    <td  width="90">客户</td>
                    <td style="color:#00F;"  width="90">客户打印名称</td>
                    <td width="90">部门</td>
                    <td  width="180">业务员</td>
					<td  width="180">收货单位</td>
					<td  width="180">收货地址</td>
					<td  width="180">整单折扣</td>
					<td  width="180">仓库</td>
					<td  width="180">币种</td>
					<td  width="180">发票总金额</td>
					<td  width="180">状态</td>
                </tr>
                <s:iterator value="#pageResult_zhub.rows" status="st">
                <tr>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="gs"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="fph"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="kprq"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="kplx"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="kjnd"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="kh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="khdymc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="bm"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ywy"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="shdw"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="shdz"/></td>
				   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zdzk"/></td>
				   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ck"/></td>
				   <td style="border-collapse:collapse;  empty-cells:show;">人民币</td>
				   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="fpzje"/></td>
				   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="status"/></td>
                </tr>
                </s:iterator>
                <tr>
                   <td style="border:0"></td>
                </tr>
                <tr style="background:#ECF4FB; font-size:12px;"  height="30">
                <td colspan="10" style="border-right:0;border-top:1px solid #8FAFD7;">&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页</td>
                 <td colspan="6" style="border-right:0; padding-right:80px;border-top:1px solid #8FAFD7;" align="right" class="page"><input type="button" value="首页"/>&nbsp;<input type="button" value="上一页" />&nbsp;<input type="button" value="下一页"/>&nbsp;<input type="button" value="尾页"/>&nbsp;<span>转到第 <input name="textfield" type="text" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" /> 页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
                </td>
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
                    <td width="50">行号</td>
                    <td style="color:#00F;border:1px solid #9EB6CE; border-left:0;"" width="100">商品编码</td>
                    <td width="200">商品名称</td>
                    <td width="100">型号</td>
                    <td width="100">单位</td>
                    <td width="100">数量</td>
                    <td width="100">单品折扣</td>
					<td width="100">税率</td>
					<td width="100">含税单价</td>
					<td width="100">无税单价</td>
					<td width="100">含税金额</td>
					<td width="100">无税金额</td>
					<td width="200">折扣额</td>
					<td width="200">源头单据号</td>
					<td width="200">源头行号</td>
					<td width="200">来源单据号</td>
					<td width="200">来源行号</td>
					<td width="150">赠品</td>
					<td width="150">仓库</td>
					<td width="150">收货单位</td>
					<td width="150">币种</td>
					<td width="150">是否开票结束</td>
					<td width="150">是否收款结束</td>
					<td width="150">行状态</td>
                </tr>
                <s:iterator value="#pageResult_zhib.rows" status="st">
                <tr class="other">
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="hh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="spbm"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="spmc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="xh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="dw"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="sl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zpzk"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="shulv"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="hsdj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="wsdj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="hsje"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="wsje"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zke"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ytdjh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ythh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="lydjh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="lyhh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="zp"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="ck"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="shdw"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;">人民币</td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="iskpjs"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="isskjs"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;"><s:property value="status"/></td>
                </tr>                
                </s:iterator>
                <tr class="other">
                   <td style="border:0"></td>
                </tr>
                <tr style="background:#ECF4FB; font-size:12px;"  height="30">
                <td colspan="13" style="border-right:0;border-top:1px solid #8FAFD7;">&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页</td>
                <td colspan="11" style="border-right:0; padding-right:80px;border-top:1px solid #8FAFD7;" align="right" class="page"><input type="button" value="首页"/>&nbsp;<input type="button" value="上一页" />&nbsp;<input type="button" value="下一页"/>&nbsp;<input type="button" value="尾页"/>&nbsp;<span>转到第 <input name="textfield" type="text" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" /> 页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
                </td>
                </tr>
            </table>
           </div>
    	</td>
    </tr>
    <tr>
    	<td id="mantain-bot">
            <div class="last"></div>
        </td>
    </tr>
</table>
</s:form>
</body>
</html>
