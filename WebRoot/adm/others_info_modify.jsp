
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ��ƹ�����Ϣϵͳ�D��Ϣ�޸�</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">��Ϣ�޸�</td>
	</tr>
</table><br/>
<form id="form1" name="form1" method="post" action="/adm/UserInfoModify.do">
<table cellspacing="2" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  <td>
    <label>
      <input type="radio" value="teacher" name="identity" checked/>
    </label>��ʦ��Ϣ�޸�
  </td>
  <td>�����ʦ��</td>
  <td><input name="teacherId" class="biaoge_input" value="" />
  </td>
  <td align="center"><input class="button1"  type="submit" value="ȷ��" /> </td>
  </tr>
  <tr>
  <td>
    <label>
      <input type="radio" value="jwy" name="identity" />
    </label>����Ա��Ϣ�޸�
  </td>
  <td>�������Ա���</td>
  <td><input name="adminId" class="biaoge_input" value="" />
  </td>
  <td align="center"><input class="button1"  type="submit" value="ȷ��" /> </td>
  </tr>
  <tr>
  <td>
    <label>
      <input type="radio" value="student" name="identity" />
    </label>ѧ����Ϣ�޸�
  </td>
  <td>����ѧ��</td>
  <td ><input name="studentId" class="biaoge_input" value="" />
  </td>
  <td align="center"><input class="button1"  type="submit" value="ȷ��"  /> </td>
  </tr>
</table>
</form>
</div>
</div>
</div>
<%@include file="footer.jspf"%></div>		
</body>
</html>
