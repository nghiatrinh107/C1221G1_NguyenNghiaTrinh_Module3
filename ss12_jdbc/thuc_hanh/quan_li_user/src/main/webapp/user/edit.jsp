<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/17/2022
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit User</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/">Back to User list</a>
</p>
<form method="post">
    <fieldset>
        <legend>User information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${user.name}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" id="email" value="${user.email}"></td>
            </tr>
            <tr>
                <td>Country: </td>
                <td><input type="text" name="country" id="country" value="${user.country}"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Update"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
