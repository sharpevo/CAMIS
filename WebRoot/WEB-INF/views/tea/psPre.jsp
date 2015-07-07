<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
<head>
		<title><bean:message bundle="labels" key="teacher.commenting.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		<html:base/>
</head>
<body>
	<logic:messagesPresent message="true">
		<html:messages id="message"  message="true">
			<font color="blue"><bean:write name="message"/></font>
		</html:messages>
	</logic:messagesPresent>
<display:table name="sessionScope.pslist" sort="list" export="true"  pagesize="10"  class="ITS" requestURI="/tea/psPre.do" border="1" rules="none">
    <display:column property="subjectId" titleKey="titlekey.subject.id" sortable="true"/>
    <display:column property="subject" href="/tea/skimSub.do" paramId="subId" paramProperty="subjectId" titleKey="titlekey.subject.name" maxLength="16"/> 
    <display:column property="psStatus" titleKey="titlekey.status" sortable="true"/>
    <display:setProperty name="paging.banner.placement" value="top"/> 
</display:table> 

</body>
</html>	