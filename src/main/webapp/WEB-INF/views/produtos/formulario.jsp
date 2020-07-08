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
	<form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" 
	commandName="produto" enctype="multipart/form-data">
		<div>
			<label>Nome</label>
			<form:input path="nome"/>
			<form:errors path="nome" />
		</div>
		<div>
			<label>Marca</label>
			<form:input path="marca" />
			<form:errors path="marca" />
		</div>
		<div>
			<label>Descrição</label>
			<form:textarea rows="5" cols="50" path="descricao" />
		</div>
		<div>
			<label>Data de validade</label>
			<form:input path="dataValidade" /> 
		</div>
		<c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
			<div>
				<label>${tipoPreco}</label>
				<form:input path="precos[${status.index}].preco" />
				<form:hidden path="precos[${status.index}].tipoPreco" value="${tipoPreco}"/>
			</div>
		</c:forEach>
		<div>
			<label>Foto</label>
			<input name="arquivo" type="file" />
		</div>
		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form:form>
</body>
</html>