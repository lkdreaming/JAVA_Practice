(function($){
	$.fn.GridPanel = {
		edit:function(){
			var tdText = $(this).text();
			if ($(this).find("input[type='text']").length == 0) {
                            //删除td下面所有的内容
                        	$(this).empty();
							var $text = $("<input/>")
                            $text.attr("type", "text");
                            $(this).append($text);
							/**
							 * 先获取焦点，再追加文本
							 */
							$text.focus();
							$text.attr("value", tdText);
							/**
							 * 给文本框增加一个失去焦点事件
							 */
							$text.unbind("blur");
							$text.bind("blur",function(){
								
							});
                        }
		},
		/**
		 * 文本框失去焦点事件
		 */
		textBlur:function(){
			var $txtText = $(this).val();
			var aa = $(this);
			var jsonStr = {}; 
			jsonStr['ddh'] = $("input[name='query_zhub.ddh']").val();
			jsonStr['item'] = $(this).parent().attr("item");
			jsonStr[aa.parent().attr("item")] = $txtText;
			
			if($(this).parent().siblings('td[item=hh_zhi]').text()!=""){
				jsonStr['hh'] = $(this).parent().siblings('td[item=hh_zhi]').text();
			}
			$.post($.fn.GridPanel.defaults.url,jsonStr,function(data){
				var $td = aa.parent();
				$td.empty();
				$td.text($txtText);
			});
		},
		init:function(config){
			$.extend($.fn.GridPanel.defaults,config);
			$("table").delegate("td[item]","click",function(){
				$.fn.GridPanel.edit.call(this);
			});
			$("table").delegate("input[type='text']:not(input[name='query_zhub.ddh'])","blur",function(){
				$.fn.GridPanel.textBlur.call(this);
			});
		},
		defaults:{
			url:''
		}
	};
})($);

$().ready(function(){
	$.fn.GridPanel.init({
		url:'xsyddAction_update.action'
	});
});
