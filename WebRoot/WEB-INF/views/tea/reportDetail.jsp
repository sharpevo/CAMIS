<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
<body>
	<head>
		<title><bean:message bundle="labels" key="teacher.censor.title"/></title>
		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
	</head>
	<body>
	<table border="1" rules="all" >
		<tr>
			<th align="right">
				<bean:message bundle="labels" key="student.id"/></th>
			<td align="left">
				<bean:write name="reportDetail" property="studentId"/></td>
		</tr><tr>
			<th align="right">
				<bean:message bundle="labels" key="student.name"/></th>
			<td align="left">
				<bean:write name="studentName"/></td>
		</tr><tr>
			<th align="right">
				<bean:message bundle="labels" key="teacher.censor.title"/></th>
			<td align="left">
				<bean:write name="reportDetail" property="content"/></td>
		</tr>
		</table>
		<table>
		<tr>
			<td align="center">
				<html:link action="/censorReport"><bean:message bundle="labels" key="teacher.censor.order.agree"/></html:link>
				<html:link action="/writeMail" paramId="studentId" paramName="reportDetail" paramProperty="studentId">
				<bean:message bundle="labels" key="teacher.censor.order.reject"/></html:link></td></tr>
	</table>
</body>
</html>



