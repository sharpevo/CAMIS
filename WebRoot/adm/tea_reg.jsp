
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
<html:javascript formName="TeacherRegistrationForm"/>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">教师注册</td>
	</tr>
</table>
<br />
<html:errors/>
<html:form action="/adm/TeacherRegistration.do" method="post" onsubmit="return validateTeacherRegistrationForm(this);">
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">教师编号:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherId" class="biaoge_input" value="" />
  	  <span class="STYLE1">编号不超过十个字符</span></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">密&nbsp;&nbsp;码:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherPassword" class="biaoge_input" value="" />
  	  <span class="STYLE1">编号不超过十个字符</span></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">姓&nbsp;&nbsp;名:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherName" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">性&nbsp;&nbsp;别:</div></td>
  	<td width="70%" class="biaoge_out" colspan="0"><input name="teacherSex"  type="radio" value="男" checked/>男<input name="teachersex"  type="radio" value="女" />女</td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">专&nbsp;&nbsp;业:</div></td>
  	<td width="70%" class="biaoge_out"><input name="majorName" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">职&nbsp;&nbsp;称:</div></td>
  	<td width="70%" class="biaoge_out"><input name="post" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">研究方向:</div></td>
  	<td width="70%" class="biaoge_out"><input name="fieldName" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">电&nbsp;&nbsp;话:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherPhone" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">E-mail:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherEmail" class="biaoge_input" value="" /></td>
  </tr>
</table>
<br>
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
<tr align="center">
<td><input  name="b1" type="submit" class="button1" value="注册"/>
&nbsp;&nbsp;<input name="b2" type="reset" class="button1" value="重置"  /></td>
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

