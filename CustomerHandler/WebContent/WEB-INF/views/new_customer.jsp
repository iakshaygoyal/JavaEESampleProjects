<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<h2>New Customer</h2>
		<form:form action="save" method = "post" modelAttribute="customer">
			<table>
				<tr>
					<td>Name : </td>
					<td><form:input path="name"/></td>
				</tr>
				<tr>
					<td>Email : </td>
					<td><form:input path="email"/></td>
				</tr>
				<tr>
					<td>Address : </td>
					<td><form:input path="address"/></td>
				</tr>
				<tr>
					<td><input type="submit" value = "Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>