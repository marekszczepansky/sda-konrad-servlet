<%--
  Created by IntelliJ IDEA.
  User: saram
  Date: 2019-03-09
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<%@include file="menu.jspf"%>
<h2>Edit user</h2>
<div class="user-details">
    <form action="doEdit" method="post">
        <input type="hidden" name="id" value="${user.id}">
        <label>Name: <br>
            <input type="text" name="name" value="${user.name}">
        </label> <br>
        <label>Surname: <br>
            <input type="text" name="surname" value="${user.surname}">
        </label> <br>
        <label>Email: <br>
            <input type="email" name="email" value="${user.email}">
        </label> <br>
        <label>Age: <br>
            <input type="number" name="name" value="${user.age}">
        </label> <br>
        <button type="submit">Save</button>
        <button type="reset">Reset</button>
        <button type="submit">Delete</button>
    </form>
</div>
<%@include file="footer.jspf"%>
</body>
</html>
