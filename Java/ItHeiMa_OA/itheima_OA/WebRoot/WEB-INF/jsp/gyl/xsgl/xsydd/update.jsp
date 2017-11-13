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
<link rel="stylesheet" href="css/style_customer.css" type="text/css"/>
<script type="text/javascript" src="js/jquery.datepick.js"></script>
<script type="text/javascript" src="js/jquery.datepick-zh-CN.js"></script>
<script type="text/javascript" src="js/jquery-plugin-table.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$("#wrap").data("url","xsyddAction_updateUI_Info.action?query_zhub.ddh=");
			zhib_addEvent_Page();
			zhub_addEvent_Page();
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
<table id="wrap">
	<s:form action="xsyddAction_updateUI_Info.action">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px; width:1150px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F;">单据号</td>
                    <td class="inp"><s:textfield name="query_zhub.ddh"/></td>
                </tr>
                <tr>
                	<td colspan="5"></td>
                    <td height="40" align="center"><input type="button" id="search" zhu_id_name="query_zhub.ddh" value="查询" class="search"/></td>
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
                    <td width="90">订货日期</td>
                    <td width="90">失效日期</td>
                    <td width="180">客户名称</td>
                    <td width="90">整单扣率</td>
                    <td style="color:#00F;" width="90">销售部门</td>
                    <td  width="90">业务员</td>
                    <td style="color:#00F;"  width="90">开票单位</td>
                    <td width="90">收货地区</td>
                    <td  width="180">收货地址</td>
					<td  width="180">币种</td>
					<td  width="180">订单状态</td>
					<td  width="180">退货标志</td>
					<td  width="180">是否出库结束</td>
					<td  width="180">是否开票结束</td>
					<td  width="180">是否发货结束</td>
					<td  width="180">整单税价合计</td>
					<td  width="180">收现款金额</td>
                </tr>
                <s:if test="query_zhub.ddh!=null">
	                <tr field="item_zhu" id="${query_zhub.xsyddzhubid}">
	                	<!-- 
	                		idEdit为1代表可以修改
	                		               为0代表不可以修改
	                	 -->
	                   <s:hidden name="query_zhub.xsyddzhubid"></s:hidden>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="dhrq_zhu"><s:property value="query_zhub.dhrq"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="sxrq_zhu"><s:property value="query_zhub.sxrq"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="khmc_zhu"><s:property value="query_zhub.khmc"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="zdkl_zhu"><s:property value="query_zhub.zdkl"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="sxbm_zhu"><s:property value="query_zhub.sxbm"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="ywy_zhu"><s:property value="query_zhub.ywy"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="kpdw_zhu"><s:property value="query_zhub.kpdw"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="shdq_zhu"><s:property value="query_zhub.shdq"/></td>
	                   <td style="border-collapse:collapse;  empty-cells:show;" item="shdz_zhu"><s:property value="query_zhub.shdz"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;">人民币</td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="state_zhu"><s:property value="query_zhub.state"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="thbz_zhu"><s:property value="query_zhub.thbz"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="ckjsbz_zhu"><s:property value="query_zhub.ckjsbz"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="kpjsbz_zhu"><s:property value="query_zhub.kpjsbz"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="fhjsbz_zhu"><s:property value="query_zhub.fhjsbz"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="zdsjhj_zhu"><s:property value="query_zhub.zdsjhj"/></td>
					   <td style="border-collapse:collapse;  empty-cells:show;" item="sxkje_zhu"><s:property value="query_zhub.sxkje"/></td>
	                </tr>
                </s:if>
                <tr>
                   <td style="border:0"></td>
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
                    <td width="100">存货编码</td>
                    <td width="200">存货名称</td>
                    <td width="100">型号</td>
                    <td width="100">单位</td>
                    <td width="100">数量</td>
                    <td width="100">税率</td>
                    <td width="100">单品扣率</td>
					<td width="100">整单扣率</td>
					<td width="100">无税单价</td>
					<td width="100">含税单价</td>
					<td width="100">无税金额</td>
					<td width="100">含税金额</td>
					<td width="100">税额</td>
					<td width="200">折扣额</td>
					<td width="200">批次</td>
					<td width="200">公司</td>
					<td width="200">发货仓库</td>
					<td width="200">收货单位</td>
					<td width="150">计划发货日期</td>
					<td width="150">要求收货日期</td>
                    <td width="180">应发未出库数量</td>
                    <td width="180">累计发货数量</td>
                    <td width="180">累计出库数量</td>
                    <td width="180">累计开票数量</td>
                    <td width="180">累计应收数量</td>
                    <td width="180">是否出库关闭</td>
                    <td width="180">是否发货关闭</td>
                    <td width="180">是否开票关闭</td>
                    <td width="180">是否收款结束</td>
                    <td width="180">基本设置</td>
                </tr>
                <s:iterator value="#pageResult_zhib.rows" status="st1">
               	<tr class="other" field="item_zhib" id="${xsyddzhub.xsyddzhubid}">
                   <td style="border-collapse:collapse;  empty-cells:show;" item="hh_zhi"><s:property value="hh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="chbm_zhi"><s:property value="chbm"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="chmc_zhi"><s:property value="chmc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="xh_zhi"><s:property value="xh"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="dw_zhi"><s:property value="dw"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="sl_zhi"><s:property value="sl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="shulv_zhi"><s:property value="shulv"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="dpkl_zhi"><s:property value="dpkl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="zdkl_zhi"><s:property value="zdkl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="wsdj_zhi"><s:property value="wsdj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="hsdj_zhi"><s:property value="hsdj"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="wsje_zhi"><s:property value="wsje"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="hsje_zhi"><s:property value="hsje"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="se_zhi"><s:property value="se"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="zke_zhi"><s:property value="zke"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="pc_zhi"><s:property value="pc"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="gs_zhi"><s:property value="gs"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="fhck_zhi"><s:property value="fhck"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="shdw_zhi"><s:property value="shdw"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="jhfhrq_zhi"><s:property value="jhfhrq"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="yqshrq_zhi"><s:property value="yqshrq"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="yfwcksl_zhi"><s:property value="yfwcksl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="ljfhsl_zhi"><s:property value="ljfhsl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="ljcksl_zhi"><s:property value="ljcksl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="ljkpsl_zhi"><s:property value="ljkpsl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="ljyssl_zhi"><s:property value="ljyssl"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="isckgb_zhi"><s:property value="isckgb"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="isfhgb_zhi"><s:property value="isfhgb"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="iskpgb_zhi"><s:property value="iskpgb"/></td>
                   <td style="border-collapse:collapse;  empty-cells:show;" item="isskjs_zhi"><s:property value="isskjs"/></td>
                   <td height="40" align="center">
                   		<input type="button" value="修改" class="search"/>&nbsp; &nbsp;<input type="button" value="删除" class="search"/></td>
                   </td>

                </tr>
               </s:iterator>
                <tr class="other">
                   <td style="border:0"></td>
                </tr>
              </table>
              <p style="width:1800px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" flag="zhib_sy" value="首页"/>&nbsp;<input type="button" flag="zhib_syy" param="${pageResult_zhib.currentPage-1}" value="上一页" />&nbsp;<input type="button" flag="zhib_xyy" param="${pageResult_zhib.currentPage+1}" value="下一页"/>&nbsp;<input type="button" flag="zhib_wy" param="${pageResult_zhib.totalPages}" value="尾页"/>&nbsp;<span>转到第<input name="query_zhib.currentPage" id="pageNo_zhib" type="text" value="${pageResult_zhib.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${pageResult_zhib.totalRows}条记录，当前第 ${pageResult_zhib.currentPage}/${pageResult_zhib.totalPages}页</p>
           </div>
    	</td>
    </tr>
    <tr class="save">
       <td height="30" align="right" style="padding-right"><input type="button" value="保存" class="search"/></td>
     </tr>
     </s:form>
</table>
</body>
</html>
