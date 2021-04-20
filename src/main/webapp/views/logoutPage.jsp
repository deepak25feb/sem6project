<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html lang="en" >
<head>

<%
	if(session!=null){
	session.invalidate();
	}
%>



  <meta charset="UTF-8">
  <title>Logout</title>
  <link rel="stylesheet" href="/css-res/logout-style.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<script>
  function home(){
    location.replace("../webpages/homepage/home/index.html");
  }
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<div id="container">
  <div id="success-box">
    <div class="dot"></div>
    <div class="dot two"></div>
    <div class="face">
      <div class="eye"></div>
      <div class="eye right"></div>
      <div class="mouth happy"></div>
    </div>
    <div class="shadow scale"></div>
    <div class="message"><h1 class="alert">Success!</h1><p><b>You Have Logout Sucessfully</b></p></div>
    <button class="button-box" onclick="home()"><h1 class="green">continue</h1></button>
  </div>

  
</body>
</html>


