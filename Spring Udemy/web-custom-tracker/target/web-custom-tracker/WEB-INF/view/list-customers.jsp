<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Customer Page</title>
<link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"/>
        </head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> CRM - Customer Relationship Manager </h2>
        </div>
    </div>
    <div id="container">
        <div id="content">

        <input type="button" value="Add Customer" onclick="window.location.href='ShowFormForAdd'; return false;"
        class="add-button" />
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Action </th>
                </tr>
             <c:forEach var="temp" items="${customer}">

             <!-- Update Link with Customer Id -->
             <c:url var="updateLink" value="/Customer/showFormForUpdate">
                <c:param name="customerId" value="${temp.id}"/>
             </c:url>

              <!-- Delete Link with Customer Id -->
                          <c:url var="deleteLink" value="/Customer/delete">
                             <c:param name="customerId" value="${temp.id}"/>
                          </c:url>

                <tr>
                    <td> ${temp.firstName} </td>
                    <td> ${temp.lastName} </td>
                    <td> ${temp.email} </td>
                    <td><a href="${updateLink}">Update</a>
                    |
                    <a href="${deleteLink}"
                    onclick="if (!(confirm('Are you sure?'))) return false">Delete</a</td>

                </tr>
            </c:forEach>

</body>
</html>