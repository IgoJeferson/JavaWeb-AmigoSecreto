<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	${param.mensagem}
	<c:if test="${requestScope.sorteio.isEmpty()}">
		<p>Sorteio ainda não realizado</p>
		<form action=<c:url value="/sorteio"/> method="post">
			<button class="btn btn-lg btn-primary btn-block" >Realizar sorteio</button>
		</form>
	</c:if>
	<c:if test="${!requestScope.sorteio.isEmpty()}">
		<p>Sorteio realizado</p>
		<table>
			<thead>
				<tr>
					<th>Remetente</th>
					<th>Destinatário</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.sorteio}" var="participantes">
					<tr>
						<td>${participantes.remetente.nome}</td>
						<td>${participantes.destinatario.nome}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	</div>
</div>
</body>
</html>