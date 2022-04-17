<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admins
  Date: 4/14/2022
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped"  >
    <tr>
        <td scope="col">ID</td>
        <td scope="col">Name Product</td>
        <td scope="col">Price Product</td>
        <td scope="col">Description</td>
        <td scope="col">manufacturer</td>
        <td scope="col">Edit</td>
        <td scope="col">Delete</td>
    </tr>
    <c:forEach items='${products}' var="products">
        <tr>
            <td scope="col">${products.getId()}</td>
            <td scope="col">${products.nameProduct}</td>
            <td scope="col">${products.priceProduct}</td>
            <td scope="col">${products.description}</td>
            <td scope="col">${products.manufacturer}</td>
            <td scope="col" class="badge badge-secondary" ><a href="/product?action=edit&id=${products.getId()}">edit</a></td>
            <td scope="col">
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter"
                        onclick="deleteProduct(${products.getId()})" >
                    delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog"
                     aria-labelledby="exampleModalCenterTitle"
                     aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn xoá sản phẩm này
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <form method="post" >
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="id" id="idDelete">
                                    <button type="submit" class="btn btn-danger">Xác nhận xoá</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>

        </tr>
    </c:forEach>
</table>
<p>
    <button type="button" onclick="location.href='/product?action=create';" class="csw-btn-button">Create new product</button>
</p>

<form class="form-inline my-2 my-lg-0" action="/product">
    <input type="hidden" name="action" value="search">
    <input class="form-control mr-sm-2" name="name" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0"  type="submit">Search</button>
</form>








<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
<script>
    function deleteProduct(id) {
        document.getElementById("idDelete").value = id;
    }
</script>
</body>
</html>
