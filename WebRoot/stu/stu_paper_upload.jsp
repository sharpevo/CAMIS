<%@ page language="java" pageEncoding="GBK" errorPage="error.jsp"%>
<%@ include file="include.jspf"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>My JSP 'stu_paper_upload.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <link rel="stylesheet" type="text/css" href="../css/style.css">
  </head>
  <body>
  <%@include file="top.jspf"%>
		<div id="warpper">
			<a name="top" />
				<div id="maincontent">
				<div id="register">
    <br>
    <form action="/stu/StuPaperUpload.do" method="post" enctype="multipart/form-data">
    请选择你要上传的文件：
    <input type="file" name="stuPaper"/>
    <input type="submit" value="Upload"/>
    </form>
    </div>
	</div>
						</div>
						<%@include file="footer.jspf"%>
						
												</div>
  </body>
</html>
