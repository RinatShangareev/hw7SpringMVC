<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
	<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>
<body>
<div class="container">
	<form:form method="POST" action="/authUser" modelAttribute="user">
	<div class="form-group ${error != null ? 'has-error' : ''}">
		<span>${message}</span>
		<input name="userName" type="text" class="form-control" placeholder="Username"
			   autofocus="true"/>
		<input name="password" type="password" class="form-control" placeholder="Password"/>
		<span>${error}</span>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
		<h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
	</div>
	</form:form>
	<%--<h1>Message : ${message}</h1>--%>
	<%--<form:form method="POST" action="/authUser" modelAttribute="user">--%>

		<%--User Name : <input type="text" id="userName" name="userName" class="form-control"/><br/>--%>

		<%--Password : <input type="password" id="password" name="password" class="form-control"/><br/>--%>

		<%--<button class="btn btn-success" type="submit">Login</button>--%>
		<%--&lt;%&ndash;<input type="submit" value="Login" />&ndash;%&gt;--%>

	<%--</form:form>--%>
</div>
</body>
</html>