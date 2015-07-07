<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
	<head>
		<title><bean:message bundle="labels" key="teacher.censor.title"/></title>
		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
	</head>

<body>
	<logic:messagesPresent message="true">
		<br/><html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font>
		</html:messages><br/>
	</logic:messagesPresent>	
	<html:errors property="submitagain"/>

<display:table name="sessionScope.reportList" sort="list" pagesize="5"  class="ITS" requestURI="/tea/censorReport.do" border="1" rules="none">
    <display:column property="studentId" titleKey="titlekey.student.id" sortable="true"/>
    <display:column property="studentName" titleKey="titlekey.student.name" maxLength="8"/> 
    <display:column property="reportIsValid" titleKey="titlekey.status" sortable="true"/> 
</display:table> <BR> 
</body>
</html>



