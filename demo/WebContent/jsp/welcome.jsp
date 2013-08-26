<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${sessionScope.path}">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/navigation_effect.css" />
<script type="text/javascript" src="js/navigation_effect_jquery.js"></script>
<script type="text/javascript" src="js/navigation_sliding_effect.js"></script>
<link rel="stylesheet" type="text/css" href="css/ui-main-frame.css" />

</head>
<body>
	<div id="main-container">
		<div id="banner">
			<jsp:include page="header.jsp" />
		</div>
		<div id="left">
			<jsp:include page="menu.jsp" />
		</div>
		<div id="content">
			<table height="480" width="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<s:actionmessage cssStyle="color:red;" />
				</tr>
				<tr>
					<td width="80%">
						<p align="center">
							<font face="arial" size="4"> <br />Welcome to the
								Shopping Home Page!<br /> </font>
						</p></td>
				</tr>
			</table>
		</div>
	</div>
	<div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>
