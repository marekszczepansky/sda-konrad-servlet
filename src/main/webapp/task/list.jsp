<%@ page import="sda.javapoz12.domain.User" %>
<%@ page import="java.util.Collection" %><%--
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
<%@include file="menu.jspf" %>
<h2>Uses list</h2>
<%
    if (request.getAttribute("users") != null) {
        Collection<User> users = (Collection<User>) request.getAttribute("users");
        for (User user : users) {
%>
<div class="user-details">
    Name: <%=user.getName()%>
    Surname: <%=user.getSurname()%>
    Useremail: <%=user.getEmail()%>
    Age: <%=user.getAge()%>
    <a href="doTask?id=<%=user.getId()%>">Show</a>
    <a href="doEdit?id=<%=user.getId()%>">Edit</a>
</div>
<%
    }
} else {
%>
<b>User list is empty</b>
<%
    }
%>
<%@include file="footer.jspf" %>
</body>
</html>
