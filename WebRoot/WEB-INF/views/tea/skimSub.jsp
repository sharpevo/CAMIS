<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
	<head>
		<title><bean:message bundle="labels" key="subject.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
	</head>
	<body>
		<table border ="1" rules="all">
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.name"/></th>
				<td align="left"><bean:write name="subjectInfo" property="subject"/></td>
			</tr>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.source"/></th>
				<td align="left"><bean:write name="subjectInfo" property="sourceName"/></td>
			</tr>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.property"/></th>
				<td align="left"><bean:write name="subjectInfo" property="propertyName"/></td>
			</tr>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.field"/></th>
				<td align="left"><bean:write name="subjectInfo" property="fieldName"/></td>
			</tr>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.type"/></th>
				<td align="left"><bean:write name="subjectInfo" property="typeName"/></td>
			</tr>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.difficulty"/></th>
				<td align="left"><bean:write name="subjectInfo" property="difficulty"/></td>
			</tr>
			<logic:present name="subjectInfo" property="introduction">
				<tr>
					<th align="right"><bean:message bundle="labels" key="subject.introduction"/></th>
					<td align="left"><bean:write name="subjectInfo" property="introduction"/></td>
				</tr>
			</logic:present>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.excellentTag"/></th>
				<td align="left"><bean:write name="subjectInfo" property="excellentTag"/></td>
			</tr>

	</table>
	</body>
</html>