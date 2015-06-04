<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="reg" method="post">
    <label>
        Login
        <input type="text" name="login"/>
    </label>
    <label>
        Password
        <input type="password" name="pass1"/>
    </label>
    <label>
        Retype Password
        <input type="password" name="pass2"/>
    </label>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
