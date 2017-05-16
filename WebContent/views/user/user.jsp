<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Amigo Secreto</title>
<style type="text/css">
	<%@include file="/css/bootstrap.min.css" %>
	<%@include file="/css/estilo.css" %>
</style>
</head>
<body>
	<div class="container">
		<div class="wrapper-form">
			<h3 class="form-signin-heading">Amigo Secreto</h3>
			<h4>Bem-vindo, ${usuario.nome}!</h4>
			<form action=<c:url value="/logout"/> method="post">
				<button type="submit" class="btn btn-lg btn-primary btn-block" >Logout</button>
			</form>
			<c:if test="${amigoSecreto == null}">
				<p>Sorteio ainda não realizado</p>
			</c:if>
			<c:if test="${amigoSecreto != null}">
				<span class="label label-default">Sorteio realizado</span>
				<br>
				<div class="alert alert-info" role="alert">Seu amigo secreto é: <b>${amigoSecreto}</b></div>
			</c:if>
		</div>
	</div>
</body>
</html>