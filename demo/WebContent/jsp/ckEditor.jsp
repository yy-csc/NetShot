<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Test CKEditor</title>
<meta http-equiv="description" content="This is my page">
<%-- <base href="${sessionScope.path}"> --%>
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>

</head>

<body>
	<form action="logon">
		用户名：<input type="text" name="name" /><br> 密码：<input
			type="password" name="pwd" /><br> 个人信息:
		<textarea rows="30" cols="50" name="editor01" id="editor01"
			onchange="alertMsg();">请输入.</textarea>
		<script type="text/javascript">
			CKEDITOR.replace('editor01', {
				toolbar : "Basic",
				uiColor : '#14B8C4'
			});
		</script>

		<input type="submit" value="Submit">
	</form>

	<hr>

	上传文件和图片测试
	<br>

	<form id="form1" name="form1" method="post"
		action="/ckeditor/display.jsp">
		<table width="650" height="400" border="0" align="center">
			<tr>
				<td valign="top">内容:</td>
				<td><textarea cols="80" id="content" name="content">  
      </textarea> <script type="text/javascript">
							CKEDITOR.replace('content');
						</script>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="提交" /> <input
					type="reset" name="Reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>


	<hr>


</body>
</html>
