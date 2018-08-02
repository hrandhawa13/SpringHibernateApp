<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customers are listed here</title>
<link type="text/css" 
		rel = "stylesheet" 
		href="${pageContext.request.contextPath}/Resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id = "header">
			<h2>Customer Relation Manager </h2>		
		</div>
	</div>
	
	<div id ="container">
		<div id="content">
			<input class= "add-button" type="button" value="Add Customer" 
				onclick="window.location.href='addCustomerForm'; return false;"
			/>
			<!-- Customer Table  -->
			<table>
				<tr>
					<th>First Name </th>
					<th>Last Name </th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var = "temp" items="${customer}">
					
					<c:url var="updateLink" value="/customer/updateForm">
						<c:param name = "customerId" value="${temp.id }" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name = "customerId" value="${temp.id }" />
					</c:url>
					
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete ?'))) return false">
								Delete</a>
						</td>
					</tr>
				
				</c:forEach>
			</table>
			
		</div>
	</div>
</body>
</html>