<%@ page language="java" pageEncoding="GBK" %>
<%@ include file="include.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҵ��ƹ�����Ϣϵͳ�Dѧ��ѡ��</title>

<link href="../css/style.css" rel="stylesheet" type="text/css" />

</head>

<body>
<%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				
   <%							
			List subject_list = (List)request.getAttribute(MisConstants.SUBJECTLIST_KEY);		
			Integer totalpage=(Integer)request.getAttribute(MisConstants.TOTALPAGE_KEY);
			Iterator i1=subject_list.iterator();
			int nowPage=(Integer)request.getAttribute(MisConstants.NOWPAGE_KEY);
			int nextpage=nowPage+1;
			if(nextpage>totalpage) nextpage=totalpage;
			int prevpage=nowPage-1;
			if(prevpage<=0)prevpage=1;
   %>
<table cellspacing="0" cellpadding="0" border="0" width="60%" align="center">
   	<tr>
		<td align="center" class="title1">�ɼ���ѯ</td>
	</tr>
</table>
<br />
<table cellspacing="0" cellpadding="0" border="0" width="80%" align="center">
   	<tr>
		<td width="37%">ѧ���ɼ���ѯ</td>
	</tr>
</table>

<table cellspacing="2" cellpadding="0" border="0" width="80%" align="center">
<tr>
<td width="8%" align="center" bgcolor="#ECDDAE"><span class="STYLE1">�༶</span></td>
<td width="13%" align="center" bgcolor="#ECDDAE"><span class="STYLE1">ѧ��</span></td>
<td width="31%" align="center" bgcolor="#ECDDAE" class="STYLE1">��ҵ�����Ŀ</td>
<td width="10%" align="center" bgcolor="#ECDDAE" class="STYLE1">�ɼ�</td>
<td width="9%" align="center" bgcolor="#ECDDAE" class="STYLE1">�ȼ�</td>
<td width="13%" align="center" bgcolor="#ECDDAE" class="STYLE1">�Ƿ�У��</td>
</tr>
<%
     while(i1.hasNext())
     {
       SubjectInfo subject=(SubjectInfo)i1.next();
 %>
 <tr><td><%=subject.getStudentId().substring(0,subject.getStudentId().length()-2) %></td>
  <td><%=subject.getStudentId()%> </td>
 <td><%=subject.getSubject()%></td>
 <td><%=subject.getMark() %></td>
 <td><%=subject.getMarkGrade() %></td>
<td><%
if(subject.getExcellentTag()) out.println("��");
else
out.println("��"); %></td></tr>
  <%
 }
 %>
</table>
<br />
<form action="/jwy/JwyQuery.do" method="post">
		<table cellspacing="0" cellpadding="0" border="0" width="80%"
			align="center">
			<tr align="center">
				<td>
					<a href="/jwy/JwyQuery.do?nowpage=<%=prevpage %>">��һҳ</a>&nbsp;&nbsp;<a href="/jwy/JwyQuery.do?nowpage=<%=nextpage %>">��һҳ</a>&nbsp;&nbsp;<a href="/Jwy/JwyQuery.do?nowpage=<%=totalpage %>">���һҳ</a>&nbsp;&nbsp;��
					<select name="nowpage">
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
 </div>
						</div>
						<%@include file="footer.jspf"%>
						</div>
</body>
</html>
