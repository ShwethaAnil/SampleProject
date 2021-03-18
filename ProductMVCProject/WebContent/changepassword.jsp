<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
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
<%@include file="menu.html" %>
<h2>Change Password Form</h2>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="change" method="get">
	<c:if test="${message!=null}">
  <span>${message}</span>
  </c:if>
  <div class="container">
    <label for="psw"><b>Old Password</b></label>
    <input type="password" placeholder="Enter old Password" name="opass" required>

    <label for="psw"><b>New Password</b></label>
    <input type="password" placeholder="Enter New Password" name="npass" required>
        
    <button type="submit">ChangePassword</button>

  </div>

</form>

</body>
</html>