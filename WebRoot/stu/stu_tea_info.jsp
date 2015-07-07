<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>教师信息</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				<div id="register">
<%
   TeacherInfo teacher=(TeacherInfo)request.getAttribute("StuTeaInfo");
 %>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">教师信息</td>
	</tr>
</table><br />
<table cellspacing="2" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td width="20%" align="center" class="biaoge_info" ><span class="STYLE3">教师姓名</span></td>
		<td width="80%"><%=teacher.getTeacherName() %></td>
	</tr>
	<tr>
		<td width="20%" align="center" class="biaoge_info" ><span class="STYLE3">教师职称</span></td>
		<td><%if(teacher.getPost()!=null) out.println(teacher.getPost()); %></td>
	</tr>
	<tr>
		<td width="20%" align="center" class="biaoge_info" ><span class="STYLE3">研究方向</span></td>
		<td><%if(teacher.getFieldName()!=null) out.println(teacher.getFieldName()); %></td>
	</tr>
	<tr>
		<td width="20%" align="center" class="biaoge_info" ><span class="STYLE3">联系电话</span></td>
		<td><%if(teacher.getTeacherPhone()!=null) out.println(teacher.getTeacherPhone()); %></td>
	</tr>
	<tr>
		<td width="20%" align="center" class="biaoge_info" >电子邮件</td>
		<td><%if(teacher.getTeacherEmail()!=null) out.println(teacher.getTeacherEmail()); %></td>
	</tr>
</table><br/>
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
         <tr align="center">
          <td height="20"><input class="button1" type="button"  onclick="javascript:window.close()" value="关闭" name="Submit4321" /> 
          </td>
		  </tr>
</table>
</div>
	</div>
						</div>
						<%@include file="footer.jspf"%>
						
												</div>
</body>
</html>
