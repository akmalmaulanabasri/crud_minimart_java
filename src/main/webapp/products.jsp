<%@page import="java.util.ArrayList"%>
<%@page import="com.minimart.repository.Repository"%>
<%@page import="com.minimart.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container mt-3">
	<a class="btn btn-info" href="?action=home">Home</a>
	<a class="btn btn-info" href="?action=create-product">Tambah Produk Baru</a>
	<table class="table">
	<tr>
		<th>Code</th>
		<th>Name</th>
		<th>Type</th>
		<th>Price</th>
		<th>Action</th>
	</tr>
	<%
		Repository repo = new Repository();
	 	ArrayList<Product> products = repo.findAll();
	 	for(int i = 0; i < products.size(); i++){
	 		%>
		<tr>
		<td><% out.println(products.get(i).getCode()); %></td>
		<td><% out.println(products.get(i).getName()); %></td>
		<td><% out.println(products.get(i).getType()); %></td>
		<td><% out.println(products.get(i).getPrice()); %></td>
		<td>
		<a href=?action=delete-product&id=<% out.println(products.get(i).getCode()); %>>Delete</a>
		<a href=?action=edit-product&id=<% out.println(products.get(i).getCode()); %>>Edit</a>
		</td>
		</tr>
	 		<%
	 	}
	%>
	
	
	</table>
	</div>
</body>
</html>