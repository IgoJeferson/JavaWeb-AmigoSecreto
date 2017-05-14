<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Amigo Secreto</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
	<%@include file="/css/bootstrap.min.css" %>
	<%@include file="/css/estilo.css" %>
</style>
</head>
<body>
	<div class="container">
		<div class="wrapper-form">
			<h3 class="form-signin-heading">Amigo Secreto</h3>
			<h4>Bem-vindo, ${sessionScope.usuario.nome}!</h4>
			<form action=<c:url value="/logout"/> method="post">
				<button type="submit">Logout</button>
			</form>
			<c:if test="${requestScope.amigoSecreto == null}">
				<p>Sorteio ainda não realizado</p>
			</c:if>
			<c:if test="${requestScope.amigoSecreto != null}">
				<p>Sorteio realizado</p>
				<p>Seu amigo secreto é: ${requestScope.amigoSecreto}</p>
			</c:if>
		</div>
	</div>
</body>
</html>