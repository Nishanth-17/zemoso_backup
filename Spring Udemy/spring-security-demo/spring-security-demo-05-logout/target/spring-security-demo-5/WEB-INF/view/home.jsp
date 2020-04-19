<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<h2> WELCOME TO HOME PAGE ------ F!9</h2>
</head>
<body>
<!-- Add a Logout Button -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout" />

</form:form>
</body>
</html>