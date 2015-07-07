<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
 <html> 
	<head>
		<title><bean:message bundle="labels" key="subject.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		 <html:base/>
			<script language="javascript" type="text/javascript">
			function show(object){ 
				if(object.options[object.selectedIndex].value=='A'){
					document.getElementById("introduction").style.display=""; 
					document.getElementById("introductionTip").style.display=""; 
				}else{
					document.getElementById("introduction").style.display="none"; 
					document.getElementById("introductionTip").style.display="none"; 
				}
			}
			</script> 
	</head>
	<body>
	<html:errors property="submitagain"/>
	<html:errors property="introduction"/>
	<table border="1" rules="rows">
		<html:form action="/subjectInfo?action=saveOrUpdate">
			<tr>
				<th align="right"><bean:message bundle="labels" key="subject.name"/></th>
				<td align="left"><html:text property="subject"/><html:errors property="subject"/></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.source"/></th>
				<td align="left"><html:select property="sourceName" >
					<html:optionsCollection name="sourceOption"/>
		   		</html:select><html:errors property="source" /></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.property"/></th>
				<td align="left"><html:select property="propertyName" >
					<html:optionsCollection name="propertyOption"/>
					</html:select><html:errors property="propertyName" /></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.field"/></th>
				<td align="left"><html:select property="fieldName" >
					<html:optionsCollection name="fieldOption"/>
					</html:select><html:errors property="fieldName" /></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.type"/></th>
				<td align="left"><html:select property="typeName" >
				    <html:optionsCollection name="typeOption"/>
				</html:select><html:errors property="typeName" /></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.difficulty"/></th>
				<td align="left"><html:select property="difficulty" onchange="show(this);">
					<html:option key="" value=">---------&lt;"/>
				    <html:option key="a" value="A"/>
					<html:option key="b" value="B"/>
					<html:option key="c" value="C"/>
				</html:select><html:errors property="difficulty" /></td>
			</tr><tr id="introductionTip" style="display:none;">
				<td colspan="2" align="center"><font color="blue"><bean:message bundle="labels" key="subject.introductionTip"/></font></td>
			</tr><tr id="introduction" style="display:none;">
				<th align="right" >
				<bean:message bundle="labels" key="subject.introduction"/></th>				
				<td align="left"><html:textarea property="introduction" rows="15" cols="30"/></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.excellentTag"/></th>
				<td align="left">
				     <bean:message bundle="labels" key="subject.excellentTagYes"/><html:radio property="excellentTag" value="true" />
				     <bean:message bundle="labels" key="subject.excellentTagNo"/><html:radio property="excellentTag" value="false"/>
				<html:errors property="excellentTag" /></td>
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
					<bean:message bundle="labels" key="button.cancel"/></html:cancel></td>	
			</tr>
		</html:form>
	</table>
	</body>
</html>
