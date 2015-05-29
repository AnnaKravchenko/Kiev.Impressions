<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form method="post" action="magic">
    <label>Login:
        <input type="text" name="login"/>
    </label><br/>

    <label>Password:
        <input type="password" name="password"/>
    </label><br/>

    <input type="hidden" name="command" value="signin"/>

    <input type="submit" value="Sign in"/>
</form>
</body>
</html>
