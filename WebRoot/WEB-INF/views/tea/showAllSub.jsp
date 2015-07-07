<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
	<head>
		<title><bean:message bundle="labels" key="teacher.showAllSub.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
	</head>
<body>
	<logic:messagesPresent message="true">
		<html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font>
		</html:messages>
	</logic:messagesPresent>
	<table border="0">
		<html:form action="/showAllSub">
		<html:hidden property="submit" value="true"/>
			<tr>
				<th align="right"><bean:message bundle="labels" key="teacher.name"/></th>
				<td align="left"><html:select property="teacherAId">
					<html:optionsCollection name="teacherOption"/>
					</html:select></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.field"/></th>
				<td align="left"><html:select property="fieldName">
					<html:optionsCollection name="fieldOption"/>
					</html:select></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.difficulty"/></th>
				<td align="left"><html:select property="difficulty" >
				<html:option value="">>---------&lt;</html:option>
			    <html:option key="a" value="A"/>
				<html:option key="b" value="B"/>
				<html:option key="c" value="C"/>
				</html:select></td>
			</tr><tr>
				<th align="right"><bean:message bundle="labels" key="subject.year"/></th>
				<td align="left"><html:select property="subYears">
					<html:optionsCollection name="subjectYears"/>
					</html:select></td>
			</tr><tr>
				<td>&nbsp;</td><td align="left"><html:submit><bean:message bundle="labels" key="button.query"/></html:submit></td>
			</tr>
		</html:form>
	</table>
<display:table id="allSub" name="sessionScope.subjectInfoList" sort="page" pagesize="10"  class="ITS" requestURI="/tea/showAllSub.do" border="1" rules="none">
    <display:column property="subjectId" titleKey="titlekey.subject.id" sortable="true"/>
    <display:column property="subject" href="/tea/skimSub.do" paramId="subId" paramProperty="subjectId" titleKey="titlekey.subject.name" maxLength="8"/> 
	<display:column property="teacherName" href="/tea/skimTea.do" paramId="teaId" paramProperty="teacherAId" titleKey="titlekey.teacher.name" maxLength="8"/> 
    <display:column property="difficulty" titleKey="titlekey.subject.difficulty" sortable="true"/>
	<display:column property="years" titleKey="titlekey.subject.years"/>
</display:table>

</body>
</html>
