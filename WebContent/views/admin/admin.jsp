<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Admin</title>
<style type="text/css">
	<%@include file="/css/bootstrap.min.css" %>
	<%@include file="/css/estilo.css" %>
</style>
</head>
<body>
	<div class="container">
		<div class="wrapper-form">
		<h3 class="form-signin-heading">Admin</h3>
		<form action=<c:url value="/logout"/> method="post">
			<button type="submit" class="btn btn-lg btn-primary btn-block" >Logout</button>
		</form>
	
		<c:if test="${not empty mensagem }">
			<div class="alert alert-warning" role="alert">${mensagem}</div>
		</c:if>
		<br>
		<c:if test="${sorteio.isEmpty()}">
			<p>Sorteio ainda não realizado</p>
			<form action=<c:url value="/sorteio"/> method="post">
				<button class="btn btn-lg btn-primary btn-block" >Realizar sorteio</button>
			</form>
		</c:if>
		<c:if test="${!sorteio.isEmpty()}">
			<div class="panel panel-success">
				<!-- Default panel contents -->
				<div class="panel-heading">Sorteio Realizado! </div>
				  <!-- Table -->
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Remetente</th>
							<th>Destinatário</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${sorteio}" var="participantes">
							<tr>
								<td>${participantes.remetente.nome}</td>
								<td>${participantes.destinatario.nome}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>
</div>
</body>
</html>