
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>毕业设计管理信息系统―成绩查询</title>
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
		<td align="center" class="title1">成绩查询</td>
	</tr>
</table><br/>
<form action="/adm/ShowMark.do" method="post">
<table cellspacing="2" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="left"><input type="radio" name="queryway" value="single" checked/>单个查询</td>
	</tr>
	<tr>
		<td align="left">输入学号</td>
		<td><input name="id" class="biaoge_input" value="" /></td>
		<td><label>
		  <input type="submit"  value="确定" />
		</label></td>
	</tr>
	<tr>
	    <td align="left"><input type="radio" name="queryway" value="quantity" />批量查询</td>
	</tr>
	<tr>
		<td align="left">输入班级号</td>
		<td><input name="id" class="biaoge_input" value="" /></td>
		<td><label>
		  <input type="submit" value="确定"/>
		</label></td>
	</tr>
</table>
</form>
</div>
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
</body>
</html>
