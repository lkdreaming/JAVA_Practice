function zhub_addEvent_Page(){
	/**
	 *  在这个页面被加载的时候，把分页的请求的url放入到jquery的缓存中,把数据缓存到整个table中
	 *  一个页面上就一个table
	 */

	//给主表的分页的首页添加一个click事件
	$("input[flag='zhub_sy']").click(function(){
		// $(this).attr("param")  当前页码
		document.getElementById("pageNo").value = $(this).attr("param");
		document.forms[0].submit();
	});
	$("input[flag='zhub_syy']").click(function(){
		document.getElementById("pageNo").value = $(this).attr("param");
		if($(this).attr("param")=="0"){
			alert("已经是第一页了");
		}else{
			document.forms[0].submit();
		}
	});	
	$("input[flag='zhub_xyy']").click(function(){
		var zhubid = $("tr[field='item_zhib']").attr("id");
		document.getElementById("pageNo").value = $(this).attr("param");
		//document.forms[0].action = $("#wrap").data("url")+zhubid;
		document.forms[0].submit();
	});	
	$("input[flag='zhub_wy']").click(function(){
		document.getElementById("pageNo").value = $(this).attr("param");
		document.forms[0].submit();
	});	
}
