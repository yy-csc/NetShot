<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="refresh" content="0;url=initialServerPath.action">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script>
	window.location.href = 'initialServerPath.action';
</script>
</head>

<body>
	This is my JSP page.
	<br>
	<a href="queryStaff">add staff</a>
	<br>For Joy
	<a href="viewAllMemInfo">viewAllMemInfo</a>
	<hr>
	<a href="jsp/staff/addProjInfo.jsp">add project</a>
	<a href="jsp/staff/queryProject.jsp">query project</a>
</body>
</html>
