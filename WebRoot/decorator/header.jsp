<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<body>
<h1><font face="Arial" color=#000000 size=6><strong>Welcome to CAMIS!</strong></font></h1>
<BR>
<logic:present name="crumbs">
<app:showCrumbs name="crumbs" bundle="labels"/>
</logic:present>
</body>
</html>