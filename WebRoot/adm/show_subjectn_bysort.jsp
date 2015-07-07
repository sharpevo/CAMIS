
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>My JSP 'showsubject_bysort.jsp' starting page</title>
    
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
  <%
    HashSet subjectSet=(HashSet)request.getAttribute("SubjectSet");
    String studentId=(String)request.getAttribute("studentId");
    Iterator i1=subjectSet.iterator();
   %>
   <table cellspacing="2" cellpadding="0" border="0" width="80%"
			align="center">
			<tr>
				<td width="10%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">编号</span>
				</td>
				<td width="50%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">题目</span>
				</td>
				<td width="20%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">出题教师</span>
				</td>	
				<td width="20%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">选题</span>
				</td>								
			</tr>
			<%
				while (i1.hasNext())

				{
					SubjectInfo subject = (SubjectInfo) i1.next();
					out.println("<tr><td><a href='/adm/ShowSubjectDetail.do?subjectId=" + subject.getSubjectId() +"'>" + subject.getSubjectId() + "</a></td>");
					out.println("<td>" + subject.getSubject() + "</td>");
					out.println("<td><a href='/adm/ShowTeacherInfo.do?teacherId="+subject.getTeacherAId()+"'>"+ subject.getTeacherAId() + "</td>");				
					out.println("<td><a href='/adm/changeSubject.do?subjectId="+subject.getSubjectId()+"&studentId="+studentId+"'>"+"换 题</a></td></tr>");
				}
			%>
		</table>
    <br>
    </div>
</div>
<%@include file="footer.jspf"%>
		</div>
  </body>
</html>

