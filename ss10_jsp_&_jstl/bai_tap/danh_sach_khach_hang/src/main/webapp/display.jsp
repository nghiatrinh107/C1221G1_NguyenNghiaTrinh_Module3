<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/13/2022
  Time: 9:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Danh Sách Khách Hàng</h1>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Tên</th>
        <th scope="col">Ngày Sinh</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Ảnh</th>
    </tr>
    </thead>
    <c:forEach var="customer" items = "${customers}">
    <tr>
        <td>${customer.getName()}</td>
        <td>${customer.getDob()}</td>
        <td>${customer.getAddress()}</td>
        <td><img src="${customer.getImg()}" style="width: 100px;height: 100px"></td>
    </tr>
    </c:forEach>
</table>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
