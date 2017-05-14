<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
	<%@include file="../css/bootstrap.min.css" %>
	<%@include file="../css/estilo.css" %>
</style>
</head>
<body>
<div class="container">
	<div class="wrapper">
		<form action=<c:url value="/login"/> method="post">
			<h3 class="form-signin-heading">Amigo Secreto</h3>
			${param.mensagem}
			<hr class="colorgraph"><br>
			<input id="login" name="login" required type="text" class="form-control" placeholder="Seu login" >
			<input id="senha" name="senha" required type="password" class="form-control" placeholder="Sua senha" >
			<button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
			<p>
				Não possui login? <a href=<c:url value="/cadastro"/>>Cadastre-se!</a>
			</p>
		</form>
	</div>
</div>
</body>
</html>