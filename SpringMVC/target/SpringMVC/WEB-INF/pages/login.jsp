<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<container>
	<h1>Message : ${message}</h1>
	<form:form method="POST" action="/login" modelAttribute="user">

		User Name : <input type="text" id="userName" name="userName" class="form-control"/><br/>

		Password : <input type="password" id="password" name="password" class="form-control"/><br/>

		<button class="btn btn-success" type="submit">Login</button>
		<%--<input type="submit" value="Login" />--%>

	</form:form>
</container>
</body>
</html>