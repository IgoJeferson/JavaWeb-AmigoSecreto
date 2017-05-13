<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Amigo Secreto</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	<body>
		<h1>Amigo Secreto</h1>
		<h2>Bem-vindo, ${requestScope.usuario}!</h2>
		<c:if test="${requestScope.amigoSecreto == null}">
			<p>Sorteio ainda não realizado</p>
		</c:if>
		<c:if test="${requestScope.amigoSecreto != null}">
			<p>Sorteio realizado</p>
			<p>Seu amigo secreto é: ${requestScope.amigoSecreto}</p>
		</c:if>
	</body>
</html>