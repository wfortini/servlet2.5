
<%@ attribute name="fontColor"  rtexprvalue="true"  required="true" %>

<%@ tag body-content="tagdependent" %>

<em><strong><font color="${fontColor}"><jsp:doBody/></font></strong></em>