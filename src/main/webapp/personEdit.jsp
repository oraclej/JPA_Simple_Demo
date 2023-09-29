<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="pedit" method="post">
    <input type="hidden" name="id" value="${person.id}"><br>
    <input type="text" name="name" placeholder="Name" value="${person.name}"><br>
    <input type="number" name="age" placeholder="Age" value="${person.age}"><br>
    <input type="submit" value="Edit">
</form>

</body>
</html>