<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Edit Student</title></head>
<body>
<h2>Edit Student</h2>
<form action="/update" method="post">
    <input type="hidden" name="id" value="${student.id}"/>
    Name:  <input type="text" name="name"  value="${student.name}"/><br/><br/>
    Email: <input type="email" name="email" value="${student.email}"/><br/><br/>
    Course:<input type="text" name="course" value="${student.course}"/><br/><br/>
    <input type="submit" value="Update"/>
</form>
<a href="/students">Back</a>
</body>
</html>
