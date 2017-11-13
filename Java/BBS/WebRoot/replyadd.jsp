<%@ page import="java.sql.*,com.lk.bbs.*" pageEncoding="GB18030"%>

<%
	request.setCharacterEncoding("GBK");
%>

<%
			/*	引入CKEditor固定格式*/
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String title = new String(request.getParameter("title").getBytes(
			"GB18030"), "GBK");
	String cont = new String(request.getParameter("cont").getBytes(
			"GB18030"), "GBK");
			/*	引入CKEditor固定格式结束*/
	int pid = 0;
	int rootId = 0;
	try {
		pid = Integer.parseInt(request.getParameter("pid"));
		rootId = Integer.parseInt(request.getParameter("rootId"));
	} catch (NumberFormatException e) {
		out.println("页面不存在");
	}

	String sql = "insert into article values(null,?,?,?,?,now(),?)";
	Connection conn = DB.getConnection();
	boolean autoCommit = conn.getAutoCommit();
	conn.setAutoCommit(false);
	PreparedStatement pstmt = DB.preparedStatment(conn, sql);
	pstmt.setInt(1, pid);
	pstmt.setInt(2, rootId);
	pstmt.setString(3, title);
	pstmt.setString(4, cont);
	pstmt.setInt(5, 0);
	pstmt.executeUpdate();   
	Statement stmt = DB.creatStatement(conn);
	//isleaf=1 意思是有叶子节点:将新回复好的帖子的父贴ID改为 含有叶子节点.
	stmt.executeUpdate("update article set isleaf = 1 where id =" + pid);
	conn.commit();
	conn.setAutoCommit(autoCommit);
	DB.close(pstmt);
	DB.close(stmt);
	DB.close(conn);
	response.sendRedirect("done.jsp");
%>
<!--  
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
回复成功,页面将在<span id="time">5</span>秒钟后自动跳转到首页.如果不跳转,请点击链接.
<a href="article.jsp">链接</a>
<script type="text/javascript">
	delayURL("article.jsp");
</script>
-->