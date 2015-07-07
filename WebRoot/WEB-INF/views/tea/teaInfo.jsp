<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>


<html>
<body>
	<head>
		<title><bean:message bundle="labels" key="teacher.info.title"/></title>
		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen" />
  		<html:base/>
	</head>
<body>
	<logic:messagesPresent message="true">
		<br/><html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font><br/>
		</html:messages>
	</logic:messagesPresent>	
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
			<th align="right"><bean:message bundle="labels" key="subject.field"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="fieldName"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.phone"/></th>
			<td align="left"><bean:write name="TEACHERBEAN" property="teacherPhone"/></td>
		</tr><tr>
			<th align="right">E-mail</th>
			<td align="left"><bean:write name="TEACHERBEAN" property="teacherEmail"/></td>
		</tr>
		</table>
		<table border="0" width="100%">
			<tr>
				<td align="right"><html:link action="/modifyTea"><bean:message bundle="labels" key="teacher.info.modifyProperty"/></html:link></td>
				<td align="left"><html:link action="/modifyPSW"><bean:message bundle="labels" key="teacher.info.modifyPassword"/></html:link></td>
			</tr>
		</table>
</body>
</html>



