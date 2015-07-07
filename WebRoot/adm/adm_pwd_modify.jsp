<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html>	
	<link rel="stylesheet" type="text/css" href="../css/style.css"> 
  <body>
  <html:javascript formName="AdmInfoModifyForm"/>
  <html:errors/>
  <%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
    <html:form  action="/adm/AdmInfoModify.do" method="post" onsubmit="return validateAdmInfoModifyForm(this);">
<table cellspacing="0" cellpadding="0" width="60%" align="center" border="1">
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">请输入旧密码:</div></td>
  	<td width="70%" class="biaoge_out"><input name="oldPassword" class="biaoge_input" type="password" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">请输入新密码:</div></td>
  	<td width="70%" class="biaoge_out"><input name="newPassword" class="biaoge_input" type="password" value="" /></td>
  </tr>
  <tr>
  	<td width="30%" bordercolor="#FFFFFF" class="biaoge_info"><div align="center">请确认新密码:</div></td>
  	<td width="70%" class="biaoge_out"><input name="confirmPassword" class="biaoge_input" type="password" value="" /></td>
  </tr>
 </table><br/>
 <table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
  <tr align="center">
  	<td width="70%" class="biaoge_out"><input  type="submit" class="button1" value="注册"/>
  	&nbsp;&nbsp;<input  type="reset" class="button1" value="重置"  /></td>
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

