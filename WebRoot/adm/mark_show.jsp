
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>��ҵ��ƹ�����Ϣϵͳ�D�ɼ���ѯ</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
<%
   SubjectInfo subject=(SubjectInfo)request.getAttribute(MisConstants.SUBJETINFO_KEY);
   StudentInfo student=(StudentInfo)request.getAttribute(MisConstants.STUDENTINFO_KEY);
 %>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">��ӡ�ɼ�</td>
	</tr>
</table><br/>
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">ѧ&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=subject.getStudentId() %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getStudentName() %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">ר&nbsp;&nbsp;ҵ:</div></td>
  	<td width="70%" class="biaoge_out"><%=student.getMajorName() %></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��&nbsp;&nbsp;��:</div></td>
  	<td width="70%" class="biaoge_out"><%=subject.getMark() %></td>
  </tr>
</table>
 <br />
  <form method="post" name="form1" id="form1">
 <table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
       
         <tr align="center">
          <td align="middle" height="20"><input class="button1" type="button" value="��ӡ" name="Submit4322" />    
            �� 
            <input class="button1" onclick="javascript:window.open('query.jsp')" type="button" value="��ѯ��һ��"  />     
            �� 
            <input class="button1" onclick="javascript:window.close()" type="button" value="�ر�" />           </td>
		  </tr>
		
</table></form>
</div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
</body>
</html>
