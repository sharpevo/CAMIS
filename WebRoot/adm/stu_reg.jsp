
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<html:html>
<head>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
<html:javascript formName="StudentRegistrationForm"/>
<html:errors/>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">ѧ��ע��</td>
	</tr>
</table>
<html:form method="post" action="/adm/StudentRegistration.do" onsubmit="return validateStudentRegistrationForm(this);">
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">ѧ&nbsp;&nbsp;��:</div></td>
  	<td width="70%" bgcolor="#EFEBDE" class="biaoge_out"><input name="studentId" class="biaoge_input" value="" />
  	  <span class="STYLE1">���벻����ʮ���ַ�</span></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><input name="studentPassword" class="biaoge_input" value="" />
  	  <span class="STYLE1">���벻����ʮ���ַ�</span></td>
  </tr>

  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" bordercolor="#FFFFFF" class="biaoge_out"><input name="studentSex"  type="radio" value="��" checked />��<input name="studentsex"  type="radio" value="Ů" />Ů</td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><input name="studentName" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">ר&nbsp;&nbsp;ҵ:</div></td>
  	<td width="70%" class="biaoge_out"><input name="majorName" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><input name="studentClass" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><input name="studentPhone" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">&nbsp;&nbsp;E-mail:</div></td>
  	<td width="70%" class="biaoge_out"><input name="studentEmail" class="biaoge_input" value="" /></td>
  </tr>
</table>
<br />
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
<tr align="center">
<td><input name="b1" type="submit" class="button1" value="ע��"/>
  	&nbsp;&nbsp;<input name="b2" type="reset" class="button1" value="����"  /></td>
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

