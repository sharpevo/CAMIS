<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
<title>��ҵ��ƹ�����Ϣϵͳ�D����Աע��</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<html:javascript formName="JwyInfoModifyForm"/>
<%
  AdminInfo Jwy=(AdminInfo)request.getAttribute(MisConstants.JWYINFO_KEY);
%>
<html:errors/>
<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">�޸Ľ���Ա��Ϣ</td>
	</tr>
</table>

<br />
<html:form  action="/adm/JwyInfoModify.do" method="post" onsubmit="return validateJwyInfoModifyForm(this);">
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">����Ա���:</div></td>
  	<td width="70%" class="biaoge_out"><input name="adminId" class="biaoge_input" value="<%=Jwy.getAdminId() %>" />
  	  <span class="STYLE1">*��Ų�����10���ַ�</span></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">����������:</div></td>
  	<td width="70%" class="biaoge_out"><input name="adminPassword" class="biaoge_input" value="<%=Jwy.getAdminPassword() %>" />
  	  <span class="STYLE1">*���벻����10���ַ�</span></td>
  </tr>
 </table><br/>
 <table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
  <tr align="center">
  	<td width="70%" class="biaoge_out"><input name="b1" type="submit" class="button1" value="�ύ"/>
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

