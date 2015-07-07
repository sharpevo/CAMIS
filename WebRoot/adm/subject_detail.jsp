
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'tea_info_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../css/style.css">

  </head>
  
  <body>
  <%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
     <%
       SubjectInfo subject=(SubjectInfo)request.getAttribute(MisConstants.SUBJETINFO_KEY);
      %>
      <table>
      <tr><td>subjectId:</td><td><%=subject.getSubjectId() %></td></tr>
      <tr><td>subjectName:</td><td><%=subject.getSubject() %></td></tr>
      <tr><td>majorName:</td><td><%if(subject.getMajorName()!=null) out.println(subject.getMajorName()); %></td></tr>
      <tr><td>propertyName:</td><td><%if(subject.getPropertyName()!=null) out.println(subject.getPropertyName()); %></td></tr>
      <tr><td>sourceName:</td><td><%if(subject.getMajorName()!=null) out.println(subject.getMajorName()); %></td></tr>
      <tr><td>typeName:</td><td><%if(subject.getTypeName()!=null) out.println(subject.getTypeName()); %></td></tr>
      </table>
      </div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
  </body>
</html>
