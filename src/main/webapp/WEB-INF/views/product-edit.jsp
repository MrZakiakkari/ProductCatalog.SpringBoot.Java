<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
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
			<form:form modelAttribute="product">
				<table>
					<tr>
						<td><form:label path="code">Code</form:label></td>
						<td><form:input path="code"/></td>
						<td style="color:red"><form:errors path="code"/> </td>
					</tr>
					<tr>
						<td><form:label path="name">Name</form:label></td>
						<td><form:input path="name" /></td>
						<td style="color:red"><form:errors path="name"/> </td>
					</tr>
					<tr>
						<td><form:label path="description">Description</form:label></td>
						<td><form:input path="description"/></td>
						<td style="color:red"><form:errors path="description"/> </td>
					</tr>
					<tr>
						<td><form:label path="buyPrice">Buy Price</form:label></td>
						<td><form:input path="buyPrice"/></td>
						<td style="color:red"> <form:errors path="buyPrice"/> </td>
					</tr>
					<tr>
						<td><form:label path="sellPrice">Sell Price</form:label></td>
						<td><form:input path="sellPrice"/></td>
						<td style="color:red"> <form:errors path="sellPrice"/> </td>
					</tr>
					<tr>
						<td><form:label path="quantityInStock">Quantity In Stock</form:label></td>
						<td><form:input type="quantityInStock" path="quantityInStock"/></td>
						<td style="color:red"> <form:errors path="quantityInStock"/> </td>
					</tr>
					<tr>
						<td><input type="submit" value="Add Product"/></td>
					</tr>
				</table>
			</form:form>
		</main>
    </body>
</html>