<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VCOM
  Date: 22/06/2020
  Time: 11:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<p>
    <c:if test="${requestScope['message']!=null}">
        <span class="message">${requestScope['message']}</span>
    </c:if>
</p>

<p>
    <a href="/products">Back to product list</a>
</p>

<form method="post">
    <fieldset>
        <legend>Product Information</legend>
        <table>
            <tr>
                <th>Name:</th>
                <td><input type="text" name="name" id="name" value="${requestScope['product'].getProductName()}"></td>
            </tr>
            <tr>
                <th>Description:</th>
                <td><input type="text" name="description" id="description" value="${requestScope['product'].getDescription()}"></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="text" name="price" id="price" value="${requestScope['product'].getProductPrice()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
