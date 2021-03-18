<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=number], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 40%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http1.1 %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:if test="${sessionScope.sname != null }">
<%@include file="menu.html" %>
<h3>Logged in as ${sessionScope.sname}</h3>
<br/>
<br/>
<h2>Add Product Form</h2>

<form action="products" method="post">
 
  <div class="container">
    <label for="uname"><b>Product Id</b></label>
    <input type="text" placeholder="pid" name="pid" readonly="readonly" disabled>

    <label for="psw"><b>Name</b></label>
    <input type="text" placeholder="Enter Product Name" name="pname" required>
     
     <label for="cost"><b>Cost</b></label>
    <input type="text" placeholder="cost" name="cost" required>

    <label for="psw"><b>Quantity</b></label>
    <input type="number" placeholder="Enter qty" name="qty" required>
    
    <label for="psw"><b>Category</b></label>
    <select name="category">
    	<option value="electronics">Electronics</option>
    	<option value="fashion">Fashion</option>
    	<option value="accessories">Accessories</option>
    	<option value="groceries">Groceries</option>
    	<option value="menfashion">MenFashion</option>
    	<option value="watches">Watches</option>
    </select> 
    
      
    <button type="submit">Add Product</button>
    
  </div>
</form>
</c:if>
<c:if test="${sessionScope.sname == null}">
<h3>Login first to access this page</h3>
<jsp:include page="login.html"></jsp:include>
</c:if>
</body>
</html>