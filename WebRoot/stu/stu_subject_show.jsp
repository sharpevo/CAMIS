<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<html>
	<head>
		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
	<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				<div id="register">
	<%
	  StudentInfo student=(StudentInfo)session.getAttribute(MisConstants.STUDENTINFO_KEY);
	  SubjectInfo subject=(SubjectInfo)request.getAttribute(MisConstants.SUBJETINFO_KEY);
	 if(student!=null&&subject!=null)
	 {
	 %>
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr>
				<td align="center" class="title1">
					ѧ��ѡ����Ϣ
				</td>
			</tr>
		</table>
		<br />
		<form name="form1" method="post" action="/stu/StuSubjectCancel.do">
			<table cellspacing="0" cellpadding="0" width="60%" align="center"
				border="1">
				<input type="hidden" name="studentId" value="<%=student.getStudentId() %>"/>
				<input type="hidden" name="subjectId" value="<%=subject.getSubjectId() %>"/>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							ѧ&nbsp;&nbsp;��:
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
							��&nbsp;&nbsp;��:
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
							ר&nbsp;&nbsp;ҵ:
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
							��&nbsp;&nbsp;��:
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
							��ѡ��������:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getSubject() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							ָ����ʦ:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getTeacherAId() %> &nbsp;<%=subject.getTeacherBId() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							�����Ѷ�:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getDifficulty() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							������Դ:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getSourceName() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							��������:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getPropertyName() %>
					</td>
				</tr>
				<tr>
					<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
						<div align="center">
							�������:
						</div>
					</td>
					<td width="70%" class="biaoge_out">
						&nbsp;<%=subject.getTypeName() %>
					</td>
				</tr>
			</table>
			<br />
			<table cellspacing="0" cellpadding="0" border="0" width="60%"
				align="center">
				<tr align="center">
					<td>
						<input name="b1" type="submit" class="button1"
							value="����" />
						&nbsp;&nbsp;
						<input name="b2" type="button" class="button1" value="�ر�"
							onclick=window.close() />
					</td>
				</tr>
			</table>
		</form>
		<%
		}
		else
		{
		   out.println("�Բ���,����û��ѡ��");
		}
		 %>
		 </div>
	</div>
						</div>
						<%@include file="footer.jspf"%>
						
												</div>
		</body>
</html>
