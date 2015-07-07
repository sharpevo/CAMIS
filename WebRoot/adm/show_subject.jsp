
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>��ҵ��ƹ�����Ϣϵͳ�D�������</title>

		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
		<%							
			List fieldlist=(List)request.getAttribute(MisConstants.FIELDLIST_KEY);
			List subjectList = (List)request.getAttribute(MisConstants.SUBJECTLISTPAGING_KEY);
			List teacherlist=(List)request.getAttribute(MisConstants.TEACHERLIST_KEY);
			Iterator i1=fieldlist.iterator();
			Iterator i2 = subjectList.iterator();
			Iterator i3=teacherlist.iterator();	
			Integer totalpage=(Integer)request.getAttribute(MisConstants.TOTALPAGE_KEY);
			int nowPage=(Integer)request.getAttribute(MisConstants.NOWPAGE_KEY);
			int nextpage=nowPage+1;
			if(nextpage>totalpage) nextpage=totalpage;
			int prevpage=nowPage-1;
			if(prevpage<=0)prevpage=1;
		%>
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr>
				<td align="center" class="title1">
					�������
				</td>
			</tr>
		</table>
		<br />
		<form action="/adm/ShowSubjectBySort.do" method="post">
			<p>		�������</p>
		<table cellspacing="0" cellpadding="0" border="0" width="80%"
			align="center">
			
			<tr>
				<td>
					<input type="radio" name="sortname" value="teacherId" checked/>����ʦ&nbsp;&nbsp;
					<select name="teacherId">		
					    <option value="">--��ѡ���ʦ--</option>				
						<%
						  while(i3.hasNext())
						  {
						    TeacherInfo teacher=(TeacherInfo)i3.next();
						    out.println("<option  value='"+teacher.getTeacherId()+"'>"+teacher.getTeacherName()+"</option>");
						  }
						 %>
					</select>
				</td>
				<td>
					<input type="radio" name="sortname" value="difficulty"/>���Ѷ�&nbsp;&nbsp;
					<select name="difficulty">
					    <option value="">--��ѡ���Ѷ�--</option>
						<option  value="A">���⡪��A</option>
					    <option  value="B">�еȡ���B</option>
					    <option  value="C">�򵥡���C</option>					    
					</select>
				</td>
				<td>
					<input type="radio" name="sortname" value="fieldName"/>������&nbsp;&nbsp;
					<select name="fieldName">
					   <option value="">--��ѡ����--</option>
						<%
						while(i1.hasNext())
						{
						  FieldInfo field=(FieldInfo)i1.next();
						  out.println("<option  value='"+field.getField()+"'>"+field.getField()+"</option>");
						}
						%>
					</select>
				</td>
				<td>
				<input type="submit" value="����"/>
				</td>
			</tr>
		</table>
		</form>
		<table cellspacing="2" cellpadding="0" border="0" width="80%"
			align="center">
			<tr>
				<td width="10%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">���</span>
				</td>
				<td width="50%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">��Ŀ</span>
				</td>
				<td width="20%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">�����ʦ</span>
				</td>								
			</tr>
			<%
				while (i2.hasNext())

				{
					SubjectInfo subject = (SubjectInfo) i2.next();
					out.println("<tr><td><a href='/adm/ShowSubjectDetail.do?subjectId=" + subject.getSubjectId() +"'>" + subject.getSubjectId() + "</a></td>");
					out.println("<td>" + subject.getSubject() + "</td>");
					out.println("<td><a href='/adm/ShowTeacherInfo.do?teacherId="+subject.getTeacherAId()+"'>" + subject.getTeacherAId() + "</a></td></tr>");				
				}
			%>
		</table>
		<br />
		<form action="/adm/ShowSubject.do" method="post">
		<table cellspacing="0" cellpadding="0" border="0" width="80%"
			align="center">
			<tr align="center">
				<td>
					<a href="/adm/ShowSubject.do?nowPage=<%=prevpage %>">��һҳ</a>&nbsp;&nbsp;<a href="/adm/ShowSubject.do?nowPage=<%=nextpage %>">��һҳ</a>&nbsp;&nbsp;��ǰ��<%=nowPage %>ҳ��<a href="/adm/ShowSubject.do?nowPage=<%=totalpage %>">���һҳ</a>&nbsp;&nbsp;��
					<select name="nowPage">
						<%
						  int i=totalpage.intValue();
						  for (int j=1;j<=i;j++)
						  {
						   out.println("<option value='"+j+"'/>"+j+"</option>");
						  }
						 %>
					</select>
					ҳ
					<input type="submit" value="��ת" />
				</td>
			</tr>
		</table>
		</form>
		<br />
		</div>
</div>
<%@include file="footer.jspf"%>
		</div>
	</body>
</html>
