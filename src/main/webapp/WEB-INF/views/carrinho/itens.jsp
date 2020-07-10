<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Carrinho de compras</title>
</head>
<body>
	<c:forEach items="${carrinhoCompras.itens}" var="item">
		<tr>
			<td>${item.produto.nome}</td>
			<td>${item.preco}</td>
			<td>${carrinhoCompras.getTotal(item)}</td>
			<td>
				<form action="" method="POST">
					<input type="image" src="${contextPath}/resources/imagens/excluir.png"
					alt="Excluir" title="Excluir">
				</form>
			</td>
		</tr>
	</c:forEach>
</body>
</html>