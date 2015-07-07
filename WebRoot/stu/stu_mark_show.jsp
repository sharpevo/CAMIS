<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>毕业设计管理信息系统―成绩查询</title>
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
  SubjectInfo subject=(SubjectInfo)request.getAttribute("StudentSubject");
 %>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">查询成绩</td>
	</tr>
</table><br>
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">学&nbsp;&nbsp;号:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentId() %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">姓&nbsp;&nbsp;名:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentName() %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">专&nbsp;&nbsp;业:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getMajorName() %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">题&nbsp;&nbsp;目:</div></td>
  	<td width="70%" class="biaoge_out"><%
  	if(subject.getSubject()!=null)
  	{
     out.println(subject.getSubject());
     }
     else
     {
      out.println("暂时为空");
     } %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">成&nbsp;&nbsp;绩:</div></td>
  	<td width="70%" class="biaoge_out"><%
  	if( subject.getMark()!=null)
  	{
  	  out.println(subject.getMark());
  	  }
  	  else
  	  {
  	   out.println("暂时为空");
  	  } %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">是否校优:</div></td>
  	<td width="70%" class="biaoge_out"><%
  	if(subject.getExcellentTag())
  	{
  	  out.println("是");
  	  }
  	  else
  	  {
  	   out.println("否");
  	  } %></td>
  </tr>
</table>
 <br />
 <table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
         <tr align="center">
           <td align="middle" height="20"><input class="button1" onclick="javascript:window.close()" type="button" value="关闭" name="Submit43222" />           </td></tr>

</table>
</div>
	</div>
						</div>
						<%@include file="footer.jspf"%>
						
												</div>
</body>
</html>
