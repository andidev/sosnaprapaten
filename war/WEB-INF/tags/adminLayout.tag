<%@ tag isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="k5" tagdir="/WEB-INF/tags" %>
<%@ tag import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ tag import="naprapat.entities.GlobalSettings" %>

<%
	String logoutUrl = UserServiceFactory.getUserService().createLogoutURL("/");

	Long globalSettingsId = GlobalSettings.findOrCreate().getId();
%>

<!DOCTYPE html>
<html>
	<head>
		<title>Naprapatadmin</title>
		<link rel="stylesheet" type="text/css" media="screen" href="/css/admin.css">
		<meta name="gwt:property" content="locale=sv">

		<k5:javascriptEnvironment/>
		<k5:javascript-all/>
	</head>
	<body>
		
		<jsp:doBody/>

	</body>
</html>
