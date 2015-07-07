<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>

	<head>
		<title><bean:message bundle="labels" key="teacher.info.title"/></title>
 		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
  		<html:base/>
	</head>
<body>
	<table border="1" rules="all" >
		<tr>
			<th align="right"><bean:message bundle="labels" key="teacher.id"/></th>
			<td align="left"><bean:write name="teacherInfo" property="teacherId"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.name"/></th>
			<td align="left"><bean:write name="teacherInfo" property="teacherName"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.sex"/></th>
			<td align="left"><bean:write name="teacherInfo" property="teacherSex"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.major"/></th>
			<td align="left"><bean:write name="teacherInfo" property="majorName"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.post"/></th>
			<td align="left"><bean:write name="teacherInfo" property="post"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="subject.field"/></th>
			<td align="left"><bean:write name="teacherInfo" property="fieldName"/></td>
		</tr><tr>
			<th align="right"><bean:message bundle="labels" key="teacher.info.phone"/></th>
			<td align="left"><bean:write name="teacherInfo" property="teacherPhone"/></td>
		</tr><tr>
			<th align="right">E-mail</th>
			<td align="left"><bean:write name="teacherInfo" property="teacherEmail"/></td>
		</tr>
	</table>
</body>
</html>






