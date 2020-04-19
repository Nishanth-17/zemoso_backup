<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
    .failed{
    color: red;
    }
</style>
</head>
<body>
<h3> MY CUSTOM LOGIN PAGE </h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
<!-- Check for Login Errors -->
<c:if test="${param.error != null}">
<i class="failed">
    You Entered an Invalid Username/password !!!!</i>
</c:if>
<p>
User Name: <input type="text" name="username"/>
</p>
<p>
Password: <input type="password" name="password"/>
</p>
<input type="submit" value="Login" />
</form:form>

</body>
</html>