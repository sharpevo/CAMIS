<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
  <head>
		<title><bean:message bundle="labels" key="teacher.marking.title"/>-<bean:message bundle="labels" key="teacher.marking.role_DB"/></title>
		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
  		<html:base/>
  </head>
<body>
	<logic:messagesPresent name="noRecord" message="false">
		<html:messages id="error" >
			<font color="red"><bean:write name="error"/></font>
		</html:messages>
	</logic:messagesPresent>
	<logic:messagesPresent message="true">
		<html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font>
		</html:messages>
	</logic:messagesPresent><BR><BR>
	<html:errors property="submitagain"/>
	
	<table border="0">
	<tr>
		<td align="right">
	    	<html:form action="/dbGet">
				<bean:message bundle="labels" key="teacher.marking.getStuId"/></td>
		<td align="left"><html:text property = "studentId"/><html:errors property="studentId"/></td>
	</tr><tr>
	<td>&nbsp;</td>
		<td align="left">
				<html:submit><bean:message bundle="labels" key="button.submit"/></html:submit>
			</html:form></td>
	</tr>
</table>
</body>
</html>


