<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Preferences</title>
</head>
<body>

<c:if test="${!empty sessionScope.login}">
    Welcome, ${login} !

    <form action="magic" method="post">
        <input type="hidden" name="command" value="signout"/>
        <input type="submit" value="Sign out"/>
    </form>

    <a href="<c:url value="welcome.jsp"/>">Home</a>

    <table>

        <!--  -->
    <c:forEach var="pref" items="${preferences}">
        <tr><td>${pref}</td></tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>
