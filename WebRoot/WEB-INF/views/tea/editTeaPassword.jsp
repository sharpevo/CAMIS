<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
 
<html> 
	<head>
		<title><bean:message bundle="labels" key="teacher.info.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>	
	</head>
	<body>
	<html:errors property="submitagain"/>
	<table border="1" rules="all">
		<tr>
			<th align="right"><bean:message bundle="labels" key="teacher.id"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="teacherId"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.name"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="teacherName"/></td>
		</tr><tr>
		<html:form action="/editTeaPassword?action=updatePassword">
			<th align="right"><bean:message bundle="labels" key="teacher.info.originalPSW"/></th><td><html:password property="teacherPassword" value=""/>
			<html:errors property="wrongPSW"/><html:errors property="teacherPassword"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.newPSW"/></th>
			<td><html:password property="newPSW"  value=""/><html:errors property="newPSW"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.confirmPSW"/></th>
			<td><html:password property="confirmPSW"  value=""/><html:errors property="confirmPSW"/></td>
		</tr><tr>
		<td align="right">
			<html:submit>
				<bean:message bundle="labels" key="button.submit"/></html:submit></td>
		<td align="left">
			<html:reset>
				<bean:message bundle="labels" key="button.reset"/></html:reset>
			<html:cancel>
				<bean:message bundle="labels" key="button.cancel"/></html:cancel>
		</td></tr>
		</html:form>
</table>
	</body>
</html>
