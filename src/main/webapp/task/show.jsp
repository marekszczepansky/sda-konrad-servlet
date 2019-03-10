<%--
  Created by IntelliJ IDEA.
  User: saram
  Date: 2019-03-09
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="sda.javapoz12.domain.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Twój adres IP to: <%= request.getRemoteAddr() %><br>
<%
    if (request.getAttribute("User") != null) {
%>
        Name: ${User.name}<br>
        Surname: ${User.surname}<br>
        Useremail: ${User.email}<br>
        Age: ${User.age}<br>
<%
    } else {
%>
    <b>User does not exist</b>
<%
    }
%>

</body>
</html>
