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

						<a href="/adm/user_reg.jsp">ע��</a>
						<a href="/adm/adm_pwd_modify.jsp">�޸ı�����Ϣ</a>
						<a href="/adm/others_info_modify.jsp">�޸�������Ϣ</a>
						<a href="/adm/ShowSubject.do?nowPage=1">�������</a>
						<a href="/adm/news_publish.jsp">��Ϣ����</a>
						<a href="/adm/stu_change_subject.jsp">ѧ������</a>
						</div>
						</div>
						<%@include file="footer.jspf"%>
						
						</div>
	</body>
	</html:html>