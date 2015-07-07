<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>

 <layout:html>
	
	<table ><tr><td>
	<layout:tabs width="400">
		<layout:tab key="first.tab" width="50">First Page</layout:tab>
		<layout:tab key="second.tab" width="50"><%@include file="/tea/tabTeaInfo.jsp"%></layout:tab>
		<layout:tab key="third.tab" width="50"><%@include file="/tea/tabSubject.jsp"%></layout:tab>
	</layout:tabs>
	</td></tr></table>

 </layout:html>