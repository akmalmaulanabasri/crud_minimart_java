<%@page import="com.minimart.domain.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.minimart.repository.OrderRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Daftar Orderan</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<a class="btn btn-info" href="minimart.do?action=order-new">Order</a>
		<a class="btn btn-info" href="minimart.do?action=home">Home</a>
		<%
		OrderRepository order = new OrderRepository();
		ArrayList<Order> products = order.findAll();
		for (int i = 0; i < products.size(); i++) {
		%>
		<a
			href="?action=order-detail&id=<%=products.get(i).getOrderNumber()%>"
			class="card w-100 my-2 text-decoration-none text-dark">
			<div class="card-body">
				<%=products.get(i).getOrderNumber()%>
				-- Rp<%=products.get(i).getTotalPrice()%>
			</div>
		</a>
		<%
		}
		%>
	</div>
</body>
</html>