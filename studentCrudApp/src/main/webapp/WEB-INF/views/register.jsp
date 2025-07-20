<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register Student</title></head>
<body>
<h2>Register Student</h2>
<form action="/register" method="post">
    Name:  <input type="text" name="name"/><br/><br/>
    Email: <input type="email" name="email"/><br/><br/>
    Course:<input type="text" name="course"/><br/><br/>
    <input type="submit" value="Save"/>
</form>
<br/><a href="/students">View Students</a>
</body>
</html>
