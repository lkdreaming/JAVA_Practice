(function($) {
	$.oaconfirm = function() {
		$(a).each(function() {
			if($(this).text() == "É¾³ı") {
				$(this).unbind("click");
				$(this).bind("click",function() {
					return window.confirm("ÄúÈ·ÈÏÒªÉ¾³ıÂğ?");
				})
			}
		});
	}
})($);
