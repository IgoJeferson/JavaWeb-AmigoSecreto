<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	<body>
		<h1>Admin</h1>
		${param.mensagem}
		<p>Sorteio ainda não realizado</p>
		<form action=<c:url value="/sorteio"/> method="post">
			<button>Realizar sorteio</button>
		</form>
	</body>
</html>