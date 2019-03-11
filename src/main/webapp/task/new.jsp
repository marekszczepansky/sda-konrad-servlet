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
    <title>Nowy użytkownik</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<%@include file="menu.jspf"%>
<h2>New user</h2>
<div class="user-details">
    <form action="doTask" method="post">
        <label>Name: <br>
            <input type="text" name="name" placeholder="Enter name">
        </label> <br>
        <label>Surname: <br>
            <input type="text" name="surname" placeholder="Enter surname">
        </label> <br>
        <label>Email: <br>
            <input type="email" name="email" placeholder="Enter email">
        </label> <br>
        <label>Age: <br>
            <input type="number" name="age" placeholder="Enter age">
        </label> <br>
        <button type="submit">Create</button>
        <button type="reset">Reset</button>
    </form>
</div>
<%@include file="footer.jspf"%>
</body>
</html>
