<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
    <h2>Enter User Details</h2>
    <form:form action="submitUser" modelAttribute="user" method="post">
        <table>
            <tr>
                <td>First Name:</td>
                <td><form:input path="firstName" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
