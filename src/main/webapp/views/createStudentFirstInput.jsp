<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Flat HTML5/CSS3 Login Form</title>
  <link rel="stylesheet" href="/css-res/StudentFirstInout-style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="login-page">
  <div class="form" >
    
    <form class="login-form" action="persistStudentFistInput">
      <input type="text" placeholder="Subject Name" name="subjectname"/>
      <input type="text" placeholder="Total Students" name="totalstudent"/>
      <input type="text" placeholder="Exam Date" name="examdate"/>
      <input type="text" placeholder="Exam Start Timing" name="examtime"/>
      
      <button type="submit">Next</button>
      
    </form>
  </div>
</div>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>
</html>
