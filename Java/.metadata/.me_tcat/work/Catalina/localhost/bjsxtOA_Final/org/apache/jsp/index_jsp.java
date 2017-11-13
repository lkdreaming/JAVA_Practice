package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=GB18030");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=GB18030\">\r\n");
      out.write("<LINK href=\"style/login.css\" type=text/css rel=stylesheet>\r\n");
      out.write("<title>Web OA系统首页</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<BODY class=PageBody leftMargin=0 topMargin=0 MARGINHEIGHT=\"0\" \r\n");
      out.write("MARGINWIDTH=\"0\">\r\n");
      out.write("<CENTER>\r\n");
      out.write("<form action=\"login.do\" method=\"post\">\r\n");
      out.write("<TABLE height=\"100%\" cellSpacing=0 cellPadding=0 border=0>\r\n");
      out.write("  <TBODY>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD></TD></TR>\r\n");
      out.write("  <TR>\r\n");
      out.write("    <TD>\r\n");
      out.write("      <TABLE cellSpacing=0 cellPadding=0 border=0>\r\n");
      out.write("        <TBODY>\r\n");
      out.write("        <TR class=UpTr height=20>\r\n");
      out.write("          <TD></TD>\r\n");
      out.write("          <TD></TD> \r\n");
      out.write("          <TD class=VersionTitle align=right>版本:1.0\r\n");
      out.write("          </TD></TR>\r\n");
      out.write("        <TR class=UpTr height=65>\r\n");
      out.write("          <TD width=20></TD>\r\n");
      out.write("          <TD colSpan=2><IMG src=\"images/login/logo.gif\" \r\n");
      out.write("            border=0></TD></TR>\r\n");
      out.write("        <TR height=3>\r\n");
      out.write("          <TD background=images/login/logo_under_line.gif \r\n");
      out.write("          colSpan=3></TD></TR>\r\n");
      out.write("        <TR class=DownTr>\r\n");
      out.write("          <TD></TD>\r\n");
      out.write("          <TD>\r\n");
      out.write("            <TABLE height=204 cellSpacing=0 cellPadding=0 border=0>\r\n");
      out.write("              <TBODY>\r\n");
      out.write("              <TR height=50>\r\n");
      out.write("                <TD colSpan=3></TD></TR>\r\n");
      out.write("              <TR height=18>\r\n");
      out.write("                <TD width=290 \r\n");
      out.write("                background=images/login/userLogin.gif \r\n");
      out.write("                colSpan=3></TD></TR>\r\n");
      out.write("              <TR>\r\n");
      out.write("                <TD class=LoginLine width=2></TD>\r\n");
      out.write("                <TD width=286>\r\n");
      out.write("                  <TABLE height=\"100%\" cellSpacing=0 cellPadding=0 width=\"100%\" \r\n");
      out.write("                  border=0>\r\n");
      out.write("                    <TBODY>\r\n");
      out.write("                    <TR height=10>\r\n");
      out.write("                      <TD colSpan=6></TD></TR>\r\n");
      out.write("                    <TR>\r\n");
      out.write("                      <TD class=ItemTitleFont align=right width=80 \r\n");
      out.write("                        height=25>用户名：</TD>\r\n");
      out.write("                      <TD width=100><INPUT class=inputFrm name=username></TD>\r\n");
      out.write("                      <TD align=middle rowSpan=2><input type=\"image\" src=\"images/login/userLogin_button.gif\" \r\n");
      out.write("                        border=0></TD></TR>\r\n");
      out.write("                    <TR>\r\n");
      out.write("                      <TD class=ItemTitleFont align=right height=25>密码：</TD>\r\n");
      out.write("                      <TD><INPUT class=inputFrm type=password \r\n");
      out.write("                    name=password></TD></TR>\r\n");
      out.write("                    \r\n");
      out.write("                    <TR>\r\n");
      out.write("                      <TD></TD>\r\n");
      out.write("                      <TD></TD>\r\n");
      out.write("                      <TD></TD></TR></TBODY></TABLE></TD>\r\n");
      out.write("                <TD class=LoginLine width=2></TD></TR>\r\n");
      out.write("              <TR height=11>\r\n");
      out.write("                <TD width=290 \r\n");
      out.write("                background=images/login/userLogin_down.gif \r\n");
      out.write("                colSpan=3></TD></TR></TBODY></TABLE></TD>\r\n");
      out.write("          <TD width=228><IMG src=\"images/login/logo_bg.gif\" \r\n");
      out.write("            border=0></TD></TR>\r\n");
      out.write("        <TR class=DownTr height=24>\r\n");
      out.write("          <TD></TD>\r\n");
      out.write("          <TD class=VersionTitle vAlign=bottom align=right \r\n");
      out.write("          background=images/login/logo_copyright_bg.gif \r\n");
      out.write("          colSpan=2><A class=close href=\"http://www.bjsxt.com/\" \r\n");
      out.write("            target=_blank>尚学堂 版权所有</A></TD></TR></TBODY></TABLE></TD></TR>\r\n");
      out.write("  <TR height=\"3%\">\r\n");
      out.write("    <TD></TD></TR></TBODY></TABLE></form></CENTER></BODY>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
