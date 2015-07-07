
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'user_reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/style.css" rel="stylesheet" type="text/css" />

  </head>
  
  <body>
  <%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
   <a href="/adm/stu_reg.jsp">学生注册</a>
   <a href="/adm/jwy_reg.jsp">教务员注册</a>
   <a href="/adm/tea_reg.jsp">教师注册</a>
    <br>
    </div>
</div>
<%@include file="footer.jspf"%>
		</div>
  </body>
</html>

