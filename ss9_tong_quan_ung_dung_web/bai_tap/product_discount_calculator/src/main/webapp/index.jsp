<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/12/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Product Discount Calculator</h2>
  <form method="post" action="/display-discount">
    <label>Product Description: </label><br/>
    <input type="text" name="Product-Description" placeholder="Mô tả của sản phẩm"/><br/>
    <label>List Price </label><br/>
    <input type="number" name="List-Price" placeholder="Giá niêm yết của sản phẩm" /><br/>
    <label>Discount Percent </label><br/>
    <input type="number" name="Discount-Percent" placeholder="Tỷ lệ chiết khấu (phần trăm)" /><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
  </form>
  </body>
</html>
