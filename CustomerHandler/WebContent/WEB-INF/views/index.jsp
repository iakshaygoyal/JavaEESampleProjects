<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<h2>Customer Handler</h2>
	<h3><a href="new">New Customer</a></h3>
	<table border="1" cellpadding = "5">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Action</th>
		</tr>
		<c:forEach items = "${customers}" var = "customer">
		
		<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.address}</td>
			<td>
				<a href = "edit?id=${customer.id}">Edit</a>
				&nbsp;&nbsp;
				<a href = "delete?id=${customer.id}">Delete</a>
			</td>
		</tr>
		
		</c:forEach>
	</table>
</div>
</body>
</html>