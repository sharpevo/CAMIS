<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>
	<head>

		<link rel="stylesheet" type="text/css" href="../css/style.css">
	</head>
	<body>
	<%
    AdminInfo admin=(AdminInfo)session.getAttribute(MisConstants.ADMININFO_KEY);
    %>
		<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
					<table>

						<a href="/adm/user_reg.jsp">注册</a>
						<a href="/adm/adm_pwd_modify.jsp">修改本人信息</a>
						<a href="/adm/others_info_modify.jsp">修改他人信息</a>
						<a href="/adm/ShowSubject.do?nowPage=1">浏览课题</a>
						<a href="/adm/news_publish.jsp">信息发布</a>
						<a href="/adm/stu_change_subject.jsp">学生换题</a>
						</div>
						</div>
						<%@include file="footer.jspf"%>
						
						</div>
	</body>
	</html:html>