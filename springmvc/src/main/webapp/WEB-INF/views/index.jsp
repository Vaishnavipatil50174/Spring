<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello Page</title>
</head>
<body>
    <h1>Hello from JSP!</h1>
    <%
        String name=(String)request.getAttribute("name");
    %>
    <h1>Name is <%=name%></h1>
</body>
</html>
