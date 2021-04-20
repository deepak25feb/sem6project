<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - 404 page</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Arvo'><link rel="stylesheet" href="/css-res/dashBoardError-style.css">


<%
	if(session!=null){
	session.invalidate();
	}

%>
</head>
<body>
<!-- partial:index.partial.html -->
<section class="page_404">
	<div class="container">
		<div class="row">	
		<div class="col-sm-12 ">
		<div class="col-sm-10 col-sm-offset-1  text-center">
		<div class="four_zero_four_bg">
			<h1 class="text-center ">O_Ops!</h1>
		
		
		</div>
		
		<div class="contant_box_404">
		<h3 class="h2">
		Look like you're lost
		</h3>
		
		<p>U R NOT AUTHORIZED YET</p>
		
		<a href="webpages/TeacherAuthentication/index.html" class="link_404">Go to Home</a>
	</div>
		</div>
		</div>
		</div>
	</div>
</section>
<!-- partial -->
  
</body>
</html>
