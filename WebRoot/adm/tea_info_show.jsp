
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://202.117.64.82/student/pim/stubaseinfo.jsp -->
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
<html:javascript formName="TeacherInfoModifyForm"/>
<%
 TeacherInfo teacher=(TeacherInfo)request.getAttribute(MisConstants.TEACHERINFO_KEY);
 if(teacher!=null)
 {
 %>
 <html:errors/>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">修改教师信息</td>
	</tr>
</table>
<br />
<html:form name="form1" action="/adm/TeacherInfoModify.do" method="post" onsubmit="return validateTeacherInfoModifyForm(this);">
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">教师编号:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherId" class="biaoge_input"  value="<%=teacher.getTeacherId() %>"/></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">密&nbsp;&nbsp;码:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherPassword" class="biaoge_input" value="<%=teacher.getTeacherPassword() %>" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">姓&nbsp;&nbsp;名:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherName" class="biaoge_input" value="<%=teacher.getTeacherName() %>" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">性&nbsp;&nbsp;别:</div></td>
  	<td width="70%" class="biaoge_out" colspan="0"><input name="teacherSex"  type="radio" value="男" />男<input name="sex" checked type="radio" value="女" />女</td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">专&nbsp;&nbsp;业:</div></td>
  	<td width="70%" class="biaoge_out"><input name="majorId" class="biaoge_input" value="<%=teacher.getMajorName() %>" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">职&nbsp;&nbsp;称:</div></td>
  	<td width="70%" class="biaoge_out"><input name="post" class="biaoge_input" value="<%=teacher.getPost() %>" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">方向:</div></td>
  	<td width="70%" class="biaoge_out"><input name="fieldName" class="biaoge_input" value="<%if(teacher.getFieldName()!=null) out.println(teacher.getFieldName()); %>" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">电&nbsp;&nbsp;话:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherPhone" class="biaoge_input" value="<%if(teacher.getTeacherPhone()!=null) out.println(teacher.getTeacherPhone()); %>" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">E-mail:</div></td>
  	<td width="70%" class="biaoge_out"><input name="teacherEmail" class="biaoge_input" value="<%if(teacher.getTeacherEmail()!=null) out.println(teacher.getTeacherEmail()); %>" /></td>
  </tr>
</table>
<br/>
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
<tr align="center">
<td><input  name="b1" type="submit" class="button1" value="修改"/>
&nbsp;&nbsp;<input name="b2" type="reset" class="button1" value="重置"  /></td>
</tr>
</table>
</html:form>
<%
}
else response.sendRedirect("error.jsp"); %>
</div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
</body>
</html:html>
