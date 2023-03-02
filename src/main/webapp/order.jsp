<%@page import="com.minimart.domain.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.minimart.repository.Repository"%>
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
	<div class="container mt-3">
		<a href="?action=home" class="btn btn-danger">Kembali</a>
		<div class="card mt-2">
			<form method="post" action="?action=order-post">
				<table class="table">
					<tr>
						<th>Nama Produk</th>
						<th>Harga</th>
						<th>Jumlah Pesan</th>
					</tr>
					<%
					Repository repo = new Repository();
					ArrayList<Product> products = repo.findAll();
					for (int i = 0; i < products.size(); i++) {
					%>
					<tr>
						<td><input type="text"
							value="<%out.println(products.get(i).getName());%>"
							class="form-control" readonly></td>
						<td><input type="text"
							value="Rp<%out.println(products.get(i).getPrice());%>"
							class="form-control" readonly></td>
						<td><input type="text"
							name="<%= products.get(i).getCode() %>"
							class="form-control"></td>
					</tr>
					<%
					}
					%>

				</table>
				<div class="d-flex justify-content-center my-3">
					<button type="submit" class="btn btn-success">Pesan</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>