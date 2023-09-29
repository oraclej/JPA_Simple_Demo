<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${personList}" var="person">
        <tr>
        <td>${person.id}</td>
        <td>${person.name}</td>
        <td>${person.age}</td>
        <td><a href="pedit?id=${person.id}">Edit Me</a></td>
        <td><a href="pdelete?id=${person.id}">Delete Me</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="personAdd.jsp">Add a Person</a></p>
</body>
</html>
