<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>

	<head>
		<title><bean:message bundle="labels" key="requirement.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		 <html:base/>
	</head>
	<body>
		<table border = "0" >
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.name"/></th>
				<td align="left"><bean:write name="subName"/></td>
			</tr>
		</table>
		<table border = "1" rules="none">	
			<tr>
				<th align="left" bgcolor="#6699cc">1.<bean:message bundle="labels" key="requirement.content"/></th>
			</tr><tr>
				<td align="left"><bean:write name="requirementInfo" property="content"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">2.<bean:message bundle="labels" key="requirement.information"/></th>
			</tr><tr>
				<td align="left"><bean:write name="requirementInfo" property="information"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">3.<bean:message bundle="labels" key="requirement.specificationNcharts"/></th>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">&nbsp;&nbsp;&nbsp;&nbsp;a.<bean:message bundle="labels" key="requirement.specification"/></th>
			</tr><tr>
				<td align="left" ><bean:write name="requirementInfo" property="specification"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">&nbsp;&nbsp;&nbsp;&nbsp;b.<bean:message bundle="labels" key="requirement.charts"/></th>
			</tr><tr>
				<td align="left"><bean:write name="requirementInfo" property="charts"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">4.<bean:message bundle="labels" key="requirement.schedule"/></th>
			</tr><tr>
				<td align="left"><bean:write name="requirementInfo" property="schedule"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">5.<bean:message bundle="labels" key="requirement.reference"/> </th>
			</tr><tr>
				<td align="left"><bean:write name="requirementInfo" property="reference"/></td>
			</tr>
		</table>

	</body>
</html>