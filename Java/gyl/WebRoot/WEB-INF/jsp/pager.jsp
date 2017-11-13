<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<p style="width:1800px; height:20px;font-size:12px;">
	<span class="page" style="float:right">
		<input type="button" param="1" value="首页"/>&nbsp;<input type="button" param="${pageResult_zhub.currentPage-1}" value="上一页" />&nbsp;<input type="button" param="${pageResult_zhub.currentPage+1}" value="下一页"/>&nbsp;<input type="button" param="${pageResult_zhub.totalPages}" value="尾页"/>&nbsp;<span>转到第<input name="baseQuery.currentPage" id="pageNo" type="text" value="${pageResult_zhub.currentPage}" size="4" style="height:16px; width:28px; border:1px solid #999999; background:#FFF; border-radius:0;" />页 </span>&nbsp;&nbsp;<input type="button" value="转" style=" padding:0 10px;"/>
	</span>&nbsp;&nbsp;共有${pageResult_zhub.totalRows}条记录，当前第 ${pageResult_zhub.currentPage}/${pageResult_zhub.totalPages}页</p>
                	