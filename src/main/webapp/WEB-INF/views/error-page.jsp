<!--Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.-->
	<%@page import="com.example.springbootsecurity.SitePaths"%>
	<!DOCTYPE html>
	<html>
		<head>
			<title>Product Catalog</title>
		</head>
		<body>
			<header>
				<h1>Product Catalog (Java Web 8)</h1>
			</header>
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>">Home</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.PRODUCTS%>">All Products</a></li>
						<security:authorize access="hasAnyRole('SuperAdmin')">
						<li><a href="<%=request.getContextPath() + SitePaths.PRODUCT_ADD%>">Add Product</a></li>
						</security:authorize>
				</ul>
			</nav>
			<main>
				<h2>An error has occurred.</h2>
				<p>URL: ${url}</p>
				<p>${exception.message}</p>
			</main>
		</body>
	</html>