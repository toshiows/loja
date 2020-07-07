<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Produtos</title>
</head>
<body>
	<h1>Lista de produtos</h1>
	<div style="color: green;">${sucesso}</div>
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Marca</th>
			<th>Descrição</th>
		</tr>
		<c:forEach items="${produtos}" var="produto">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.nome}</td>
				<td>${produto.marca}</td>
				<td>${produto.descricao}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>