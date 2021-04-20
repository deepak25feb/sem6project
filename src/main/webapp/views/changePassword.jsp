<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  	
	
	<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Password Change</title>
  <link rel="stylesheet" href="/css-res/PasswordChange-style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form">
    
    <form class="login-form" method="get">
    
    
     <!-- <p>Wrong Password</p> -->
     
   
    <%
    	String email1 = (String)request.getParameter("password");
    	if(email1!=null){
    	String email2 = (String)request.getParameter("confemail");
    	if(email1.equals(email2)){
    		response.sendRedirect("changeTeacherPasswordReal?password="+email1);
    	}
    	else{
    		out.println("<span style=\"color : red;\">Password Didn't Match</span>");
    	}
    	
    	}
    	
    %>

    
    
      <input type="password" placeholder="Enter Password" name="password"/>
      <input type="password" placeholder="Confirm Password" name="confemail"/>
      <button>login</button>
    </form>
    
    
    
    
    
  </div>
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>
	