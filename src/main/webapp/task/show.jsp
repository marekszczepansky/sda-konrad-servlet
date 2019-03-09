<%--
  Created by IntelliJ IDEA.
  User: saram
  Date: 2019-03-09
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sda.javapoz12.domain.User" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    User getUser(HttpServletRequest request){
        return (User) request.getAttribute("User");
    }
%>
<%
    User user = getUser(request);
%>

    Twój adres IP to: <%= request.getRemoteAddr() %><br><br>
<%
    if (user != null) {
%>

    Name: <%= user.getName() %><br>
    Surname: <%= user.getSurname() %><br>
    Useremail: <%= user.getEmail() %><br>
    Age: <%= user.getAge() %><br>
<%
    } else {
%>
    <b>User does not exist</b>
<%
    }
%>

</body>
</html>
