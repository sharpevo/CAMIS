<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
	<head>
		<title><bean:message bundle="labels" key="subject.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		 <html:base/>
	</head>
	<body>
		<table border ="1" rules="all" >
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
			<logic:notEmpty name="subjectInfo" property="introduction">
				<tr>
					<th align="right"><bean:message bundle="labels" key="subject.introduction"/></th>
					<td align="left"><bean:write name="subjectInfo" property="introduction"/></td>
				</tr>
			</logic:notEmpty>
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.excellentTag"/></th>
				<td align="left"><bean:write name="subjectInfo" property="excellentTag"/></td>
			</tr><tr>
				<th align="right" width="100">
					<logic:present name="ReqIsValid">
						<bean:message bundle="labels" key="requirement.isValid"/>
					</logic:present>
					<logic:notPresent name="ReqIsValid">
						<bean:message bundle="labels" key="requirement.isNotValid"/>
					</logic:notPresent></th>
				<td align="left">
					<html:link action="/reqPre"	paramId="subId" paramName="subjectInfo"	paramProperty="subjectId"><bean:message bundle="labels" key="requirement.doItNow"/></html:link></td>
			</tr>
	</table>
	</body>
</html>