<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<h1>Admin</h1>
	${param.mensagem}
	<c:if test="${requestScope.sorteio.isEmpty()}">
		<p>Sorteio ainda não realizado</p>
		<form action=<c:url value="/sorteio"/> method="post">
			<button>Realizar sorteio</button>
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
</body>
</html>