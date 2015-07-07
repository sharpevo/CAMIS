
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<html>
	<head>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<%
	  StudentInfo student=(StudentInfo)request.getAttribute(MisConstants.STUDENTINFO_KEY);
	  SubjectInfo subject=(SubjectInfo)request.getAttribute(MisConstants.SUBJETINFO_KEY);
	 %>
	 <%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr>
				<td align="center" class="title1">
					学生选题信息
				</td>
			</tr>
		</table>
		<br />
		<form name="form1" method="post" action="/adm/ShowSubjectN.do?nowPage=1">
			<table cellspacing="0" cellpadding="0" width="60%" align="center"
				border="1">
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							学&nbsp;&nbsp;号:
						</div>
					</td>
					<td width="70%" bgcolor="#EFEBDE" class="biaoge_out">
					<%=student.getStudentId() %>
						&nbsp;
					</td>
				</tr>

				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							姓&nbsp;&nbsp;名:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;
						<%=student.getStudentName() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							专&nbsp;&nbsp;业:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;
						<%=student.getMajorName() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							班&nbsp;&nbsp;级:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;
						<%=student.getStudentClass() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							已选课题名称:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<a href="/adm/ShowSubjectDetail.do?subjectId=<%=subject.getSubjectId() %>"><%=subject.getSubject() %></a>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							指导教师:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<a href="/adm/ShowTeacherInfo.do?teacherId=<%=subject.getTeacherAId() %>"><%=subject.getTeacherAId() %> </a>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							课题难度:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getDifficulty() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							课题来源:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%if(subject.getSourceName()!=null) out.println(subject.getSourceName()); %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							课题性质:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%if(subject.getPropertyName()!=null) out.println(subject.getPropertyName()); %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							课题类别:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%if(subject.getTypeName()!=null) out.println(subject.getTypeName()); %>
					</td>
				</tr>
				<tr><td><input type="hidden" name="studentId" value="<%=student.getStudentId() %>"></td></tr>
			</table>
			<br />
			<table cellspacing="0" cellpadding="0" border="0" width="60%"
				align="center">
				<tr align="center">
					<td>
						<input name="b1" type="submit" class="button1"
							value="换题" />
						&nbsp;&nbsp;
						<input name="b2" type="button" class="button1" value="关毕"
							onclick=window.close() />
					</td>
				</tr>
			</table>
		</form>
		</div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
	</body>
</html>

