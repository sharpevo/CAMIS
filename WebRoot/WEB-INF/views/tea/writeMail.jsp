<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html> 
	<head>
		<title><bean:message bundle="labels" key="teacher.censor.title"/></title>
		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
	</head>
	<body>
	<html:errors property="submitagain"/>
	<html:errors property="sendFail"/>
	<table border = "1" rules="rows" >
		<tr>
			<th align="right">
				<bean:message bundle="labels" key="student.name"/></th>
			<td><bean:write name="studentName"/></td>
		</tr><tr>
			<html:form action="/sendMail">
			<th align="right">Email:</th>
			<td><html:text property="email"/></td>
			<td><html:errors property="email"/></td>
		</tr><tr>	
			<th align="center">
				<bean:message bundle="labels" key="teacher.censor.reason"/></th>
			<td><html:textarea property="content" rows="30" cols="50"/></td>
			<td><html:errors property="content"/></td>
		</tr>
		</table>
		<table>
		<tr><td align="left">
				<html:submit>
					<bean:message bundle="labels" key="button.submit"/></html:submit>
			<html:reset>
				<bean:message bundle="labels" key="button.reset"/></html:reset>
			<html:cancel>
				<bean:message bundle="labels" key="button.cancel"/></html:cancel>
		</td></tr></html:form>
	</table>
</body>
</html>
