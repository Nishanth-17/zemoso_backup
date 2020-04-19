<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Confirmation Page</title></head>
<body>
<br>
<h3> WELCOME Mr. ${student.lastName}</h3>
<br><br>
   This Student is Confirmed : ${student.firstName} ${student.lastName}.<br>
   Mr. ${student.firstName} ${student.lastName} is from ${student.country}<br>
   Gender: ${student.gender}<br>
   His Favorite Subject is ${student.subject}.<br>
   Operating Systems known :
   <ul>
   <c:forEach var="temp" items="${student.operatingsystem}">
   		<li> ${temp} </li>
   	</c:forEach>
   	</ul>
 
   	Credits: ${student.credits}<br>
   	Mobile Number: ${student.mobile}<br>
   	Course Code: ${student.courseCode}<br>
   	PostalCode: ${student.postalcode}
</body></html>