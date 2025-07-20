<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registered Participants</title>
</head>
<body>

<h2>List of Registered Participants</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Event</th>
    </tr>

    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.email}</td>
            <td>${p.eventName}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="/">Go Back to Registration</a>

</body>
</html>
