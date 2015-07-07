<%@ page contentType="text/html;charset=GBK" language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%> 
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%> 
<html> 
	<head>
		<title>Navigation</title>
  <html:base/>
	</head>
	<body>
	<BR>
	<logic:equal name="ISLOGINED" value="tea">
		<u><font size="3" face="MS Sans Serif"><b>Navigation</b></font></u>

		<ul><li><html:link page="/teaEntry.do?forward=teaInfo"><bean:message bundle="labels" key="teacher.menu.modifyInfo"/></html:link></li></ul>
		<ul><li><html:link  page="/teaEntry.do?forward=subPre"><bean:message bundle="labels" key="teacher.menu.submitSubject"/></html:link></li></ul>
		<ul><li><html:link  page="/teaEntry.do?forward=showMySub"><bean:message bundle="labels" key="teacher.menu.showMySub"/></html:link></li></ul>
		<ul><li><html:link  page="/teaEntry.do?forward=showAllSub"><bean:message bundle="labels" key="teacher.menu.showAllSub"/></html:link></li></ul>
		<ul><li><html:link  page="/teaEntry.do?forward=zdPre"><bean:message bundle="labels" key="teacher.menu.ZD"/></html:link></li></ul>
		<ul><li><html:link  page="/teaEntry.do?forward=censorReport"><bean:message bundle="labels" key="teacher.menu.CensorReport"/></html:link><html:errors property="no"/></li></ul>
		<ul><li><html:link  page="/teaEntry.do?forward=logout"><bean:message bundle="labels" key="teacher.menu.logout"/></html:link></li></ul>
		<logic:equal name="TEACHERBEAN" property="roleName" value="�鳤">
			<HR><ul><li><html:link  page="/teaEntry.do?forward=dbPre"><bean:message bundle="labels" key="teacher.menu.DB"/></html:link></li></ul>
				<ul><li><html:link  page="/teaEntry.do?forward=pyPre"><bean:message bundle="labels" key="teacher.menu.PY"/></html:link></li></ul>
		</logic:equal>
		<logic:equal name="TEACHERBEAN" property="roleName" value="����">
			<HR><ul><li><html:link  page="/teaEntry.do?forward=dbPre"><bean:message bundle="labels" key="teacher.menu.DB"/></html:link></li></ul>
				<ul><li><html:link  page="/teaEntry.do?forward=pyPre"><bean:message bundle="labels" key="teacher.menu.PY"/></html:link></li></ul>
		</logic:equal>
		<logic:equal name="TEACHERBEAN" property="roleName" value="����">
			<HR><ul><li><html:link  page="/teaEntry.do?forward=pyPre"><bean:message bundle="labels" key="teacher.menu.PY"/></html:link></li></ul>
		</logic:equal>
		<logic:equal name="TEACHERBEAN" property="consultTag" value="true">
			<HR><ul><li><html:link page="/teaEntry.do?forward=psPre"><bean:message bundle="labels" key="teacher.menu.PS"/></html:link><html:errors property="notPS"/></li></ul>
		</logic:equal>
</logic:equal>
<logic:equal name="ISLOGINED" value="adm">
		<a href="/adm/user_reg.jsp">ע��</a>
		<a href="/adm/adm_pwd_modify.jsp">�޸ı�����Ϣ</a>
		<a href="/adm/others_info_modify.jsp">�޸�������Ϣ</a>
		<a href="/adm/ShowSubject.do?nowPage=1">�������</a>
		<a href="/adm/news_publish.jsp">��Ϣ����</a>
		<a href="/adm/stu_change_subject.jsp">ѧ������</a>
		<a href="/logout.do">ע��</a>
</logic:equal>
		
		</body>
</html>

