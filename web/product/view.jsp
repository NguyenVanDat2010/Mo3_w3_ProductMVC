<%--
  Created by IntelliJ IDEA.
  User: VCOM
  Date: 22/06/2020
  Time: 11:14 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>View product</h1>
<p><a href="/products">Back to product list</a></p>
<table>
    <tr>
        <th>Name:</th>
        <td>${requestScope["product"].getProductName()}</td>
    </tr>
    <tr>
        <th>Email:</th>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
    <tr>
        <th>Address:</th>
        <td>${requestScope["product"].getProductPrice()}</td>
    </tr>
</table>
</body>
</html>
