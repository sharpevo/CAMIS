<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
	<head>
		<title><bean:message bundle="labels" key="teacher.commenting.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
	</head>
<body>
<table border="1" rules="rows">
	<tr>
		<th align="left"><bean:message bundle="labels" key="subject.name"/></th>
	</tr><tr>
		<td align="left"><bean:write name="subName"/></td>
	</tr>
	<tr>
		<th align="left"><bean:message bundle="labels" key="subject.introduction"/></th>
	</tr><tr>
		<td align="left"><bean:write name="subjectInfo"/></td>
	</tr></table>
<table border="1" rules="rows"><tr><td>
<html:errors property="submitagain"/>
		<html:form action="/ps">
			<bean:message bundle="labels" key="teacher.commenting.getComment"/>
			A:<html:radio property="grade" value="A"/>
			B:<html:radio property="grade" value="B"/>
			C:<html:radio property="grade" value="C"/>
			<html:errors property="grade"/>
			<html:submit><bean:message bundle="labels" key="button.submit"/></html:submit>
		</html:form>
			</td></tr>
</table>


</body>
</html>
