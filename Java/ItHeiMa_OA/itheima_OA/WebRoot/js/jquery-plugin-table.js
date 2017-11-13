(function($){
	$.fn.GridPanel = {
		edit:function(){
			//this代表主表和子表中的每一个td
			var tdText = $(this).text();
			if ($(this).find("input[type='text']").length == 0) {
                            //删除td下面所有的内容
                        	$(this).empty();
                        	//创建一个文本域，把文本域追加到td上
							var $text = $("<input/>")
                            $text.attr("type", "text");
                            $(this).append($text);
							/**
							 * 先获取焦点，再追加文本
							 */
							$text.focus();
							$text.attr("value", tdText);
                        }
		},
		/**
		 * 文本框失去焦点事件
		 */
		textBlur:function(){
			//this代表文本框
			var $txtText = $(this).val();
			var aa = $(this);
			var jsonStr = {};
			/**
			 *  <tr>
                    <td class="one" style="color:#00F;">单据号</td>
                    <td class="inp"><s:textfield name="query_zhub.ddh"/></td>
                </tr>
			 */
			jsonStr['ddh'] = $("input[name='query_zhub.ddh']").val();
			jsonStr['item'] = $(this).parent().attr("item");
			//<td style="border-collapse:collapse;  empty-cells:show;" item="dhrq_zhu"><s:property value="query_zhub.dhrq"/></td>
			jsonStr[aa.parent().attr("item")] = $txtText;
			
			/**
			 * <td style="border-collapse:collapse;  empty-cells:show;" item="hh_zhi"><s:property value="hh"/></td>
               <td style="border-collapse:collapse;  empty-cells:show;" item="chbm_zhi"><s:property value="chbm"/></td>
               <td style="border-collapse:collapse;  empty-cells:show;" item="chmc_zhi"><s:property value="chmc"/></td>
			 */
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
