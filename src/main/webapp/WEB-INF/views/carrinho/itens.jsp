<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
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
				<form action="${s:mvcUrl('CCC#remover').arg(0, item.produto.id).arg(1, item.tipoPreco).build()}" method="POST">
					<input type="image" src="${contextPath}/resources/imagens/excluir.png"
					alt="Excluir" title="Excluir">
				</form>
			</td>
			
		</tr>
	</c:forEach>

				<form action="${s:mvcUrl('PC#finalizar').build()}" method="POST">
					<input type="submit" name="checkout" value="Finalizar compra">
				</form>

</body>
</html>