<%@ page language="java" pageEncoding="GBK" %>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
	<head>
		<title>��ҵ��ƹ�����Ϣϵͳ�D��д���ⱨ��</title>
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
									������ѧ��ҵ��ƣ����ģ����ⱨ���
								</p>
							</td>
						</tr>
					</table>
					<br />
					<table cellspacing="0" cellpadding="3" border="0" width="100%"
						align="center">
						<tr>
							<td width="33%" class="biaoge_info">
								��������
							</td>
							<td>
								<%=subject.getSubject()%>
							</td>
						</tr>
						<tr>
							<td class="biaoge_info">
								������Դ
							</td>
							<td>
								&nbsp;
								<%=subject.getSourceName()%>
							</td>
							<td class="biaoge_info">
								��������
							</td>
							<td>
								&nbsp;
								<%=subject.getTypeName()%>
							</td>
							<td class="biaoge_info">
								ָ����ʦ
							</td>
							<td>
								<%=subject.getTeacherAId()%>
							</td>
						</tr>
						<tr>
							<td class="biaoge_info">
								ѧ������
							</td>
							<td>
								&nbsp;
								<%=student.getStudentName()%>
							</td>
							<td class="biaoge_info">
								ѧ��
							</td>
							<td>
								&nbsp;
								<%=student.getStudentId()%>
							</td>
							<td class="biaoge_info">
								רҵ
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
									���ⱨ������
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
									<input type="submit" class="button1" value="�ύ" />
									&nbsp;&nbsp;
									<input type="reset" class="button1" value="����" />
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
