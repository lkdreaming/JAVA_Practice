function zhib_addEvent_Page(){
	$("input[flag='zhib_sy']").click(function(){
		document.getElementById("pageNo_zhib").value = $(this).attr("param");
		//document.forms[0].submit();
	});
	$("input[flag='zhib_syy']").click(function(){
		//把当前的子表对应的主表的id获取到了
		var zhubid = $("tr[field='item_zhib']").attr("id");
		//获取到当前的页面
		document.getElementById("pageNo_zhib").value = $(this).attr("param");
		if($(this).attr("param")=="0"){
			alert("已经是第一页了");
		}else{
			document.forms[0].action =  $("#wrap").data("url")+zhubid;
			document.forms[0].submit();
		}
	});	
	$("input[flag='zhib_xyy']").click(function(){
		//获取当前的子表对应的主表的ID
		var zhubid = $("tr[field='item_zhib']").attr("id");
		//当前的页码
		document.getElementById("pageNo_zhib").value = $(this).attr("param");
		document.forms[0].action = $("#wrap").data("url")+zhubid;
		document.forms[0].submit();
	});	
	$("input[flag='zhib_wy']").click(function(){
		document.getElementById("pageNo_zhib").value = $(this).attr("param");
		document.forms[0].submit();
	});	
}
