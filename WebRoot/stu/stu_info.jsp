<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://202.117.64.82/student/pim/stubaseinfo.jsp -->
<html xmlns="http://www.w3.org/1999/xhtml">
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
%>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">������Ϣ</td>
	</tr>
</table>
<br />
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">ѧ&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentId()%></td>
  </tr>
  <tr>
  	<td width="30%" height="26" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentName()%></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentSex()%></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">ר&nbsp;&nbsp;ҵ:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getMajorName()%></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentClass()%></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%
  	if(student.getStudentPhone()!=null)
  	{
  	  out.println(student.getStudentPhone());
  	  }
  	  else
  	  {
  	    out.println("��ʱΪ��");
  	  }
  	  %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center"> E-mail:</div></td>
  	<td width="70%" class="biaoge_out"><%
  	if(student.getStudentEmail()!=null)
  	{
  	out.println(student.getStudentEmail());
  	}
  	else
  	{
  	  out.println("��ʱΪ��");
  	  }
  	%></td>
  </tr>
</table>
 <br />
 <table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
         <tr align="center">
          <td align="middle" height="20"><a href="/stu/stu_info_modify.jsp">�޸ĸ�����Ϣ</a>
            <a href="/stu/stu_psw_modify.jsp">�޸�����</a> 
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
