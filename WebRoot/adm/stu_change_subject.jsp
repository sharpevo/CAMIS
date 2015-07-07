
<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<html>
	<head>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />

</style>
	</head>
	<body>
	<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				<div id="register">
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr>
					<h2>请输入学号</h2>
			</tr>
		</table>
		<br />
		<form name="form1" action="/adm/ShowStudentSubject.do" method="post">
			<table cellspacing="0" cellpadding="0" width="60%" align="center"
				border="1">
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							学号:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						<input name="studentId" class="biaoge_input" value="" />
					</td>
				</tr>
				<table cellspacing="0" cellpadding="0" width="60%" align="center"
					border="0">
					<tr align="center">
						<td>
							<input  type="submit" class="button1" value="查询" />
							&nbsp;&nbsp;
							<input  type="reset" class="button1" value="重置" />
						</td>
					</tr>
				</table>
				</table>
				</form>
				</div>
				</div>
						</div>
						<%@include file="footer.jspf"%>
						</div>
	</body>
</html>


