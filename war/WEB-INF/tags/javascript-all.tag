<%@tag import="com.google.appengine.api.utils.SystemProperty"%>
<%@tag import="java.util.StringTokenizer"%>
<%@tag import="java.io.FileInputStream"%>
<%@tag import="java.util.Properties"%>
<%@tag import="naprapat.utils.Environment"%>
<% 
	if (Environment.getInstance().isDevMode()) {
		Properties properties = new Properties();
	    properties.load(new FileInputStream(application.getRealPath("/js") + "/js.order.properties"));	    
	    StringTokenizer st = new StringTokenizer(properties.getProperty("js.order"), ",");

	    while (st.hasMoreTokens()) {
	    	%>
			<script type="text/javascript" src="/js/<%= st.nextToken() %>" charset="UTF-8"></script>
			<%
	    }
	}
%>
