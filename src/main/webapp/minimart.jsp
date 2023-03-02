<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center mt-3">Welcome to minimart</h1>
	<div class="d-flex justify-content-center">
		<a class="btn btn-info mx-2" href="minimart.do?action=list-product">Data
			Produk</a> 
		<a class="btn btn-info mx-2" href="minimart.do?action=order-new">Order</a>
		<a class="btn btn-info mx-2" href="minimart.do?action=list-order">List
			Order</a>
	</div>

</body>
</html>