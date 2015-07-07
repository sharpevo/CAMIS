
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
	<<link href="../css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  <%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
     <%
       TeacherInfo teacher=(TeacherInfo)request.getAttribute(MisConstants.TEACHERINFO_KEY);
       String consultTag=null;
       if(teacher.getConsultTag()) consultTag="ÊÇ";
       else consultTag="·ñ";
      %>
      <table>
      <tr><td>teacherId:<%=teacher.getTeacherId() %></td></tr>
      <tr><td>teacherName:<%=teacher.getTeacherName() %></td></tr>
      <tr><td>fieldName:<%if(teacher.getFieldName()!=null) out.println(teacher.getFieldName()); %></td></tr>
      <tr><td>majorName:<%if(teacher.getMajorName()!=null) out.println(teacher.getMajorName()); %></td></tr>
      <tr><td>post:<%if(teacher.getPost()!=null) out.println(teacher.getPost()); %></td></tr>
      <tr><td>teacherEmail:<%if(teacher.getTeacherEmail()!=null) out.println(teacher.getTeacherEmail()); %></td></tr>
      <tr><td>sex:<%=teacher.getTeacherSex() %></td></tr>
      <tr><td>teacherPhone:<%if(teacher.getTeacherPhone()!=null) out.println(teacher.getTeacherPhone()); %></td></tr>
      <tr><td>workLoad:<% if(teacher.getWorkload()!=null) out.println(teacher.getWorkload()); %></td></tr>
      <tr><td>consultTag:<%=consultTag %></td></tr>
      </table>
      </div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
  </body>
</html>
