<%@ page pageEncoding = "GB18030"%>
<script language="JavaScript1.2" type="text/javascript">

//  Place this in the 'head' section of your page.  

function delayURL(url) {
	var delay = document.getElementById("time").innerHTML;
	//最后的innerHTML不能丢，否则delay为一个对象
    if(delay > 0) {
		delay--;
		document.getElementById("time").innerHTML = delay;
	}else {
		window.top.location.href = url;
	}
	setTimeout("delayURL('" + url + "')", 1000);  
	//每隔time毫秒跳一次
}



</script>

<!-- Place this in the 'body' section -->
操作成功,页面将在<span id="time">5</span>秒钟后自动跳转到首页.如果不跳转,请点击链接.
<a href="article.jsp">链接</a>
<script type="text/javascript">
	delayURL("articleFlat.jsp");
</script>