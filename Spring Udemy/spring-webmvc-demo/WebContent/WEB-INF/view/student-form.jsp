<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html><head>
<title>STUDENT ENTRY FORM</title>
<style>
.error{color:red}
</style>
</head>
<body>
<i>Fill the Form. (*)Asterisk means REQUIRED.</i>
	<form:form action="processForm" modelAttribute="student">
	<br><br>
	First Name(*):  <form:input path="firstName"/>
	<form:errors path="firstName" cssClass="error"/>
	<br><br>
	Last Name(*):   <form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"/>
	<br><br>
	
	Gender:	Male <form:radiobutton path="gender" value="male"/>
	Female <form:radiobutton path="gender" value="female"/>
	<br><br>
	
	Country:    <form:select path="country">
				<form:option value="IND" label="INDIA"/>
				<form:option value="USA" label="AMERICA"/>
				<form:option value="CAN" label="CANADA"/>
				</form:select>
				<br><br>
	Favorite Subject: <br>
	<form:radiobutton path="subject" value="Java"/> Java <br>
	<form:radiobutton path="subject" value="OS"/> OS <br>
	<form:radiobutton path="subject" value="Databases"/> DB <br>
	<br>
	Operating Systems:<br>
	<form:checkbox path="operatingsystem" value="Linux"/> Linux<br>
	<form:checkbox path="operatingsystem" value="Windows"/> Windows<br>
	<form:checkbox path="operatingsystem" value="MacOS"/> MacOS<br>
	<br><br>
	Credits obtained:<form:input path="credits" />
	<form:errors path="credits" cssClass="error"/>
	<br><br>
	Mobile Number: <form:input path="mobile"/>
	<form:errors path="mobile" cssClass="error"/>
	<br><br>
	Postal Code:<form:input path="postalcode" />
	<form:errors path="postalcode" cssClass="error"/>
	<br><br>
	Course Code:<form:input path="courseCode" />
	<form:errors path="courseCode" cssClass="error"/>
	<br><br>
	<input type="submit" value="Enter"/>
	</form:form>
</body>
</html>