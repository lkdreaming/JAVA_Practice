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
		$(document).ready(function() {
			//使用class属性处理  'yy-mm-dd' 设置格式"yyyy/mm/dd"
			$('#dhrq').datepick({
				dateFormat : 'yy-mm-dd'
			});
			$('#sxrq').datepick({
				dateFormat : 'yy-mm-dd'
			});
		});
		$(function() {
			$('.tab li').mouseover(function() {
				var num = $(this).index() - 1;
				$(this).addClass('current').siblings().removeClass();
				$('this:eq(num)').remove('span');
			})
		})
		$(function() {
			$('li').mouseover(function() {
				$(this).addClass('current').siblings().removeClass('current');
			})
		})
		function data() {
			window.open("customer.html", 100, 200);
		}
	</script>
</head>
<body>
	<s:form action="xsysdAction_add.action">
		<table id="wrap">
			<tr>
				<td id="rig_top">
					<div style="overflow:auto; height:190px; width:1150px;">
						<table class="content" style="font-size:12px;">
							<tr>
								<td class="one" style="color:#00F;">公司</td>
								<td class="inp"><input type="text"
									style="background:url(images/search.png) no-repeat 226px center #F6F9FD;"
									name="query_zhub.gs" /></td>
								<td class="one" style="color:#00F;">日期</td>
								<td class="inp"><input type="text"
									style="background:url(images/search.png) no-repeat 226px center #F6F9FD;"
									name="query_zhub.rq" /></td>
							</tr>
							<tr>
								<td style="color:#00F">起算日期</td>
								<td class="inp"><input type="text"
									style="background:url(images/search.png) no-repeat 226px center #F6F9FD;"
									name="query_zhub.qsrq" /></td>
								<td style="color:#00F">往来对象</td>
								<td class="inp"><input type="text" style="text-align:right"
									name="query_zhub.wldx" /></td>
								<td style="color:#00F">客商</td>
								<td class="inp"><input type="text" style="text-align:right"
									name="query_zhub.ks" /></td>
							</tr>
							<tr>
								<td class="one" style="color:#00F">部门</td>
								<td class="inp"><input type="text"
									style="background:url(images/search.png) no-repeat 226px center #F6F9FD;"
									name="query_zhub.bm" /></td>
								<td class="one" style="color:#00F">业务员</td>
								<td class="inp"><input type="text"
									style="background:url(images/search.png) no-repeat 226px center #F6F9FD;"
									name="query_zhub.ywy" /></td>
								<td class="one" style="color:#00F">生效标志</td>
								<td class="inp"><input type="text"
									style="background:url(images/search.png) no-repeat 226px center #F6F9FD;"
									name="query_zhub.sxbz" /></td>
							</tr>
							<tr>
								<td class="one" style="width:66px;">制单人</td>
								<td class="inp"><input type="text" name="query_zhub.zdr" /></td>
							</tr>
							<tr>
								<td class="one" style="width:66px;">制单时间</td>
								<td class="inp"><input type="text" name="query_zhub.zdrq" /></td>
								<td class="one" style="width:66px;">审批人</td>
								<td class="inp"><input type="text" name="query_zhub.shr" /></td>
								<td class="one" style="width:66px;">审批时间</td>
								<td class="inp"><input type="text" name="query_zhub.shrq" /></td>
							</tr>
							<tr>
								<td class="one" style="width:66px;">修改人</td>
								<td class="inp"><input type="text" name="query_zhub.xgr" /></td>
								<td class="one" style="width:66px;">修改时间</td>
								<td class="inp"><input type="text" name="query_zhub.xgrq" /></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td id="rig_top">
					<div style=" overflow:auto; height:230px; width:1150px;">
						<table cellspacing="0" cellpadding="0" id="maintain-top"
							align="center" width="2000" style="font-size:12px;">
							<tr class="one">
								<td width="90">公司</td>
								<td width="90">日期</td>
								<td width="180">起算日期</td>
								<td width="90">往来对象</td>
								<td style="color:#00F;" width="90">客商</td>
								<td width="90">部门</td>
								<td style="color:#00F;" width="90">业务员</td>
								<td width="90">生效标志</td>
							</tr>
							<s:iterator value="#pageResult_zhub.rows" status="st">
								<tr>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="gs" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="rq" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="qsrq" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="wldx" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="ks" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="bm" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="ywy" /></td>
									<td style="border-collapse:collapse;  empty-cells:show;"><s:property
											value="sxbz" /></td>
								</tr>
							</s:iterator>
							<tr style="background:#ECF4FB; font-size:12px;" height="30">
								<td colspan="5"
									style="border-right:0;border-top:1px solid #8FAFD7;">&nbsp;&nbsp;共有
									120 条记录，当前第 1/10 页</td>
								<td colspan="3"
									style="border-right:0; padding-right:80px;border-top:1px solid #8FAFD7;"
									align="right" class="page"><input type="button" value="首页" />&nbsp;<input
									type="button" value="上一页" />&nbsp;<input type="button"
									value="下一页" />&nbsp;<input type="button" value="尾页" />&nbsp;<span>转到第
										<input name="textfield" type="text" size="4"
										style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />
										页
								</span>&nbsp;&nbsp;<input type="button" value="转"
									style=" padding:0 10px;" /></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
			<tr>
				<td id="right_center">
					<div style="height:213px; width:1150px; overflow:auto;">
						<table cellspacing="0" cellpadding="0" id="maintain-right"
							style="font-size:12px;">
							<tr class="two" align="center">
								<td width="50" field="hh">行号</td>
								<td style="color:#00F;border:1px solid #9EB6CE; border-left:0;"
									" width="100" field="spbm">商品编码</td>
								<td width="200" field="spmc">商品名称</td>
								<td width="100" field="dw">单位</td>
								<td width="100" field="sl">数量</td>
								<td width="200" field="dj">单价</td>
								<td width="100" field="hsje">含税金额</td>
								<td width="100" field="wsje">无税金额</td>
								<td width="200" field="ytdjh">源头单据号</td>
								<td width="200" field="ythh">源头行号</td>
								<td width="200" field="lydjh">来源单据号</td>
								<td width="200" field="lyhh">来源行号</td>
							</tr>
							<s:iterator value="#pageResult_zhib.rows" status="st">
								<tr align="center">
									<td style="width:30px; text-align:center; background:#E2E2E2;"
										item='hh'><s:property value="hh"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="chbm"><s:property value="chbm"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="chmc"><s:property value="chmc"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="dw"><s:property value="dw"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="sl"><s:property value="sl"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="dj"><s:property value="dj"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="hsje"><s:property value="hsje"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="wsje"><s:property value="wsje"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="ytdjh"><s:property value="ytdjh"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="ythh"><s:property value="ythh"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="lydjh"><s:property value="lydjh"/></td>
									<td style="border-collapse:collapse;  empty-cells:show;"
										item="lyhh"><s:property value="lyhh"/></td>
								</tr>
							</s:iterator>
						</table>
						<p style="width:1000px; height:20px;font-size:12px;">
							<span class="page" style="float:right"> <input
								type="button" param="1" flag="zhib_sy" value="首页" />&nbsp;<input
								type="button" flag="zhib_syy"
								param="${pageResult_zhib.currentPage-1}" value="上一页" />&nbsp;<input
								type="button" flag="zhib_xyy"
								param="${pageResult_zhib.currentPage+1}" value="下一页" />&nbsp;<input
								type="button" flag="zhib_wy"
								param="${pageResult_zhib.totalPages}" value="尾页" />&nbsp;<span>转到第<input
									name="query_zhib.currentPage" id="pageNo_zhib" type="text"
									value="${pageResult_zhib.currentPage}" size="4"
									style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页
							</span>&nbsp;&nbsp;<input type="button" value="转"
								style=" padding:0 10px;" />
							</span>&nbsp;&nbsp;共有${pageResult_zhib.totalRows}条记录，当前第
							${pageResult_zhib.currentPage}/${pageResult_zhib.totalPages}页
						</p>
					</div>
				</td>
			</tr>
			<tr class="save">
				<td height="30" align="right" style="padding-right"><input
					type="submit" value="保存" class="search" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>