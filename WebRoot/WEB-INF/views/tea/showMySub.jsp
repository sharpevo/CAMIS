<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
	<head>
		<title><bean:message bundle="labels" key="teacher.showMySub.title"/></title>
		 <link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
		 <html:base/>
	</head>
<body>
  <display:table id="mySub" name="sessionScope.subjectInfoList" sort="page" pagesize="5" export="true" class="ITS" requestURI="/tea/showMySub.do" border="1" rules="none">
    <display:setProperty name="export.pdf.class" value="org.chd.tea.ShowMySub2PDF"/>
    <display:column property="subjectId" titleKey="titlekey.subject.id" sortable="true"/>
    <display:column property="subject" titleKey="titlekey.subject.name" maxLength="5"/>
    <display:column property="fieldName" titleKey="titlekey.subject.field" sortable="true"/>
    <display:column property="propertyName" titleKey="titlekey.subject.property" sortable="true"/>
    <display:column property="sourceName" titleKey="titlekey.subject.source" sortable="true"/>
    <display:column property="typeName" titleKey="titlekey.subject.type" sortable="true"/>
    <display:column property="difficulty" titleKey="titlekey.subject.difficulty" sortable="true"/>
    <display:column  property="case" href="/tea/reqPre.do" paramId="subId" paramProperty="subjectId" titleKey="titlekey.requirement.name" sortable="true"/>
    <display:column title="Operation">
    	<html:link action="/subPre" paramId="subId" paramName="mySub" paramProperty="subjectId"><bean:message bundle="labels" key="teacher.menu.modify"/></html:link>
    	/<html:link page="/deleteSubject.do?action=delete" paramId="subId" paramName="mySub" paramProperty="subjectId"><bean:message bundle="labels" key="teacher.menu.delete"/></html:link>
    </display:column>
    
    <display:setProperty name="paging.banner.placement" value="top"/>
</display:table>  
</body>
</html>