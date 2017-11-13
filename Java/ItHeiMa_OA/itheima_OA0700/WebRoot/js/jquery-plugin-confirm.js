(function($){
	$.oaconfirm = function(){
		$("a").each(function(){
			if($(this).text()=="删除") {
				$(this).unbind("click");
				$(this).bind("click",function(){
					return window.confirm("您确认要删除吗?");
				});
			}
		});
	};
})($);
