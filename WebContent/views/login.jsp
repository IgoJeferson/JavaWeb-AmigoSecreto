<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	</head>
	<body>
		<h1>Login</h1>
		${param.mensagem}
		<form action=<c:url value="/login"/> method="post">
			<div>
				<label for="login">Login</label>
				<input id="login" name="login" required type="text">
			</div>
			<div>
				<label for="senha">Senha</label>
				<input id="senha" name="senha" required type="password">
			</div>
			<div>
				<button type="submit">Login</button>
			</div>
		</form>
		<p>Não possui login? <a href=<c:url value="/cadastro"/>>Cadastre-se!</a></p>
	</body>
</html>