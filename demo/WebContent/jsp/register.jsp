<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="requestVar" value='${pageContext.request}' scope="session" />
<html>
<head>
<title>Register</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="css/ui-login.css" />
<script type="text/javascript">
	function checkRegisterInfo(){
		var shortID,password;
		shortID=document.getElementById('txtShortID').value;
		password=document.getElementById('txtPassword').value;
		password1=document.getElementById('txtPassword1').value;
		if(shortID==null || shortID.length==0){
			alert('请填写用户名!');
			return false;
		}else if(password==null || password.length==0){
			alert('请填写密码!');
			return false;
		}else if(password1==null || password1.length==0){
			alert('请重复密码!');
			return false;
		}else if(password1!=password){
			alert('两次密码输入不一致!');
			return false;
		}else{
			return true;
		}
	}
</script>
</head>
<body>
	<center>
		<div id="content">
			<s:if test="hasActionMessages()">
				<div class="message">
					<s:actionmessage />
				</div>
			</s:if>
			<div>
				<h1>Register Page</h1>
			</div>
			<s:form action="register" method="post"
				onsubmit="return checkRegisterInfo();">
				<table border="1">
					<tr>
						<td>用户民:</td>
						<td colspan="2"><s:textfield name="users.username"
								id="txtShortID"></s:textfield>
					</tr>
					<tr>
						<td>密码:</td>
						<td colspan="2"><s:password name="users.password"
								id="txtPassword"></s:password>
					</tr>
					<tr>
						<td>重复密码:</td>
						<td colspan="2"><input type="password" name="rePwd"
							id="txtPassword1" />
					</tr>
					<tr>
						<td colspan="3" align="center"><s:submit value="提交"
								title="Register"></s:submit>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</center>
</body>
</html>