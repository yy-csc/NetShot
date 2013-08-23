<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
A.hNav {
	FONT-WEIGHT: bold;
	COLOR: #970100;
	FONT-FAMILY: verdana, arial;
	FONT-SIZE: 12px;
}

A.hNav:link,A.hNav:visited {
	TEXT-DECORATION: none
}

A.hNav:hover {
	TEXT-DECORATION: underline
}

.user-welcome {
	font-family: arial;
	font-size: 14px;
	font-weight: bold;
}

.user-welcome a:link,.user-welcome a:visited {
	color: #333;
	text-decoration: none
}

.user-welcome a:hover,.user-welcome a:active {
	color: #000;
	text-decoration: underline
}
</style>
<table width="100%">
	<tr>
		<td align="left">
			<font color="#ad315a">Shopping System</font>
		</td>
		<td align="right" class="user-welcome">Welcome, <a
			href="jsp/userinfo.jsp">${userName}</a></td>
		<td align="right" width="60px"><a class="hNav"
			href="jsp/welcome.jsp">home</a>
		</td>
		<td align="right" width="60px"><a class="hNav" href="logout">logout</a>
		</td>
		<td width="10%" />
	</tr>
</table>
<br>

