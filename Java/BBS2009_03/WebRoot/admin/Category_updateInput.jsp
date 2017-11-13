<%@page import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<form action="admin/Category_update" method="post">
<input type="hidden" name="category.id" value="<s:property value= "category.id"/>" />
	<table>
		<tr>
			<td>name:</td>
			<td><input name="category.name" value="<s:property value="category.name"/>"/></td>
		</tr>
		<tr>
			<td>description:</td>
			<td><textarea name="category.description"><s:property value="category.description"/></textarea></td>
		</tr>
		<tr>
			<td><input type=submit value="update"/></td>
		
		</tr>
	</table>
</form>