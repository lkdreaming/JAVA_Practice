<%@ page pageEncoding="GB18030"%>
<%@ page import="java.util.*,java.sql.*,com.lk.bbs.*"%>
<%
	request.setCharacterEncoding("GBK");
	String action = request.getParameter("action");
	/*判断是否是通过POST方法提交上来的数据*/
	if (action != null && action.trim().equals("post")) {
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String sql = "insert into article values(null,?,?,?,?,now(),?)";
		Connection conn = DB.getConnection();
		boolean autoCommit = conn.getAutoCommit();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = DB.preparedStatment(conn, sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setInt(1, 0);
		pstmt.setInt(2, 0);
		pstmt.setString(3, title);
		pstmt.setString(4, cont);
		pstmt.setInt(5, 0);
		pstmt.executeUpdate();
		// 获得一个Statement对象,准备执行更新的SQL语句
		Statement stmt = DB.creatStatement(conn);
		//从刚刚的PreparedStatement 所执行的 插入操作中获得GeneratedKeys.放到ResultSet对象中.
		ResultSet rsKey = pstmt.getGeneratedKeys();
		rsKey.next();
		//生命rootId 并将rsKsy中的 第一个问号元素 的值付给 rootId.
		int rootId = rsKey.getInt(1);
		stmt.executeUpdate("update article set rootid = " + rootId + " where id = "	+ rootId);
		conn.commit();
		conn.setAutoCommit(autoCommit);
		DB.close(pstmt);
		DB.close(conn);
		response.sendRedirect("done.jsp");
	}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java世界_中文论坛|ChinaJavaWorld技术论坛 : 发表新主题 ...</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<script language="JavaScript" type="text/javascript"
	src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS"
	href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?threadID=744236">
<!-- 引入CKEditor 固定格式 -->
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	window.onload = function() {
		CKEDITOR.replace('cont');
	};
</script>
<!-- 引入CKEditor 固定格式 结束-->
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>
			<tr>
				<td width="140"><a
					href="http://bbs.chinajavaworld.com/index.jspa"><img
						src="images/header-left.gif"
						alt="Java|Java世界_中文论坛|ChinaJavaWorld技术论坛" border="0"> </a></td>
				<td><img src="images/header-stretch.gif" alt="" border="0"
					height="57" width="100%"></td>
				<td width="1%"><img src="images/header-right.gif" alt=""
					border="0"></td>
			</tr>
		</tbody>
	</table>
	<br>
	<div id="jive-flatpage">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><p class="jive-breadcrumbs">
							<a href="http://bbs.chinajavaworld.com/index.jspa">首页</a> &#187;
							<a
								href="http://bbs.chinajavaworld.com/forumindex.jspa?categoryID=1">ChinaJavaWorld技术论坛|Java世界_中文论坛</a>
							&#187; <a
								href="http://bbs.chinajavaworld.com/category.jspa?categoryID=2">Java
								2 Platform, Standard Edition (J2SE)</a> &#187; <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0">Java语言*初级版</a>
						</p>
						<p class="jive-page-title">发表新主题:</p></td>
					<td width="1%"><div class="jive-accountbox"></div></td>
				</tr>
			</tbody>
		</table>
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a
							href="http://bbs.chinajavaworld.com/post%21reply.jspa?threadID=744236"><img
								src="images/reply-16x16.gif" alt="回复本主题" border="0" height="16"
								width="16"> </a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><div id="jive-message-holder">
							<div class="jive-message-list">
								<div class="jive-table">
									<div class="jive-messagebox">
										<table summary="Message" border="0" cellpadding="0"
											cellspacing="0" width="100%">
											<tbody>
												<tr id="jive-message-780144" class="jive-odd" valign="top">
													<td class="jive-first" width="1%">
														<!-- 个人信息的table -->
														<table border="0" cellpadding="0" cellspacing="0"
															width="150">
															<tbody>
																<tr>
																	<td><table border="0" cellpadding="0"
																			cellspacing="0" width="100%">
																			<tbody>
																				<tr valign="top">
																					<td style="padding: 0px;" width="1%"><nobr>
																							<a
																								href="http://bbs.chinajavaworld.com/profile.jspa?userID=215489"
																								title="诺曼底客">诺曼底客</a>
																						</nobr>
																					</td>
																					<td style="padding: 0px;" width="99%"><img
																						class="jive-status-level-image"
																						src="images/level3.gif" title="世界新手" alt=""
																						border="0"><br>
																					</td>
																				</tr>
																			</tbody>
																		</table> <img class="jive-avatar"
																		src="images/avatar-display.png" alt="" border="0">
																		<br> <br> <span class="jive-description">
																			发表: 34 <br> 点数: 100<br> 注册: 07-5-10 <br>
																			<a href="http://blog.chinajavaworld.com/u/215489"
																			target="_blank"><font color="red">访问我的Blog</font>
																		</a> </span>
																	</td>
																</tr>
															</tbody>
														</table> <!--个人信息table结束-->
													</td>
													<td class="jive-last" width="99%"><table border="0"
															cellpadding="0" cellspacing="0" width="100%">
															<tbody>
																<tr>
																	<form action="post.jsp" method="post">
																		<!-- 利用隐藏域来让页面判断数据是通过post方法提交上去的还是链接过去的 -->
																		<input type="hidden" name="action" value="post">
																		<!-- 利用hidden隐藏域传送pid,用原帖的ID作为要回复的帖子的父ID -->
																		<input type="hidden" name="pid" value="" />
																		<!-- 利用hidden隐藏域传送rootid,后面插入帖子的SQL语句时会用到. -->
																		<input type="hidden" name="rootId" value="" />
																		<td width="100%"
																			style="border-top: 1px solid rgb(204, 204, 204);">标题:
																			<input type="text" name="title"> <BR>
																			内容:<textarea name="cont" cols="100" rows="30"></textarea>
																			<BR> <input name="Submit" type="submit"
																			value="提交"></td>
																	</form>
																</tr>
															</tbody>
														</table></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
							<div class="jive-message-list-footer">
								<table border="0" cellpadding="0" cellspacing="0" width="100%">
									<tbody>
										<tr>
											<td nowrap="nowrap" width="1%"></td>
											<td align="center" width="98%"><table border="0"
													cellpadding="0" cellspacing="0">
													<tbody>
														<tr>
															<td><a
																href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20"><img
																	src="images/arrow-left-16x16.gif" alt="返回到主题列表"
																	border="0" height="16" hspace="6" width="16"> </a>
															</td>
															<td><a
																href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20">返回到主题列表</a>
															</td>
														</tr>
													</tbody>
												</table></td>
											<td nowrap="nowrap" width="1%">&nbsp;</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div></td>
					<td width="1%"></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>
