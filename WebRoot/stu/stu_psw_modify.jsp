<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>

<head>
<title>��ҵ��ƹ�����Ϣϵͳ</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				<div id="register">
<html:javascript formName="StuPswModForm"/>
<html:errors/>
<p><h2>�޸�����<h2></p>

<html:form action="/stu/StuPswMod.do" method="post" onsubmit="return validateStuPswModForm(this);">
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">�����������:</div></td>
  	<td width="70%" class="biaoge_out"><input name="oldPsw" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">������������:</div></td>
  	<td width="70%" class="biaoge_out"><input name="newPsw" class="biaoge_input" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">��ȷ��������:</div></td>
  	<td width="70%" class="biaoge_out"><input name="confirmPsw" class="biaoge_input" value="" /></td>
  </tr>
</table>
 <br />
 <table cellspacing="0" cellpadding="0" width="60%" align="center" border="0">
         <tr align="center">
          <td align="middle" height="20"><input class="button1"  type="submit" value="�޸�" /> 
            �� 
            <input class="button1" type="button" value="����" name="Submit43222" />           </td>
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
