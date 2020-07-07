<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de cadastro de produtos</title>
</head>
<body>
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" commandName="produto">
		<div>
			<label>Nome</label>
			<input type="text" name="nome"/>
			<form:errors path="nome" />
		</div>
		<div>
			<label>Marca</label>
			<input type="text" name="marca">
			<form:errors path="marca" />
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="5" cols="50" name="descricao"></textarea>
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<input type="text" name="precos[${status.index}].preco">
				<input type="hidden" name="precos[${status.index}].tipoPreco" value="${tipoPreco}">
			</div>
		</c:forEach>
		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form:form>
</body>
</html>