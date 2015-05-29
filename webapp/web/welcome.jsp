<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

Welcome, ${login} !
<form action="magic" method="post">
    <input type="hidden" name="command" value="signout"/>
    <input type="submit" value="Sign out"/>
</form>

<a href="events.jsp">All events</a>
<a href="prefers.jsp">My events</a>
</body>
</html>
