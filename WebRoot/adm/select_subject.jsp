
<%@ page language="java"  pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf" %>
<html:html>
	<head>
		<title>毕业设计管理信息系统―浏览课题</title>

		<link href="../css/style.css" rel="stylesheet" type="text/css" />
	</head>

	<body>
	<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
	<html:javascript formName="AddNewSubjectForm"/> 
		<%				
			List sourcelist=(List)request.getAttribute(MisConstants.SOURCELIST_KEY);
			List typelist=(List)request.getAttribute(MisConstants.TYPELIST_KEY);
			List propertylist=(List)request.getAttribute(MisConstants.PROPERTYLIST_KEY);
			List fieldlist=(List)request.getAttribute(MisConstants.FIELDLIST_KEY);
			List subjectList = (List) request.getAttribute(MisConstants.SUBJECTLISTPAGING_KEY);
			List teacherlist=(List)request.getAttribute(MisConstants.TEACHERLIST_KEY);
			List majorlist=(List)request.getAttribute(MisConstants.MAJORLIST_KEY);
			String studentId=(String)request.getAttribute("studentId");
			Iterator i1=fieldlist.iterator();
			Iterator i2 = subjectList.iterator();
			Iterator i3=teacherlist.iterator();
			Iterator i4=sourcelist.iterator();
			Iterator i5=typelist.iterator();
			Iterator i6=propertylist.iterator();
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
		<form action="/adm/showSubjectNBySort.do" method="post">
		<p> 分类浏览</p>
		<table cellspacing="0" cellpadding="0" border="0" width="80%"
			align="center">
			<tr>
				<td>
					<input type="radio" name="sortname" value="teacherId" checked/>按教师&nbsp;&nbsp;
					<select name="teacherId">
						<option value="">
							--请选择教师--
						</option>
						<%
						  while(i3.hasNext())
						  {
						    TeacherInfo teacher=(TeacherInfo)i3.next();
						    out.println("<option value='"+teacher.getTeacherId()+"'>"+teacher.getTeacherName()+"</option>");
						  }
						 %>
					</select>
				</td>
				<td>
					<input type="radio" name="sortname" value="difficulty"/>按难度&nbsp;&nbsp;
					<select name="difficulty">
						<option value="">
							--请选择难度--
						</option>
						<option value="A">难题——A</option>
					    <option value="B">中等——B</option>
					    <option value="C">简单——C</option>					    
					</select>
				</td>
				<td>
					<input type="radio" name="sortname" value="fieldName"/>按方向&nbsp;&nbsp;
					<select name="fieldName">
						<option value="">
							--请选择方向--
						</option>
						<%
						while(i1.hasNext())
						{
						  FieldInfo field=(FieldInfo)i1.next();
						  out.println("<option value='"+field.getField()+"'>"+field.getField()+"</option>");
						}
						%>
					</select>
				</td>
				<td><input type="hidden" name="studentId" value="<%=studentId%>"/></td>
				<td><input type="submit" value="搜索"/></td>
			</tr>
		</table>
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
				<td width="20%" align="center" bgcolor="#ECDDAE">
					<span class="STYLE1">选题</span>
				</td>								
			</tr>
			<%
				while (i2.hasNext())

				{
					SubjectInfo subject = (SubjectInfo) i2.next();
					out.println("<tr><td><a href='/adm/ShowSubjectDetail.do?subjectId=" + subject.getSubjectId() +"'>" + subject.getSubjectId() + "</a></td>");
					out.println("<td>" + subject.getSubject() + "</td>");
					out.println("<td><a href='/adm/ShowTeacherInfo.do?teacherId="+subject.getTeacherAId()+"'>" + subject.getTeacherAId() + "</a></td>");				
					out.println("<td><a href='/adm/changeSubject.do?subjectId="+subject.getSubjectId()+"&studentId="+studentId+"'>"+"换 题</a></td></tr>");			
				}
			%>
		</table>
		<br />
		<form action="/adm/ShowSubjectN.do" method="post">
		<table cellspacing="0" cellpadding="0" border="0" width="80%"
			align="center">
			<tr align="center">
				<td>
				<a href="/adm/ShowSubjectN.do?nowPage=<%=prevpage %>">上一页</a>&nbsp;&nbsp;<a href="/adm/ShowSubjectN.do?nowPage=<%=nextpage %>">下一页</a>&nbsp;&nbsp;当前第<%=nowPage%>页，<a href="/adm/ShowSubjectN.do?nowPage=<%=totalpage %>">最后一页</a>&nbsp;&nbsp;第
					<select name="nowPage" value=<%=nowPage%>>
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
		<html:form action="/adm/AddNewSubject.do" method="post" onsubmit="return validateAddNewSubjectForm(this);">
		<table cellspacing="2" cellpadding="0" border="0" width="80%"
			align="center">
			<tr>
				<td>
					<div align="center">
						<span class="STYLE2">添加课题</span>
					</div>
				</td>
			</tr>
		</table>
		<html:errors/>
		<table cellspacing="0" cellpadding="0" width="60%" align="center"
			border="1">
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						题&nbsp;&nbsp;目:
					</div>
				</td>
				<td width="70%" class="biaoge_out"><input name="subject"/>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						指导教师:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="teacherAid">					
						<%
						  Iterator i8=teacherlist.iterator();
						  while(i8.hasNext())
						  {
						    TeacherInfo teacher=(TeacherInfo)i8.next();
						    out.println("<option value='"+teacher.getTeacherId()+"'>"+teacher.getTeacherName()+"</option>");
						  }
						 %>											
					</select>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						难&nbsp;&nbsp;度:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="difficulty">
						
						<option value="A">难题——A</option>
					    <option value="B">中等——B</option>
					    <option value="C">简单——C</option>	
					</select>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						类&nbsp;&nbsp;型:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="typeName">						
						<%
				while (i5.hasNext())

				{
					TypeInfo type = (TypeInfo) i5.next();
					out.println("<option value='"+type.getType()+"'>"+type.getType()+"</option>");
				}
			%>
					</select>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						性&nbsp;&nbsp;质:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="propertyName">
						<%
						while(i6.hasNext())
						{
						  PropertyInfo property=(PropertyInfo)i6.next();
						  out.println("<option value='"+property.getPropertyId()+"'>"+property.getProperty()+"</option>");
						}
						 %>
					</select>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						方&nbsp;&nbsp;向:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="fieldName">
						<%
						Iterator i9=fieldlist.iterator();
						while(i9.hasNext())
						{
						  FieldInfo field=(FieldInfo)i9.next();
						  out.println("<option value='"+field.getField()+"'>"+field.getField()+"</option>");
						}
						%>					
					</select>
				</td>
			</tr>
			<tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						来&nbsp;&nbsp;源:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="sourceName">
						
						<%
						while(i4.hasNext())
						{
						  SourceInfo source=(SourceInfo)i4.next();
						  out.println("<option value='"+source.getSource()+"'>"+source.getSource()+"</option>");
						}
						 %>
						
					</select>
				</td>
			</tr>
		  <tr>
				<td width="30%" bordercolor="#FFFFFF" class="biaoge_info">
					<div align="center">
						专&nbsp;&nbsp;业:
					</div>
				</td>
				<td width="70%" class="biaoge_out">
					<select name="majorName">		
						<%
						  Iterator m=majorlist.iterator();
						  while(m.hasNext())
							{
							 MajorInfo major=(MajorInfo)m.next();
							 out.println("<option value='"+major.getMajorName()+"'>"+major.getMajorName()+"</option>");
							}
						%>				
					</select>
				</td>
			</tr>
		</table>
		<br />
		<table cellspacing="0" cellpadding="0" border="0" width="60%"
			align="center">
			<tr align="center">
				<td width="70%" bordercolor="#FFFFFF" class="biaoge_out">
					<input name="b2" type="submit" class="button1" value="确定"
						src="stu_reg.jsp" />
					&nbsp;&nbsp;
					<input name="b2" type="reset" class="button1" value="重置" />
				</td>
			</tr>
		</table>
		</html:form>
		
</div>
</div>
<%@include file="footer.jspf"%>
		</div>
	</body>
</html:html>

