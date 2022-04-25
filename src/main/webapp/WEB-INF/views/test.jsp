<!--Copyright (c) 2020 Mark Crowe <https://github.com/markcrowe-com>. All rights reserved.-->
	<%@page import="com.example.springbootsecurity.meta.SitePaths"%>
	<!DOCTYPE html>
	<html>
		<head>
			<title>Product Catalog</title>
			<meta charset="UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0">
		</head>
		<body>
			<header>
				<h1>Product Catalog (Java Web 8)</h1>
			</header>
			<nav>
				<ul>
					<li><a href="<%=request.getContextPath()%>">Home</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.LOGIN%>">Login</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.LOGOUT%>">Logout</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.HANDLE_PRODUCT_DELETE%>/code">Handle Product Delete</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.PRODUCT_ADD%>">Product Add</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.PRODUCTS%>">Products</a></li>
					<li><a href="<%=request.getContextPath() + SitePaths.TEST%>">Test</a></li>
					<li><a href="<%=request.getContextPath() + "/api/basic/products/"%>">REST API</a></li>
					<li><a href="<%=request.getContextPath() + "/api/products/"%>">HATEOAS API</a></li>
				</ul>
			</nav>
		</body>
	</html>
