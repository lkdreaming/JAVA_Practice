$().ready(function(){
	/**
	 * 在进行修改的时候，先根据订单号过滤出要修改的主表的内容和子表的内容,给search添加click事件
	 */
	$("#search").click(function(){
		var idName = $(this).attr("zhu_id_name");
		var data = $("input[name='"+idName+"']").val();
		window.location.href = $("#wrap").data("url")+data;	
	});
	
	
    /**
     * 在主表的表格中，给所有的数据的tr添加click事件,加载相应的子表格中的数据
     */
    $("tr[field='item']").unbind("click");
    $("tr[field='item']").bind("click", function(){
		//获取主表表格的每一行的id值
        var zhubid = $(this).attr("id");
		//xsyddAction_showAllXsydd.action?query_zhib.xsyddzhubid=zhubid
        document.forms[0].action = $("#wrap").data("url") + zhubid;
        document.forms[0].submit();
    });
    
	$("#right_center").delegate("td[item='hh']",'contextmenu',function(e){
		$("#menu").css("left", e.clientX-50);
        $("#menu").css("top", e.clientY);
        $("#menu").show();
        return false;
	});
	
	/**
	 * 给所有的子表中的文本框的name属性的值的最后字符串为"wsdj"添加onblur事件
	 */
	$("#right_center").delegate("input[name*='wsdj']",'blur',function(){
		//为税率
		var shuilv = $(this).parent().siblings("td[item='shulv']").children("input[name*='shulv']").val();
		//数量
		var sl = $(this).parent().siblings("td[item='sl']").children("input[name*='sl']").val();
		//单品扣率
		var dpkl = $(this).parent().siblings("td[item='dpkl']").children("input[name*='dpkl']").val();
		//无税单价
		var wsdj = $(this).val();
		//含税单价
		var hsdj = Math.round(wsdj*(1+Number(shuilv)));
		$(this).parent().siblings("td[item='hsdj']").children("input").val(hsdj);
		//无税金额
		var wsje = Math.round(Number(sl)*Number(wsdj));
		$(this).parent().siblings("td[item='wsje']").children("input").val(wsje);
		//价税合计  一个商品的
		var hsje = Math.round(wsje*(1+Number(shuilv)-Number(dpkl)));
		$(this).parent().siblings("td[item='hsje']").children("input").val(hsje);
		//税额
		var se = Math.round(hsdj*Number(shuilv));
		$(this).parent().siblings("td[item='se']").children("input").val(se);
		//折扣额
		var zke = Math.round(hsdj*dpkl);
		$(this).parent().siblings("td[item='zke']").children("input").val(zke);
	});
//    $("td[item='hh']").unbind('contextmenu');
//    $("td[item='hh']").bind('contextmenu', function(e){
//        $("#menu").css("left", e.clientX-50);
//        $("#menu").css("top", e.clientY);
//        $("#menu").show();
//        return false;
//    });
    
    var index = 1;
	var dd = 2;//行号
    $("#addRow").click(function(){
		var zhib = $("#zhib").val();
        var me = $("#right_center");
        var columns = me.find("table *[field]");
        var table = me.find("table");
        //		var tbody = table.find("tbody");
        //		if(tbody.size()==0){
        //			tbody = $("<tbody></tbody>");
        //			table.append(tbody);
        //		}
        var tr = $("<tr></tr>");
        for (var i = 0; i < columns.length; i++) {
            var td = createTD(zhib, index, $(columns[i]).attr("field"));
            tr.append(td);
        }
        table.append(tr);
        index++;
		dd++;
        $("#menu").hide();
    });
    
    /**
     * 动态拼接一行tr
     */
    function renderRow(){
    
    }
    
    /**
     * @param {Object} viewBeans 将来在action中List的名称
     * @param {Object} index  list中的下标
     * @param {Object} name   每个bean中的属性的名称
     */
    function createTD(viewBeans, index, name){
        var td = $("<td></td>");
		/**
		 * 如果td没有值，则样式不会乱
		 */
		td.attr("style","border-collapse:collapse;  empty-cells:show;");
		td.attr("item",name);
		var text = $("<input/>");
        text.attr("name", viewBeans + "[" + index + "]" + "." + name);
        text.attr("type", "text");
		text.attr("style","width:100%;");
        td.append(text);
        if (name == "hh") {
			td.attr("style", "width:30px; text-align:center; background:#E2E2E2;");
			text.attr("readonly", "true");
            text.val(dd);
        }else if(name=="hsdj"){//如果该项为'含税单价'
			td.attr("style","border-collapse:collapse;  empty-cells:show;");
			td.attr("readonly", "true");
		}else if (name == "hsje") {//如果该项为'含税金额'
			td.attr("style","border-collapse:collapse;  empty-cells:show;");
			td.attr("readonly", "true");
		}else if(name=="zke"){//如果该项为'折扣额'
			td.attr("style","border-collapse:collapse;  empty-cells:show;");
			td.attr("readonly", "true");
		}else if(name=="se"){//如果该项为'税额'
			td.attr("style","border-collapse:collapse;  empty-cells:show;");
			td.attr("readonly", "true");
		}
        return td;
    }
});
