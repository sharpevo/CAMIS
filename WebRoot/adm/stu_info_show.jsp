
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
	<head>
		
		<title>��ҵ��ƹ�����Ϣϵͳ�D�޸�ѧ����Ϣ</title>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<%
	  StudentInfo student=(StudentInfo)request.getAttribute(MisConstants.STUDENTINFO_KEY);
	 %>
	<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
	<html:javascript formName="StudentInfoModifyForm"/>
		<html:errors/>
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr>
				<td align="center" class="title1">
					�޸�ѧ����Ϣ
				</td>
			</tr>
		</table>
		<br />
		<html:form  method="post" action="/adm/StudentInfoModify.do" onsubmit="validateStudentInfoModifyForm(this);">
			<table cellspacing="0" cellpadding="0" width="60%" align="center"
				border="1">
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							ѧ&nbsp;&nbsp;��:
						</div>
					</td>
					<td width="70%" bgcolor="#EFEBDE" class="biaoge_out">
						<input name="studentId" class="biaoge_input"
							value="<%=student.getStudentId() %>" />
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							��&nbsp;&nbsp;��:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						<input name="studentPassword" class="biaoge_input"
							value="<%=student.getStudentPassword() %>" />
					</td>
				</tr>

				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							��&nbsp;&nbsp;��:
						</div>
					</td>
					<td width="70%" bordercolor="#FFFFFF" class="biaoge_out">
						<input  name="studentSex" value="<%=student.getStudentSex() %>"/>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							��&nbsp;&nbsp;��:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						<input name="studentName" class="biaoge_input"
							value="<%=student.getStudentName() %>" />
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							ר&nbsp;&nbsp;ҵ:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						<input name="majorName" class="biaoge_input"
							value="<%=student.getMajorName()%>" />
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							��&nbsp;&nbsp;��:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						<input name="studentClass" class="biaoge_input"
							value="<%=student.getStudentClass() %>" />
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
							value="<%if(student.getStudentPhone()!=null) out.println(student.getStudentPhone()); %>" />
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
							value="<%if(student.getStudentEmail()!=null) out.println(student.getStudentEmail()); %>" />
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
			</table>
		</html:form>
		</div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
	</body>
</html:html>
