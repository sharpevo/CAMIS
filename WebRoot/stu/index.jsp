<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
  <head> 
    <title>My JSP 'stu_main.jsp' starting page</title>   
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
  <html:errors/>
  <%
    StudentInfo student=(StudentInfo)request.getSession().getAttribute(MisConstants.STUDENTINFO_KEY);
   %>
    <a href="/stu/stu_info.jsp">查看个人信息 </a>
    <a href="/stu/stu_info_modify.jsp">修改信息</a>
    <a href="/stu/StuSelectSubject.do?nowPage=1">选题</a>
    <a href="/stu/subjectShow.do?studentId=<%=student.getStudentId() %>">选题结果</a>
    <a href="/stu/StuMarkShow.do?studentId=<%=student.getStudentId() %>">查询成绩</a>
    <a href="stu_paper_upload.jsp">上传论文</a>
    <a href="/stu/showOpeningReport.do?studentId=<%=student.getStudentId()%>">写开题报告</a>
    <br>
    </div>
						</div>
						<%@include file="footer.jspf"%>
						
  </body>
</html:html>

