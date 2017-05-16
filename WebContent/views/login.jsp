<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<style type="text/css">
<%-- 	<%@include file="../css/bootstrap.min.css" %> --%>
	<%@include file="../css/estilo.css" %>
</style>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="login-form col-xs-10 col-xs-offset-1 col-sm-6 col-sm-offset-3 col-md-4 col-md-offset-4">
<!-- 	<div class="wrapper"> -->
		<form action=<c:url value="/login"/> method="post">
			<h3 class="form-signin-heading">Amigo Secreto</h3>
			<hr class="colorgraph"><br>
				
			<c:if test="${not empty mensagem }">
				<div class="alert alert-warning" role="alert">${mensagem}</div>
			</c:if>
			
		    <div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</div>
					<input id="login" name="login" required type="text" class="form-control" placeholder="Seu login" >
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</div>
					<input id="senha" name="senha" required type="password" class="form-control" placeholder="Sua senha" >
				</div>
			</div>

    		<br>
			<button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
			<p>
				Não possui login? <a href=<c:url value="/cadastro"/>>Cadastre-se!</a>
			</p>
		</form>
<!-- 	</div> -->
</div>
</body>
</html>