package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>无标题文档</title>\r\n");
      out.write("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<script language=\"JavaScript\" src=\"js/jquery.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\t\r\n");
      out.write("\t//导航切换\r\n");
      out.write("\t$(\".menuson .header\").click(function(){\r\n");
      out.write("\t\tvar $parent = $(this).parent();\r\n");
      out.write("\t\t$(\".menuson>li.active\").not($parent).removeClass(\"active open\").find('.sub-menus').hide();\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$parent.addClass(\"active\");\r\n");
      out.write("\t\tif(!!$(this).next('.sub-menus').size()){\r\n");
      out.write("\t\t\tif($parent.hasClass(\"open\")){\r\n");
      out.write("\t\t\t\t$parent.removeClass(\"open\").find('.sub-menus').hide();\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t$parent.addClass(\"open\").find('.sub-menus').show();\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t// 三级菜单点击\r\n");
      out.write("\t$('.sub-menus li').click(function(e) {\r\n");
      out.write("        $(\".sub-menus li.active\").removeClass(\"active\")\r\n");
      out.write("\t\t$(this).addClass(\"active\");\r\n");
      out.write("    });\r\n");
      out.write("\t\r\n");
      out.write("\t$('.title').click(function(){\r\n");
      out.write("\t\tvar $ul = $(this).next('ul');\r\n");
      out.write("\t\t$('dd').find('.menuson').slideUp();\r\n");
      out.write("\t\tif($ul.is(':visible')){\r\n");
      out.write("\t\t\t$(this).next('.menuson').slideUp();\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$(this).next('.menuson').slideDown();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("})\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body style=\"background:#fff3e1;\">\r\n");
      out.write("\t<div class=\"lefttop\"><span></span>通讯录</div>\r\n");
      out.write("    \r\n");
      out.write("    <dl class=\"leftmenu\">\r\n");
      out.write("        \r\n");
      out.write("    <dd>\r\n");
      out.write("    <div class=\"title\">\r\n");
      out.write("    <span><img src=\"images/leftico01.png\" /></span>管理信息\r\n");
      out.write("    </div>\r\n");
      out.write("    \t<ul class=\"menuson\">\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("            <cite></cite>\r\n");
      out.write("            <a href=\"index.html\" target=\"rightFrame\">首页模版</a>\r\n");
      out.write("            <i></i>\r\n");
      out.write("            </div>\r\n");
      out.write("            <ul class=\"sub-menus\">\r\n");
      out.write("            <li><a href=\"javascript:;\">文件管理</a></li>\r\n");
      out.write("            <li><a href=\"javascript:;\">模型信息配置</a></li>\r\n");
      out.write("            <li><a href=\"javascript:;\">基本内容</a></li>\r\n");
      out.write("            <li><a href=\"javascript:;\">自定义</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li>\r\n");
      out.write("            <div class=\"header\">\r\n");
      out.write("            <cite></cite>\r\n");
      out.write("            <a href=\"right.html\" target=\"rightFrame\">通讯录</a>\r\n");
      out.write("            <i></i>\r\n");
      out.write("            </div>                \r\n");
      out.write("            <ul class=\"sub-menus\">\r\n");
      out.write("            <li><a href=\"org!list.action\" target=\"rightFrame\">机构管理</a></li>\r\n");
      out.write("            <li><a href=\"org!add.action\" target=\"rightFrame\">人员管理</a></li>\r\n");
      out.write("            <li><a href=\"org\" target=\"rightFrame\">我的数据列表</a></li>\r\n");
      out.write("            <li><a href=\"javascript:;\" target=\"rightFrame\">自定义</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        \r\n");
      out.write("        <li class=\"active\"><cite></cite><a href=\"right.html\" target=\"rightFrame\">数据列表</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"imgtable.html\" target=\"rightFrame\">图片数据表</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"form.html\" target=\"rightFrame\">添加编辑</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"imglist.html\" target=\"rightFrame\">图片列表</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"imglist1.html\" target=\"rightFrame\">自定义</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"tools.html\" target=\"rightFrame\">常用工具</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"filelist.html\" target=\"rightFrame\">信息管理</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"tab.html\" target=\"rightFrame\">Tab页</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"error.html\" target=\"rightFrame\">404页面</a><i></i></li>\r\n");
      out.write("        </ul>    \r\n");
      out.write("    </dd>\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("    <dd>\r\n");
      out.write("    <div class=\"title\">\r\n");
      out.write("    <span><img src=\"images/leftico02.png\" /></span>其他设置\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"menuson\">\r\n");
      out.write("        <li><cite></cite><a href=\"flow.html\" target=\"rightFrame\">流程图</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"project.html\" target=\"rightFrame\">项目申报</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"search.html\" target=\"rightFrame\">档案列表显示</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"tech.html\" target=\"rightFrame\">技术支持</a><i></i></li>\r\n");
      out.write("        </ul>     \r\n");
      out.write("    </dd> \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <dd><div class=\"title\"><span><img src=\"images/leftico03.png\" /></span>编辑器</div>\r\n");
      out.write("    <ul class=\"menuson\">\r\n");
      out.write("        <li><cite></cite><a href=\"#\">自定义</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"#\">常用资料</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"#\">信息列表</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"#\">其他</a><i></i></li>\r\n");
      out.write("    </ul>    \r\n");
      out.write("    </dd>  \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <dd><div class=\"title\"><span><img src=\"images/leftico04.png\" /></span>日期管理</div>\r\n");
      out.write("    <ul class=\"menuson\">\r\n");
      out.write("        <li><cite></cite><a href=\"#\">自定义</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"#\">常用资料</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"#\">信息列表</a><i></i></li>\r\n");
      out.write("        <li><cite></cite><a href=\"#\">其他</a><i></i></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    \r\n");
      out.write("    </dd>   \r\n");
      out.write("    \r\n");
      out.write("    </dl>\r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
