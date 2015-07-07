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
			<th align="right"><bean:message bundle="labels" key="teacher.info.sex"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="teacherSex"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.major"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="majorName"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.post"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="post"/></td>
		</tr><tr>
		<html:form action="/editTeaProperty?action=updateProperty">
				<th align="right"><bean:message bundle="labels" key="subject.field"/></th>
				<td align="left"><html:select property="fieldName" >	
					<html:optionsCollection name="fieldOption"/>
			   	</html:select><html:errors property="fieldName" /></td>
			</tr><tr>	
				<th align="right"><bean:message bundle="labels" key="teacher.info.phone"/></th>
				<td align="left"><html:text property="teacherPhone" /><html:errors property="teacherPhone"/></td>
			</tr><tr>
				<th align="right">E-mail: </th>
				<td align="left"><html:text property="teacherEmail" size="30"/><html:errors property="teacherEmail"/></td>
			</tr><tr>
		<td align="right">
			<html:submit>
				<bean:message bundle="labels" key="button.submit"/></html:submit></td>
		<td align="left">
			<html:reset>
				<bean:message bundle="labels" key="button.reset"/></html:reset>
			<html:cancel>
				<bean:message bundle="labels" key="button.cancel"/></html:cancel>
		</td>
		</html:form>
		</tr>
</table>  
</body>
</html>
