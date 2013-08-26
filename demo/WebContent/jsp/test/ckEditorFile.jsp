<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- <base href="${sessionScope.path}"> --%>
<title>Test CKEditor</title>
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
</head>

<body>

	<form id="form1" name="form1" method="post" action="display.jsp">
		<table width="650" height="400" border="0" align="center">
			<tr>
				<td valign="top">内容:</td>
				<td><textarea cols="80" id="content" name="content"></textarea> 
				<script type="text/javascript">
					CKEDITOR.replace('content',
						{
							filebrowserUploadUrl : '/SimpleUploader?Type=File',
							filebrowserImageUploadUrl : '/SimpleUploader?Type=Image',
							filebrowserFlashUploadUrl : '/SimpleUploader?Type=Flash'
						});
				</script></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="提交" /> <input
					type="reset" name="Reset" value="重置" /></td>
			</tr>
		</table>
	</form>


	<hr>


</body>
</html>




