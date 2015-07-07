
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>毕业设计管理信息系统―浏览课题</title>

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
					浏览课题
				</td>
			</tr>
		</table>
		<br />
		<form action="/adm/ShowSubjectBySort.do" method="post">
			<p>		分类浏览</p>
		<table cellspacing="0" cellpadding="0" border="0" width="80%"
			align="center">
			
			<tr>
				<td>
					<input type="radio" name="sortname" value="teacherId" checked/>按教师&nbsp;&nbsp;
					<select name="teacherId">		
					    <option value="">--请选择教师--</option>				
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
					<input type="radio" name="sortname" value="difficulty"/>按难度&nbsp;&nbsp;
					<select name="difficulty">
					    <option value="">--请选择难度--</option>
						<option  value="A">难题——A</option>
					    <option  value="B">中等——B</option>
					    <option  value="C">简单——C</option>					    
					</select>
				</td>
				<td>
					<input type="radio" name="sortname" value="fieldName"/>按方向&nbsp;&nbsp;
					<select name="fieldName">
					   <option value="">--请选择方向--</option>
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
				<input type="submit" value="搜索"/>
				</td>
			</tr>
		</table>
		</form>
		<table cellspacing="2" cellpadding="0" border="0" width="80%"
			align="center">
			<tr>
				<td width="10%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">编号</span>
				</td>
				<td width="50%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">题目</span>
				</td>
				<td width="20%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">出题教师</span>
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
					<a href="/adm/ShowSubject.do?nowPage=<%=prevpage %>">上一页</a>&nbsp;&nbsp;<a href="/adm/ShowSubject.do?nowPage=<%=nextpage %>">下一页</a>&nbsp;&nbsp;当前第<%=nowPage %>页，<a href="/adm/ShowSubject.do?nowPage=<%=totalpage %>">最后一页</a>&nbsp;&nbsp;第
					<select name="nowPage">
						<%
						  int i=totalpage.intValue();
						  for (int j=1;j<=i;j++)
						  {
						   out.println("<option value='"+j+"'/>"+j+"</option>");
						  }
						 %>
					</select>
					页
					<input type="submit" value="跳转" />
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
