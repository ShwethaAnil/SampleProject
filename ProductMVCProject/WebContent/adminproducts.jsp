<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<style>
#products {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#products td, #products th {
  border: 1px solid #ddd;
  padding: 8px;
}

#products tr:nth-child(even){background-color: #f2f2f2;}

#products tr:hover {background-color: #ddd;}

#products th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http1.1 %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${sessionScope.sname != null }">
<%@include file="menu.html" %>
<h3>Logged in as ${sessionScope.sname}</h3>
<br/>
<br/>
<table id="products">
	<tr>
		<th>Product Id</th>
		<th>Name</th>
		<th>Cost</th>
		<th>Quantity</th>
		<th>Category</th>
		<th>Ratings</th>
	</tr>
	<c:catch var="e">
	<c:forEach var="p" items="${applicationScope.products}">
	<tr>
		<td>${p.pid}</td>
		<td>${p.pname}</td>
		<td>
		<fm:setLocale value="en_IN"/>
		<fm:formatNumber type="currency" value="${p.cost}" />
		</td>
		<td>${p.qty}</td>
		<td>${p.catagory}</td>
		<td>${p.ratings}</td>
		<%-- <td><fm:formatNumber type="percent" value="${p.ratings}" /></td> --%>
	</tr>
	</c:forEach>
	</c:catch>
	<c:if test="${e != null}">
	<tr>
		<td colspan="5">${e.getMessage()}</td>
	</tr>
	</c:if>
</table>
</c:if>
<c:if test="${sessionScope.sname == null}">
<h3>Login first to access this page</h3>
<jsp:include page="login.html"></jsp:include>
</c:if>
</body>
</html>