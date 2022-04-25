<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Products</title>
    </head>
	<body>
		<header>
			<h1>Product Catalog (Java Spring)</h1>
			<security:authorize access="!isAuthenticated()">
				Welcome Guest, <a href="/login">Login</a>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				Welcome <security:authentication property="Principal.username"/>, <a href="/logout">Logout</a>
			</security:authorize>
		</header>
		<nav>
			<ul>
				<li><a href="/">Home</a></li>
				<li><a href="/products">All Products</a></li>
					<security:authorize access="hasRole('SuperAdmin')">
					<li><a href="/add-product">Add Product</a></li>
					</security:authorize>
			</ul>
		</nav>
		<main>
			<table style="width:100%">
				<tr>
					<th align="left">Code</th>
					<td>${product.code}</td>
				</tr>
				<tr>
					<th align="left">Name</th>
					<td>${product.name}</td>
				</tr>
				<tr>
					<th align="left">Description</th>
					<td>${product.description}</td>
				</tr>
				<tr>
					<th align="left">Buy Price</th>
					<td>${product.buyPrice}</td>
				</tr>
				<tr>
					<th align="left">Sell Price</th>
					<td>${product.sellPrice}</td>
				</tr>
				<tr>
					<th align="left">Qty In Stock</th>
					<td>${product.quantityInStock}</td>
				</tr>
			</table>
			<security:authorize access="hasAnyRole('Admin', 'SuperAdmin')">
				<a href="/edit-product/${product.code}">Edit</a>&nbsp;
				<a href="/delete-product/${product.code}">Delete</a>
			</security:authorize>
		</main>
    </body>
</html>