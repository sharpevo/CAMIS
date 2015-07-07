<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html> 
	<head>
		<title><bean:message bundle="labels" key="requirement.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		 <html:base/>
	</head>
<body>
	<html:errors property="submitagain"/>
	<table border="0">
		<tr>
			<th align="right"><bean:message bundle="labels" key="subject.name"/></th>
			<td align="left"><bean:write name="subName"/></td>
		</tr>
	</table>
	<table border="1" rules="none">
		<html:form action="/requirementInfo?action=saveOrUpdate">
			<tr>
				<th align="left"  bgcolor="#6699cc">1.<bean:message bundle="labels" key="requirement.content"/></th>
			</tr><tr>
				<td><html:errors property="requirement.content"/></td>
			</tr><tr>
				<td align="left" ><html:textarea property="requirement.content" rows="20" cols="60" /></td>
			</tr><tr>
				<th align="left"  bgcolor="#6699cc">2.<bean:message bundle="labels" key="requirement.information"/></th>
			</tr><tr>
				<td><html:errors property="requirement.information"/></td>
			</tr><tr>
				<td align="left"><html:textarea property="requirement.information" rows="15" cols="60"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">3.<bean:message bundle="labels" key="requirement.specificationNcharts"/></th>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">&nbsp;&nbsp;&nbsp;&nbsp;a.<bean:message bundle="labels" key="requirement.specification"/></th>
			</tr><tr>
				<td><html:errors property="requirement.specification"/></td>			
			</tr><tr>
				<td align="left"><html:textarea property="requirement.specification" rows="5" cols="60"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">&nbsp;&nbsp;&nbsp;&nbsp;b.<bean:message bundle="labels" key="requirement.charts"/></th>
			</tr><tr>
				<td><html:errors property="requirement.charts"/></td>				
			</tr><tr>
				<td align="left"><html:textarea property="requirement.charts" rows="5" cols="60"/></td>
			</tr><tr>
				<th align="left" bgcolor="#6699cc">4.<bean:message bundle="labels" key="requirement.schedule"/></th>
			</tr><tr>
				<td><html:errors property="requirement.schedule"/></td>					
			</tr><tr>
				<td align="left"><html:textarea property="requirement.schedule" rows="10" cols="60"/></td>
			</tr><tr>	
				<th align="left" bgcolor="#6699cc">5.<bean:message bundle="labels" key="requirement.reference"/></th>
			</tr><tr>
				<td><html:errors property="requirement.reference"/></td>					
			</tr><tr>
				<td align="left"><html:textarea property="requirement.reference" rows="10" cols="60"/></td>
			</tr>
		</table>
		<table border="0">
			<tr>
			<td align="left">
				<html:submit>
					<bean:message bundle="labels" key="button.submit"/></html:submit>
				<html:reset>
					<bean:message bundle="labels" key="button.reset"/></html:reset>
				<html:cancel>
					<bean:message bundle="labels" key="button.cancel"/></html:cancel>				
				<logic:equal name="ReqIsValid" value="true">
					<BR><BR><html:link action="/deleteRequirement?action=delete" paramId="subId" paramName="subId"><bean:message bundle="labels" key="teacher.subNreq.deleteReq"/></html:link>
				</logic:equal></td>
			</tr>
		</html:form>
	</table>
</body>
</html>
