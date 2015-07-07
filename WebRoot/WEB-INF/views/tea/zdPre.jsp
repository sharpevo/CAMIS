<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
<head>
  <title><bean:message bundle="labels" key="teacher.marking.title"/>-<bean:message bundle="labels" key="teacher.marking.role_ZD"/></title>
  <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
  <html:base/>
</head>
<body>
	<html:errors property="submitagain"/>
	<logic:messagesPresent message="true">
		<br/><html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font><br/>
		</html:messages>
	</logic:messagesPresent>	
	<html:errors property="submitagain"/>

  <display:table name="sessionScope.ZDList" sort="list" pagesize="5"  class="ITS" requestURI="/tea/zdPre.do" border="1" rules="none">
    <display:column property="studentId" titleKey="titlekey.student.id" sortable="true"/>
    <display:column property="studentName" titleKey="titlekey.student.name"/>
    <display:column property="link" titleKey="titlekey.status" sortable="true"/>
  </display:table>  
</body>
</html>