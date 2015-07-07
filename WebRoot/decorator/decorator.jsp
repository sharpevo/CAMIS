<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ include file="/WEB-INF/views/tea/includes/taglib.inc.jsp" %>
<html>
    <head>
        <title>
            <decorator:title default="{ Unknown Page - shouldn't see this, since
                                        pages should define title }" />
        </title>
        <html:base/>
        <link href="/cam/decorator/main.css" rel="stylesheet" type="text/css">
        <decorator:head />
        <script src="/cam/decorator/embed.js"></script>
    </head>
    <body onload="CurrentTime()" id="main">
   
    
        <table width="100%" height="100%">
            <tr>
                <td id="header" colspan="2">
                   <font face="Impact" color=#ffffff size=5>
                   Chang'an University Management Infomation System</font>
                </td>
            </tr>
            <tr>
                <td id="navigation" valign="top" width="20%">
                    <page:applyDecorator name="navigation" page="/decorator/navigation.jsp"/> 
                </td>
                <td>
                    <table width="100%" height="100%">
                        <tr>
                            <td id="crumb" valign="top" width="100%" colspan="2">
								<page:applyDecorator name="crumbs" page="/decorator/crumb.jsp"/> 
                            </td>
                        </tr><tr>
                        	<td id="pageTitle" colspan="1"><BR><BR><decorator:title/></td>
		    	            <td id="time" align="right" colspan="1" valign="bottom">&nbsp;</td>
		    	        </tr><tr>
		    	        	<td colspan="2"><HR></td>
                        </tr><tr>
                            <td id="body" align ="center" valign="top" height="100%" colspan="2">
                                <decorator:body/>
                            </td>
						</tr>
                    </table>
                </td>
              </tr><tr>
                  <td id="footer" colspan="2">
                  	<table width=100%><tr><td bgcolor=#3366cc height="3"></td></tr></table>
	                    <font face="Comic Sans MS" color=#000000 size=3><strong>&copy;</strong></font>
						<font face="Comic Sans MS">2007</font>
						<font face="Comic Sans MS" color=#0039b6 size=3><strong>C</strong></font><font face="Comic Sans MS" color=#c41200 size=3><strong>A</strong></font><font face="Comic Sans MS" color=#f3c518 size=3><strong>M</strong></font><font face="Comic Sans MS" color=#0039b6 size=3><strong>I</strong></font><font face="Comic Sans MS" color=#30a72f size=3><strong>S</strong></font>
	              </td>
            </tr>
        </table>
    </body>
</html>