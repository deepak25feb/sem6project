<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	if(session!=null){
		session.invalidate();
	}
%>	
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Changes Success</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:600&display=swap" rel="stylesheet"><link rel="stylesheet" href="/css-res/success-changes-style.css">
<script>
  function redirect(){
    location.replace("../webpages/homepage/home/index.html");
  }
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="zone">
  <button onclick="redirect()">
    <span class="bodymovin"></span>
    <span class="text">Changes Saved</span>
  </button>
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/bodymovin/5.5.7/lottie.min.js'></script><script  src="/js-res/success-changes-script.js"></script>

</body>
</html>
	