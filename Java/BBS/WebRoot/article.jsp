<%@ page pageEncoding="GB18030"%>
<%@ page import="java.util.*,com.lk.bbs.*,java.sql.*"%>
<!-- 进行树形展现,需要递归算法tree -->
<%!private void tree(List<Article> articles, int id, Connection conn, int grade) {
		/*用父贴的id来查询,得到后的结果对article进行初始化.判断isLeaf是否为真,为假的话则用子贴的id进行递归*/
		String sql = "select * from article where pid =" + id;
		Statement stmt = DB.creatStatement(conn);
		ResultSet rs = DB.getResult(stmt, sql);
		try {
			while (rs.next()) {
				Article a = new Article();
				a.initFromRs(rs);
				a.setGrade(grade);
				articles.add(a);
				if (!a.isLeaf()) {
					tree(articles, a.getId(), conn, grade + 1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
		}

	}%>

<%
//回帖有顺寻 所以用List,获得Connection对象 .
	List<Article> articles = new ArrayList<Article>();
	Connection conn = DB.getConnection();
	tree(articles, 0, conn, 0);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title>Java|Java世界_中文论坛|ChinaJavaWorld技术论坛 : Java语言*初级版</title>
<meta http-equiv="content-type" content="text/html; charset=GBK">
<link rel="stylesheet" type="text/css" href="images/style.css"
	title="Integrated Styles">
<script language="JavaScript" type="text/javascript"
	src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS"
	href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript"
	src="images/common.js"></script>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tbody>

			<tr>
				<td width="140"><a
					href="http://bbs.chinajavaworld.com/index.jspa"><img
						src="images/header-left.gif"
						alt="Java|Java世界_中文论坛|ChinaJavaWorld技术论坛" border="0">
				</a>
				</td>
				<td><img src="images/header-stretch.gif" alt="" border="0"
					height="57" width="100%">
				</td>
				<td width="1%"><img src="images/header-right.gif" alt=""
					border="0">
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<div id="jive-forumpage">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="98%"><p class="jive-breadcrumbs">论坛: Java语言*初级版
							(模仿)</p>
						<p class="jive-description">探讨Java语言基础知识,基本语法等 大家一起交流
							共同提高！谢绝任何形式的广告</p></td>
				</tr>
			</tbody>
		</table>
		<div class="jive-buttons">
			<table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<td class="jive-icon"><a
							href="http://bbs.chinajavaworld.com/post%21default.jspa?forumID=20"><img
								src="images/post-16x16.gif" alt="发表新主题" border="0" height="16"
								width="16">
						</a>
						</td>
						<td class="jive-icon-label"><a id="jive-post-thread"
							href="post.jsp">发表新主题</a>
							<a
							href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;isBest=1"></a>
						</td>
					</tr>

				</tbody>
			</table>
		</div>
		<br>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td><span class="nobreak"> 页: 1,316 - <span
							class="jive-paginator"> [ <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0&amp;isBest=0">上一页</a>
								| <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=0&amp;isBest=0"
								class="">1</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=25&amp;isBest=0"
								class="jive-current">2</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=50&amp;isBest=0"
								class="">3</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=75&amp;isBest=0"
								class="">4</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=100&amp;isBest=0"
								class="">5</a> <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=125&amp;isBest=0"
								class="">6</a> | <a
								href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;start=50&amp;isBest=0">下一页</a>
								] </span> </span></td>
				</tr>
			</tbody>
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tbody>
				<tr valign="top">
					<td width="99%"><div class="jive-thread-list">
							<div class="jive-table">
								<table summary="List of threads" cellpadding="0" cellspacing="0"
									width="100%">
									<thead>
										<tr>
											<th class="jive-first" colspan="3">主题</th>
											<th class="jive-author"><nobr> 作者 &nbsp; </nobr></th>
											<th class="jive-view-count"><nobr> 浏览 &nbsp; </nobr></th>
											<th class="jive-msg-count" nowrap="nowrap">回复</th>
											<th class="jive-last" nowrap="nowrap">最新帖子</th>
										</tr>
									</thead>
									<%
									//用Iterator对List进行遍历,并在帖子题目之前加入----用来展现层次结构.
										Iterator<Article> it = articles.iterator();
										while (it.hasNext()) {
											Article a = it.next();
											String preStr = "";
											for (int i = 0; i < a.getGrade(); i++) {
												preStr += "----";
											}
									%>
									<tbody>
										<tr class="jive-even">
											<td class="jive-first" nowrap="nowrap" width="1%"><div
													class="jive-bullet">
													<img src="images/read-16x16.gif" alt="已读" border="0"
														height="16" width="16">
													<!-- div-->
												</div>
											</td>
											<td nowrap="nowrap" width="1%"><a href="javascript:if(confirm('确定要删除吗?')) location='delete.jsp?id=<%=a.getId()%>&isLeaf=<%=a.isLeaf()%>&pid=<%=a.getPid()%>'">删除</a></td>
											<!-- 用get方法传递id,用来向后面显示帖子内容针对该id 进行查询,获得相应的内容 -->
											<td class="jive-thread-name" width="95%"><a id="jive-thread-1" href="article_detail2.jsp?id=<%=a.getId()%>"><%=preStr + a.getTitle() %></a></td>
											<td class="jive-author" nowrap="nowrap" width="1%"><span
												class=""> <a
													href="http://bbs.chinajavaworld.com/profile.jspa?userID=226030">fei870407</a>
											</span>
											</td>
											<td class="jive-view-count" width="1%">104</td>
											<td class="jive-msg-count" width="1%">5</td>
											<td class="jive-last" nowrap="nowrap" width="1%"><div
													class="jive-last-post">
													2007-9-13 上午9:31 <br> by: <a
														href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182"
														title="jingjiangjun" style="">jingjiangjun &#187;</a>
												</div>
											</td>
										</tr>
										<%-- 
										<tr class="jive-odd">
											<td class="jive-first" nowrap="nowrap" width="1%"><div
													class="jive-bullet">
													<img src="images/read-16x16.gif" alt="已读" border="0"
														height="16" width="16">
													<!-- div-->
												</div>
											</td>
											<td nowrap="nowrap" width="1%">&nbsp; &nbsp;</td>
											<td class="jive-thread-name" width="95%"><a
												id="jive-thread-2"
												href="http://bbs.chinajavaworld.com/thread.jspa?threadID=744234&amp;tstart=25">请
													兄弟们指点下那里 错误，，，</a>
											</td>
											<td class="jive-author" nowrap="nowrap" width="1%"><span
												class=""> <a
													href="http://bbs.chinajavaworld.com/profile.jspa?userID=226028">403783154</a>
											</span>
											</td>
											<td class="jive-view-count" width="1%">52</td>
											<td class="jive-msg-count" width="1%">2</td>
											<td class="jive-last" nowrap="nowrap" width="1%"><div
													class="jive-last-post">
													2007-9-13 上午8:40 <br> by: <a
														href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780172#780172"
														title="downing114" style="">downing114 &#187;</a>
												</div>
											</td>
										</tr>
										--%>
									</tbody>
									<%
										}
										//Iterator对List的遍历结束
									%>
								</table>
							</div>
						</div>
						<div class="jive-legend"></div>
					</td>
				</tr>
			</tbody>
		</table>
		<br> <br>
	</div>
</body>
</html>
