<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>
<html>
<head>
<h2><center>------ WELCOME TO HOME PAGE ------ </center></h2>
</head>
<body>

<!-- Display User name and Role -->
<hr>
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>
<!-- Add a link for leaders page -->
<p>
<a href="${pageContext.request.contextPath}/leaders">LeadershipPage</a>
(Only for Managers)
</p>
<hr>
<!-- Add a link to point to /systems ... this is for the admins -->

	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Admin)
	</p>


	<hr>

<!-- Add a Logout Button -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value="Logout" />

</form:form>
</body>
</html>