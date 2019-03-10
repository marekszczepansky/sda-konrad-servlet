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
<h2>User details</h2>
<%
    if (request.getAttribute("User") != null) {
%>
<div class="user-details">
        Name: ${User.name}<br>
        Surname: ${User.surname}<br>
        Useremail: ${User.email}<br>
        Age: ${User.age}<br>
</div>
<%
    } else {
%>
    <b>User does not exist</b>
<%
    }
%>
<%@include file="footer.jspf"%>
</body>
</html>
