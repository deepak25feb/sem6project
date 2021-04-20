<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Student Authentication Details</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Comfortaa&amp;display=swap'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.2/iconfont/material-icons.min.css'><link rel="stylesheet" href="/css-res/StudentAuth-style.css">


</head>
<body>
<!-- partial:index.partial.html -->
<form method="get" action="AddStudentInstance">
<div class="container">
 
 <br>
  <div class='separator'><span class='preview-text'>Student Authentication</span></div>
  <br>
  <div class="row">
    <div class="col-md-12">
        <center>
        <input type="text" placeholder="Student Email" name="studentemail">
        <input type="text" placeholder="Student Name" name="studentname">
        <input type="text" placeholder="Student RollNo" name="studentrollno">
        <input type="text" placeholder="Student Password" name="studentpassword">
    </center>
    </div>
  </div>




  <br><br>
  <div class='separator'><span class='preview-text'>Click Next</span></div>
  <br>
  
<!-- Save Button -->
  <div class="row">
    <div class="col-md-8">
      <span class="status"></span>
    </div>
    <div class="col-md-2">
      <button type="submit" id="save" class="btn btn-default btn-block custom" >Next</button>
    </div>
    
  </div>
  <br>
</div>
</form>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>
