<%@ page pageEncoding="GB18030"%>
<%@ include file = "_SessionCheck.jsp" %>
<%@ page import="java.util.*,com.lk.bbs.*,java.sql.*"%>
<!-- ��������չ��,��Ҫ�ݹ��㷨tree -->
<%!
	private void delete(int id, Connection conn, boolean isLeaf) {
		/*�ø�����id����ѯ,�õ���Ľ����article���г�ʼ��.�ж�isLeaf�Ƿ�Ϊ��,Ϊ�ٵĻ�����������id���еݹ�*/
		Statement stmt = DB.creatStatement(conn);
		String sql = "select * from article where pid =" + id;
		ResultSet rs = DB.getResult(stmt, sql);
		if(!isLeaf) {
			try {
				while (rs.next()) {
					delete(rs.getInt("id"), conn, rs.getInt("isleaf") ==0);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		DB.executUpdate(stmt, "delete from article where id = " + id);
	}
	
%>
	
<%

	String idStr = request.getParameter("id");
	String pidStr = request.getParameter("pid");
	String isLeafStr = request.getParameter("isLeaf");
	String url = request.getParameter("url");
	int id = 0;
	int pid = 0;
	boolean isLeaf = true;
	ResultSet rsCount = null;
	Connection conn = DB.getConnection();
	Statement stmt = DB.creatStatement(conn);
	boolean autoCommit = true;
	if(idStr != null && isLeafStr !=null && pidStr != null && !idStr.trim().equals("") && !pidStr.trim().equals("")) {
		try{
			id = Integer.parseInt(idStr);
			pid = Integer.parseInt(pidStr);
			isLeaf = Boolean.parseBoolean(isLeafStr);
		} catch(NumberFormatException e) {
			out.println("���ִ���(���ָ�ʽ)");
			
		}
	}else {
		out.println("���ִ���(��ָ��)");
		out.println("<BR>" + idStr + "<BR>" + pidStr + "<BR>"+ isLeafStr);
		return;
	}
	try{
		autoCommit = conn.getAutoCommit();
		conn.setAutoCommit(false);
		delete(id, conn, isLeaf);
		rsCount = DB.getResult(stmt, "select count(*) from article where pid = " + pid);
		rsCount.next();
		int count = rsCount.getInt(1);
		if(count <= 0) {
			stmt.executeUpdate("update article set isleaf = 0 where id =" + pid);
			System.out.println("update article set isleaf = 0 where id =" + pid);
		}
		conn.commit();
	} finally{
		conn.setAutoCommit(autoCommit);
		DB.close(rsCount);
		DB.close(stmt);
		DB.close(conn);
	}
	response.sendRedirect(url);
// 	out.println(url);
%>
