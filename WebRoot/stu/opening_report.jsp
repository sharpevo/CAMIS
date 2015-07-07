<%@ page language="java" pageEncoding="GBK" %>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
	<head>
		<title>毕业设计管理信息系统―填写开题报告</title>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				
       <html:javascript formName="AddOpeningPortForm" />
		<%
			SubjectInfo subject = (SubjectInfo) request
					.getAttribute("OpeningReport");
			StudentInfo student = (StudentInfo) session
					.getAttribute(MisConstants.STUDENTINFO_KEY);
		%>
		<table cellspacing="0" cellpadding="0" border="0" width="70%"
			align="center">
			<tr>
				<td>
					<table cellspacing="0" cellpadding="0" border="0" width="100%"
						align="center">
						<tr>
							<td align="center" bgcolor="#FFFFFF" class="title2 STYLE1">
								<p align="center">
									长安大学毕业设计（论文）开题报告表
								</p>
							</td>
						</tr>
					</table>
					<br />
					<table cellspacing="0" cellpadding="3" border="0" width="100%"
						align="center">
						<tr>
							<td width="33%" class="biaoge_info">
								课题名称
							</td>
							<td>
								<%=subject.getSubject()%>
							</td>
						</tr>
						<tr>
							<td class="biaoge_info">
								课题来源
							</td>
							<td>
								&nbsp;
								<%=subject.getSourceName()%>
							</td>
							<td class="biaoge_info">
								课题类型
							</td>
							<td>
								&nbsp;
								<%=subject.getTypeName()%>
							</td>
							<td class="biaoge_info">
								指导教师
							</td>
							<td>
								<%=subject.getTeacherAId()%>
							</td>
						</tr>
						<tr>
							<td class="biaoge_info">
								学生姓名
							</td>
							<td>
								&nbsp;
								<%=student.getStudentName()%>
							</td>
							<td class="biaoge_info">
								学号
							</td>
							<td>
								&nbsp;
								<%=student.getStudentId()%>
							</td>
							<td class="biaoge_info">
								专业
							</td>
							<td>
								<%=student.getMajorName()%>
							</td>
						</tr>
					</table>
					<html:form action="/stu/AddOpeningPort.do" method="post" onsubmit="validateAddOpeningPortForm(this);">
						<table cellspacing="0" cellpadding="3" border="0" width="100%"
							align="center">
							<tr>
								<td class="biaoge_info">
									开题报告内容
								</td>
							</tr>
							<tr>
								<td>
									<textarea name="content" class="input_text_long"></textarea>
								</td>
							</tr>
							<tr><td>
					  		<table cellspacing="0" cellpadding="3" border="0" width="100%"
							align="center">
							<tr align="center">
								<td>
									<input type="submit" class="button1" value="提交" />
									&nbsp;&nbsp;
									<input type="reset" class="button1" value="重置" />
								</td>
							</tr>
						</table>
				        </td>
			        </tr>
		         </table>
		</html:form>
				        </div>
						</div>
						<%@include file="footer.jspf"%>
						</div>
						</body>
</html:html>
