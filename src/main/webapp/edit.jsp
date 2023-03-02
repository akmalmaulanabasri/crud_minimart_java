<%@page import="com.minimart.repository.Repository"%>
<%@page import="com.minimart.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<%
	Repository repo = new Repository();
	Product edit = repo.edit(request.getParameter("id"));
	int price = (int) edit.getPrice();
%>
		
	<div class="container mt-3">
	<form class="form-group" method="post" action="minimart.do?action=update-product">
	<input type="text" name="code" placeholder="Code" class="form-control" value="<%out.println(edit.getCode());%>" readonly>
	<br/>
	<input type="text" name="name" placeholder="Name" class="form-control" value="<%out.println(edit.getName());%>">
	<br/>
	<input type="text" name="type" placeholder="Type" class="form-control" value="<%out.println(edit.getType());%>">
	<br/>
	<input type="text" name="price" placeholder="Price" class="form-control" value="<%out.println(price);%>">
	<br/>
	<input class="btn btn-warning" type="submit" value="Ubah">
	</form>
	<br/>
	<a class="btn btn-info" href="minimart.do">Data Produk</a>
	</div>
</body>
</html>