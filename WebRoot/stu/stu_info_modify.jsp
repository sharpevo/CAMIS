<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
	<title>��ҵ��ƹ�����Ϣϵͳ�D�޸�ѧ����Ϣ</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				<div id="register">
	<html:javascript formName="StuInfoModForm" />
	<%
			StudentInfo student = (StudentInfo) session
			.getAttribute(MisConstants.STUDENTINFO_KEY);
			if (student != null) {
	%>
	<table cellspacing="0" cellpadding="0" border="0" width="60%"
		align="center">
		<tr>
			<td align="center" class="title1">
				�޸�ѧ����Ϣ
			</td>
		</tr>
	</table>
	<html:form method="post" action="/stu/StuInfoMod.do"
		onsubmit="return validateStuInfoModForm(this);">
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="1">
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						ѧ&nbsp;&nbsp;��:
					</div>
				</td>
				<td width="70%" bgcolor="#EFEBDE" class="biaoge_out">
					<%=student.getStudentId()%>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						��&nbsp;&nbsp;��:
					</div>
				</td>
				<td width="70%" bordercolor="#FFFFFF" class="biaoge_out">
					<%=student.getStudentSex()%>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						��&nbsp;&nbsp;��:
					</div>
				</td>
				<td width="70%" class="biaoge_out">

					<%=student.getStudentName()%>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						ר&nbsp;&nbsp;ҵ:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<%=student.getMajorName()%>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						��&nbsp;&nbsp;��:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<%=student.getStudentClass()%>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						��&nbsp;&nbsp;��:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<input name="studentPhone" class="biaoge_input"
						value="<%
						if(student.getStudentPhone()!=null)
						out.println(student.getStudentPhone());
						%>" />
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						&nbsp;&nbsp;E-mail:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<input name="studentEmail" class="biaoge_input"
						value="<%=student.getStudentEmail()%>" />
				</td>
			</tr>
		</table>
		<br />
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr align="center">
				<td>
					<input name="b1" type="submit" class="button1" value="�ύ" />
					&nbsp;&nbsp;
					<input name="b2" type="reset" class="button1" value="����" />
				</td>
			</tr>
			<input type="hidden" name="studentId"
				value="<%=student.getStudentId()%>" />
		</table>
	</html:form>
	<%
				} else
				response.sendRedirect("error.jsp");
	%>
	</div>
	</div>
						</div>
						<%@include file="footer.jspf"%>
						
						</div>
</body>

</html:html>
