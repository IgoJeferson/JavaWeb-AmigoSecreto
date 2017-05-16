<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Cadastro</title>
		<style type="text/css">
			<%@include file="../css/bootstrap.min.css" %>
			<%@include file="../css/estilo.css" %>
		</style>
	</head>
	<body>
	<div class="container">
			<div class="wrapper-form">
			<h3 class="form-signin-heading">Cadastro</h3>
			
			<c:if test="${not empty mensagem }">
				<div class="alert alert-danger" role="alert">${mensagem}</div>
			</c:if>
			
			<form action=<c:url value="/cadastro"/> method="post">
				<div>
					<label for="nome">Nome</label>
					<input id="nome" name="nome" required type="text" class="form-control">
				</div>
				<div>
					<label for="cpf">CPF</label>
					<input id="cpf" name="cpf" required type="text" class="form-control">
				</div>
				<div>
					<label for="login">Login</label>
					<input id="login" name="login" required type="text" class="form-control">
				</div>
				<div>
					<label for="senha">Senha</label>
					<input id="senha" name="senha" required type="password" class="form-control">
				</div>
				<div>
					<button type="submit" class="btn btn-lg btn-primary btn-block">Salvar</button>
				</div>
			</form>
		</div>
	</div>
	</body>
</html>