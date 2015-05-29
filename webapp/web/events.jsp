<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Events</title>
</head>
<body>

Welcome, ${login} !
<form action="magic" method="post">
    <input type="hidden" name="command" value="signout"/>
    <input type="submit" value="Sign out"/>
</form>

<a href="welcome.jsp">Home</a>

<form method="post" action="choice">
    <table>
        <tr>
            <td>
                Name
            </td>

            <td>
                Cost
            </td>

            <td>
                Description
            </td>

            <td>
                Tag
            </td>

            <td>

            </td>
        </tr>

        <%--First event--%>
        <tr>
            <td>
                <input type="text" readonly name="name" value="JazzCon"/>
            </td>

            <td>
                <input type="text" readonly name="cost" value="100.0"/>
            </td>

            <td>
                <input type="text" readonly name="description" value="Best Jazz party"/>
            </td>

            <td>
                <input type="text" readonly name="tag" value="jazz"/>
            </td>

            <td>
                <input type="hidden" name="type" value="Concert"/>
                <input type="checkbox" name="isChecked" value="0"/>
            </td>
        </tr>

        <%--Second event--%>
        <tr>
            <td>
                <input type="text" readonly name="name" value="Drawing for love"/>
            </td>

            <td>
                <input type="text" readonly name="cost" value="50.0"/>
            </td>

            <td>
                <input type="text" readonly name="description" value="Relax"/>
            </td>

            <td>
                <input type="text" readonly name="tag" value="drawing"/>
            </td>

            <td>
                <input type="hidden" name="type" value="MasterClass"/>
                <input type="checkbox" name="isChecked" value="1"/>
            </td>
        </tr>

        <%--Third event--%>
        <tr>
            <td>
                <input type="text" readonly name="name" value="Something"/>
            </td>

            <td>
                <input type="text" readonly name="cost" value="70.0"/>
            </td>

            <td>
                <input type="text" readonly name="description" value="BEST LECTURE EVER"/>
            </td>

            <td>
                <input type="text" readonly name="tag" value="brain"/>
            </td>

            <td>
                <input type="hidden" name="type" value="Lecture"/>
                <input type="checkbox" name="isChecked" value="2"/>

            </td>
        </tr>
    </table>

    <input type="submit" value="submit"/>
</form>
</body>
</html>
