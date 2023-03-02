<%@page import="com.minimart.domain.OrderItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.minimart.domain.Order"%>
<%@page import="com.minimart.repository.OrderRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Pesanan</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<%
	OrderRepository order = new OrderRepository();
	Order show = order.show(request.getParameter("id"));

	ArrayList<OrderItem> orders = order.getItems(show.getOrderNumber());
	%>

	<div class="container mt-5">
		<a href="?action=list-order" class="btn btn-danger">Kembali</a>
		<div class="card mt-3">
			<div class="card-body">
				<table class="table">
					<tr>
						<th>ORDER ID</th>
						<th>TOTAL HARGA</th>
						<th>TANGGAL</th>
					</tr>
					<tr>
						<th><%=show.getOrderNumber()%></th>
						<th><%=show.getTotalPrice()%></th>
						<th><%=show.getOrderDate()%></th>
					</tr>
				</table>

				<table class="table mt-5 table-striped">
					<tr>
						<th>Code</th>
						<th>Nama Barang</th>
						<th>Tipe</th>
						<th>Harga</th>
						<th>Jumlah</th>
						<th>Total Harga</th>
					</tr>
					<%
					for (int i = 0; i < orders.size(); i++) {
					%>
					<tr>
						<th><%=orders.get(i).getCode()%></th>
						<th><%=orders.get(i).getName()%></th>
						<th><%=orders.get(i).getType()%></th>
						<th><%=orders.get(i).getPrice()%></th>
						<th><%=orders.get(i).getQuantity()%></th>
						<th><%=orders.get(i).getTotalPrice()%></th>
					</tr>
					<%
					}
					%>
				</table>
			</div>
		</div>
	</div>

</body>
</html>