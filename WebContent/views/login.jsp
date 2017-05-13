<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> -->
<style type="text/css">
	<%@include file="../css/bootstrap.min.css" %>
	<%@include file="../css/estilo.css" %>
</style>
</head>
<body>
<div class="centralizar">
	<h1 class="titulo">Login</h1>
	<br>
	${param.mensagem}
	<form action=<c:url value="/login"/> method="post">
		<div>
			<label for="login">Login</label> <input id="login" name="login"
				required type="text" placeholder="Seu login" >
		</div>
		<div>
			<label for="senha">Senha</label> <input id="senha" name="senha"
				required type="password" placeholder="Sua senha" >
		</div>
	    <br>
		<div class="botao">
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
	</form>
    <br>
	<p>
		Não possui login? <a href=<c:url value="/cadastro"/>>Cadastre-se!</a>
	</p>
</div>
</body>
</html>