<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"   %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Products</title>
    </head>
	<body>
        <table style="width:100%">
            <tr>
				<th align="left">Code</th>
				<th align="left">Name</th>
				<th align="left">Description</th>
				<th align="left">Buy Price</th>
				<th align="left">Sell Price</th>
				<th align="left">Qty In Stock</th>
				<th align="left">Actions</th>
            </tr>
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.name}</td>
                    <td>${product.description}</td>
                    <td>${product.buyPrice}</td>
                    <td>${product.sellPrice}</td>
                    <td>${product.quantityInStock}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>