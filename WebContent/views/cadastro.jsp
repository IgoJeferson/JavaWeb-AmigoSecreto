<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Cadastro</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	<body>
		<h1>Cadastro</h1>
		${param.mensagem}
		<form action=<c:url value="/cadastro"/> method="post">
			<div>
				<label for="nome">Nome</label>
				<input id="nome" name="nome" required type="text">
			</div>
			<div>
				<label for="cpf">CPF</label>
				<input id="cpf" name="cpf" required type="text">
			</div>
			<div>
				<label for="login">Login</label>
				<input id="login" name="login" required type="text">
			</div>
			<div>
				<label for="senha">Senha</label>
				<input id="senha" name="senha" required type="password">
			</div>
			<div>
				<button type="submit">Salvar</button>
			</div>
		</form>
	</body>
</html>