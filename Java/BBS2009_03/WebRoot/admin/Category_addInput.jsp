<%@ page pageEncoding = "UTF-8"%>
<form action="admin/Category_add" method="post">
	<table>
		<tr>
			<td>name:</td>
			<td><input name="category.name"/></td>
		</tr>
		<tr>
			<td>description:</td>
			<td><textarea name="category.description"></textarea></td>
		</tr>
		<tr>
			<td><input type=submit value="submit"/></td>
		
		</tr>
	</table>

</form>