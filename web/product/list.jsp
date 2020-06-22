<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VCOM
  Date: 22/06/2020
  Time: 11:13 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Product</title>
</head>
<body>
<h1>Product list</h1>
<p>
    <a href="/products?action=create">Create new product</a>
</p>
<table border="1" style="border-collapse: collapse">
    <tr>
        <th>Product Name</th>
        <th>Product Description</th>
        <th>Product Price</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    <c:forEach items="${requestScope['products']}" var="product">
        <tr>
            <td>${product.getProductName()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getProductPrice()}</td>
            <td><a href="/products?action=edit&id=${product.getProductId()}"><button type="button">Edit</button></a></td>
            <td><a href="/products?action=delete&id=${product.getProductId()}"><button type="button">Delete</button></a></td>
            <td><a href="/products?action=view&id=${product.getProductId()}"><button type="button">View</button></a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
