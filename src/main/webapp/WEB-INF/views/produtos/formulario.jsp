<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de cadastro de produtos</title>
</head>
<body>
	<form action="/loja/produtos" method="post">
		<div>
			<label>Nome</label>
			<input type="text" name="nome"/>
		</div>
		<div>
			<label>Marca</label>
			<input type="text" name="marca">
		</div>
		<div>
			<label>Descrição</label>
			<textarea rows="5" cols="50" name="descricao"></textarea>
		</div>
		<div>
			<input type="submit" value="Cadastrar">
		</div>
	</form>
</body>
</html>