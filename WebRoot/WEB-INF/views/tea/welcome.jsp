<%@ page contentType="text/html;charset=gb2312" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> 
<html> 
	<head>
		<title>Home-Teacher</title>
		<link rel="stylesheet" href="/tea/css/tea.css" type="text/css" media="screen, print" />
  		<html:base/>

	</head>

<body>
	
	<strong><bean:write name="TEACHERBEAN" property="roleName"/>&nbsp;<bean:write name="TEACHERBEAN" property="teacherName"/></strong> �����ã�<BR>
	<BR>
	��ӭ��ʹ��CAMIS��<BR>
	�����Ե����ߵĲ˵���������ĵ��������в���
	<BR><BR><BR>
	<html:errors property="errors"/>

</body>
</html>

