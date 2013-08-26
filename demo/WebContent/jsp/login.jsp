<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<c:set var="requestVar" value='${pageContext.request}' scope="session" />
<html>
<head>
<base
	href="${requestVar.scheme}://${requestVar.serverName}:${requestVar.serverPort}${requestVar.contextPath}/" />
<title>Login to OSM</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="CSC,OSM,Login">
<meta http-equiv="description"
	content="You can login OSM through this page.">

<link rel="stylesheet" type="text/css" href="css/ui-login.css" />
<script type="text/javascript">
	function checkLoginInfo(){
		var shortID,password;
		shortID=document.getElementById('txtShortID').value;
		password=document.getElementById('txtPassword').value;
		if(shortID==null || shortID.length==0){
			alert('Please confirm your short ID!');
			return false;
		}
		else if(shortID==null || shortID.length==0){
			alert('Please confirm your password!');
			return false;
		}
		else
			return true;
	}
	function goRegister(){
		
		
	}
</script>
</head>
<body>
	<center>
		<div style="width: 100%;">
			<div
				style="width: 5px; height: 33; float: left; background-color: #ffffff;">
			</div>
			<div style="width: auto; background-color: #919195; height: 33px;">
				<a class="tNav" href="coming.html">Help</a> &nbsp;
			</div>
		</div>
		<div id="content">
			<table>
				<tr>
					<td width="10%" />
					<td>
						<table width="80%" align="center">
							<tr>
								<td align="center"><span
									style="font-size: 15px; font-weight: bold;">Please Log
										In</span>
								</td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td height="5" align="center"><s:if
										test="hasActionMessages()">
										<div class="message">
											<s:actionmessage />
										</div>
									</s:if>
								</td>
							</tr>
							<tr>
								<td height="5"></td>
							</tr>
							<tr>
								<td align="center"><s:form action="logon" method="post"
										onsubmit="return checkLoginInfo();">
										<table border="1" bordercolor="#666666" bgcolor="#ffffff"
											rules="none" frame="box" width="280" cellpadding="10"
											cellspacing="0">
											<tr>
												<td>
													<table border="0" cellpadding="1" cellspacing="2">
														<tr>
															<td>用户名：</td>
															<td valign="top" colspan="2"><s:textfield
																	name="users.username" id="txtShortID"></s:textfield>
														</tr>
														<tr>
															<td width="60%">密码：</td>
															<td valign="top" colspan="2"><s:textfield
																	name="users.password" id="txtPassword"></s:textfield>
														</tr>
														<tr>
															<td></td>
															<td align="center" valign="bottom"><s:submit
																	value="登陆" title="Login System"></s:submit></td>
															<td align="center" valign="middle"><a href="./jsp/register.jsp" title="注册" >注册</a></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</s:form></td>
							</tr>
							<tr>
								<td align="center" valign="bottom"><a href="forgotPwd"
									style="font-size: 12px; color: #000000; text-decoration: underline;">Forgot
										My Password</a></td>
							</tr>

						</table>
					</td>
					<td width="10%" />
				</tr>

			</table>
		</div>
	</center>
</body>
</html>