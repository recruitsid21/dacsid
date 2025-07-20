<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Event Registration</title>
</head>
<body>

    <h2>Register for Event</h2>

    <c:if test="${not empty msg}">
        <div style="color: green;">${msg}</div>
    </c:if>

    <form action="/register" method="post">
        Name: <input type="text" name="name" required /><br><br>
        Email: <input type="email" name="email" required /><br><br>

        Event:
        <select name="eventName">
            <c:forEach var="event" items="${events}">
                <option value="${event}">${event}</option>
            </c:forEach>
        </select><br><br>

        <input type="submit" value="Register" />
    </form>

    <br>
    <a href="/participants">View Participants</a>

</body>
</html>
