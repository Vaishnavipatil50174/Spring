<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <h2>User Details</h2>

    <p>First Name: <%= request.getAttribute("user") != null ? ((org.example.model.User)request.getAttribute("user")).getFirstName() : "" %></p>
    <p>Last Name: <%= request.getAttribute("user") != null ? ((org.example.model.User)request.getAttribute("user")).getLastName() : "" %></p>
</body>
</html>
