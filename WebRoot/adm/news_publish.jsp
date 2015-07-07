
<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="include.jspf" %>
<html:html>
<head>
	<title>毕业设计管理信息系统―填写任务书</title>
	<link href="../css/style.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
<!--
.STYLE1 {color: #A53D54}
-->
</style>
</head>

<body>
	<html:javascript formName="AddNotesForm" />
	<html:errors />
	<%@include file="top.jspf"%>
	<div id="warpper">
			<a name="top" /> 
				<div id="maincontent">
				<div id="register">
	<table cellspacing="0" cellpadding="0" border="0" width="70%"
		align="center">
		<tr>
			<td>
				<table cellspacing="0" cellpadding="0" border="0" width="100%"
					align="center">
					<tr>
						<td align="center" bgcolor="#FFFFFF" class="title2 STYLE1">
							信息发布
						</td>
					</tr>
				</table>
			    <html:errors />
				<html:form action="/adm/AddNotes.do" method="post"
					onsubmit="return validateAddNotesForm(this);">
					<table cellspacing="0" cellpadding="3" border="0" width="100%"
						align="center">							
						<tr>
							<td>
								NewsName:
								<input name="newsName" />
							</td>
						</tr>
						<tr>
							<td>
								majorName:
								<input name="majorName" />
							</td>
						</tr>
						<tr>
							<td>News Content
								<textarea name="news" class="input_text_long" rows=5 cols=20></textarea>
							</td>
						</tr>
						<tr>
							<td>
								<br />
								<table cellspacing="0" cellpadding="3" border="0" width="100%"
									align="center">
									<tr align="center">
										<td>
											<input name="b1" type="submit" class="button1" value="提交" />
											&nbsp;&nbsp;
											<input name="b2" type="reset" class="button1" value="关闭" />
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</html:form>
				 </div>	</div>						
					</div>
			
		<%@include file="footer.jspf"%>
		</div>
</body>
</html:html>
