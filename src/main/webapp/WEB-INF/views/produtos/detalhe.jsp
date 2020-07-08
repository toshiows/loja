<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalhe do produto</title>
</head>
<body>
	<img src="<c:url value="${produto.arquivoPath}"/>"/>
	<h2>${produto.nome} ${produto.marca}</h2>
	<p>${produto.descricao}</p>
 	<form action="carrinho/add" method="post">
		<input type="hidden" value="${produto.id}" name="id" />
		<ul>
		<c:forEach items="${produto.precos}" var="precos">
			<li>
				<input type="radio" name="tipoPreco" value="${precos.tipoPreco}" checked="checked">
				<label>${precos.tipoPreco}</label>
				<p>${precos.preco}</p>
			</li>
		</c:forEach>
		</ul>
		<button type="submit" title="Compraragora">Comprar</button>
 	</form>
</body>
</html>