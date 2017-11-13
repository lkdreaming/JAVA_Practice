<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
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
<table id="wrap">
	<tr>
    	<td id="rig_top" >
            <div   style="overflow:auto; height:190px; width:1150px;">
            <table class="content" style="font-size:12px;">
                <tr>
                    <td class="one" style="color:#00F;">公司</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td class="one" style="color:#00F;">单据号</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">单据日期</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td style="color:#00F">仓库</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td style="color:#00F">库管员</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                </tr>
                <tr>
                    <td class="one" style="color:#00F">部门</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                    <td class="one" style="color:#00F">制单人</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                	<td class="one" style="color:#00F">制单时间</td>
                    <td class="inp"><input type="text"  style="background:url(images/search.png) no-repeat 226px center #F6F9FD;" onclick="data()"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">签字人</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td style="color:#00F">签字时间</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                    <td style="color:#00F">修改人</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
                </tr>
                <tr>
                    <td style="color:#00F">修改时间</td>
                    <td class="inp"><input type="text" value="1.00" style="text-align:right"/></td>
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
                	<td style="width:20px; border-right:0;">&nbsp;</td>
                    <td width="100">公司</td>
                    <td width="90">单据号</td>
                    <td width="90">单据日期</td>
                    <td width="90">仓库</td>
                    <td width="90">库管员</td>
                    <td width="90">部门</td>
                    <td style="color:#00F;"  width="90">制单人</td>
                    <td width="90">制单时间</td>
                    <td width="90">签字人</td>
                    <td width="90">签字时间</td>
                    <td width="90">修改人</td>
                    <td width="90">修改时间</td>
                </tr>
                <tr>
                   <td align="center" style="background:#E2E2E2">1</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                </tr>
                <tr>
                   <td align="center" style="background:#E2E2E2">2</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                </tr>
                <tr>
                   <td align="center" style="background:#E2E2E2">3</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
				   <td>&nbsp;</td>
				   <td>&nbsp;</td>
				   <td>&nbsp;</td>
				   <td>&nbsp;</td>
				   <td>&nbsp;</td>
                </tr>
                <tr>
                   <td align="center" style="background:#E2E2E2">4</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                </tr>
                <tr>
                   <td align="center" style="background:#E2E2E2">5</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                </tr>
                <tr>
                   <td align="center" style="background:#E2E2E2">6</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                </tr>
                <tr>
                   <td style="border:0"></td>
                </tr>
                <tr style="background:#ECF4FB; font-size:12px;"  height="30">
                <td colspan="15" style="border-right:0;border-top:1px solid #8FAFD7;">&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页</td>
                 <td colspan="4" style="border-right:0; padding-right:80px;border-top:1px solid #8FAFD7;" align="right" class="page"><input type="button" value="首页"/>&nbsp;<input type="button" value="上一页" />&nbsp;<input type="button" value="下一页"/>&nbsp;<input type="button" value="尾页"/>&nbsp;<span>转到第 <input name="textfield" type="text" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" /> 页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
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
                  	<td style="width:10px; border-right:0">&nbsp;</td>
                    <td width="50">行号</td>
                    <td style="color:#00F;border:1px solid #9EB6CE; border-left:0;"" width="100">存货编码</td>
                    <td width="200">存货名称</td>
                    <td width="100">规格</td>
                    <td width="100">型号</td>
                    <td width="100">单位</td>
                    <td width="100">批次</td>
                    <td width="100">数量</td>
                    <td width="100">单价</td>
					<td width="100">金额</td>
					<td width="100">入库日期</td>
                    <td width="180">基本设置</td>
                </tr>
                <tr class="other">
                   <td align="center" style="background:#E2E2E2;height:19px; border:0; border-right:1px solid #9EB6CE; border-bottom:1px solid #9EB6CE;">1</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td><div align="center"><span><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>

                </tr>
                <tr class="other">
                   <td align="center" style="background:#E2E2E2">2</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
					<td><div align="center"><span><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>

                </tr>
                <tr class="other">
                   <td align="center" style="background:#E2E2E2">3</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td><div align="center"><span><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>

                </tr>
                <tr class="other">
                   <td align="center" style="background:#E2E2E2">4</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td><div align="center"><span><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>

                </tr>
                <tr class="other">
                   <td align="center" style="background:#E2E2E2">5</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td><div align="center"><span><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>

                </tr>
                <tr class="other">
                   <td align="center" style="background:#E2E2E2">6</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td><div align="center"><span><img src="images/edt.gif" width="16" height="16" />编辑&nbsp; &nbsp;<img src="images/del.gif" width="16" height="16" />删除</span></div></td>

                </tr>
                <tr class="other">
                   <td style="border:0"></td>
                </tr>
                <tr style="background:#ECF4FB; font-size:12px;"  height="30">
                <td colspan="13" style="border-right:0;border-top:1px solid #8FAFD7;">&nbsp;&nbsp;共有 120 条记录，当前第 1/10 页</td>
                <td colspan="11" style="border-right:0; padding-right:80px;border-top:1px solid #8FAFD7;" align="right" class="page"><input type="button" value="首页"/>&nbsp;<input type="button" value="上一页" />&nbsp;<input type="button" value="下一页"/>&nbsp;<input type="button" value="尾页"/>&nbsp;<span>转到第 <input name="textfield" type="text" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" /> 页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
                </td>
                </tr> 
                <tr style="background:#E2E2E2;">
                    <td style="width:30px; text-align:center;border:1px solid #D0D7E5; border-left:0;">合计</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                    <td style="border:1px solid #D0D7E5; border-left:0;">&nbsp;</td>
                </tr>
            </table>
           </div>
    	</td>
    </tr>
    <tr>
    	<td id="right-bot">
            <table  style="font-size:12px;">
                <tr>
                    <td class="bot_1" style="color:#00F">制单人</td>
                    <td class="inp_1"><input type="text"/></td>
                    <td class="bot_1" style="color:#00F">修订人</td>
                    <td class="inp_1"><input type="text"/></td>
                    <td class="bot_1">审批人</td>
                    <td class="inp_1"><input type="text"/></td>
                    <td  width="77px">审批日期</td>
                    <td class="inp_1"><input type="text" style="background:url(images/date.png) no-repeat 169px center;"/></td>
                </tr>
                <tr>
                    <td>制单时间</td>
                    <td class="inp_2"><input type="text"/></td>
                    <td>修订时间</td>
                    <td class="inp_2"><input type="text"/></td>
                    <td>审批时间</td>
                    <td class="inp_2"><input type="text"/></td>
                    <td>最后修改时间</td>
                    <td class="inp_2"><input type="text"/></td>
                </tr>
            </table>
        </td>
    </tr>
    <tr>
    	<td id="mantain-bot">
            <div class="last"></div>
        </td>
    </tr>
</table>
</body>
</html>
