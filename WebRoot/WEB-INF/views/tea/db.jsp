<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>  
	<head>
		<title><bean:message bundle="labels" key="teacher.marking.title"/>-<bean:message bundle="labels" key="teacher.marking.role_DB"/></title>
  		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
  		<html:base/>
	</head>
<body>
	<html:errors property="submitagain"/><br/>
	<logic:messagesPresent message="true">
		<html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font>
		</html:messages>
	</logic:messagesPresent><br/>	
	<table border = "1" rules="groups">
	<tr>
		<th align="right">
			<bean:message bundle="labels" key="student.name"/></th>
		<td align="left">
			<bean:write name="studentInfo" property="studentName"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="student.major"/></th>
		<td align="left">
			<bean:write name="studentInfo" property="majorName"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="student.class"/></th>
		<td align="left">
			<bean:write name="studentInfo" property="studentClass"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="subject.name"/></th>
		<td align="left">
			<bean:write name="subName"/></td>
	</tr><tr>
	<html:form action="/db">
		<th align="right">
			<bean:message bundle="labels" key="teacher.marking.achievement_db"/>[10]</th>
		<td align="left">
			<html:text property="achievement"/><html:errors property="achievement"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="teacher.marking.workLoad"/>[10]</th>
		<td align="left">
			<html:text property="workLoad"/><html:errors property="workLoad"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="teacher.marking.verbalReport"/>[35]</th>
		<td align="left">
			<html:text property="verbalReport"/><html:errors property="verbalReport"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="teacher.marking.reply"/>[35]</th>
		<td align="left">
			<html:text property="reply"/><html:errors property="reply"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="teacher.marking.innovation"/>[10]</th>
		<td align="left">
			<html:text property="innovation"/><html:errors property="innovation"/></td>
	</tr><tr>
		<th align="right">
			<bean:message bundle="labels" key="teacher.marking.comment"/></th>
		<td align="left">
			<html:textarea property="comment"/><html:errors property="comment"/></td>
	</tr><tr>
		<td align="right">
			<html:submit><bean:message bundle="labels" key="button.submit"/></html:submit>
		</td>
		<td align="left">
			<html:reset>
				<bean:message bundle="labels" key="button.reset"/></html:reset>
			<html:cancel>
				<bean:message bundle="labels" key="button.cancel"/></html:cancel>
		</td>
	</tr>
	</html:form>
	</table>
</body>
</html>

