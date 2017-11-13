$().ready(function(){
	$("body").data("data",{
		a:'a',
		b:'b'
	});
	var json = $("body").data("data");
	alert(json.a);
	alert(json.b);
});
