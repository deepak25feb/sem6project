<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.example.demo.Authentication.EntitiesObjects.QuestionPaper" %>	
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="com.example.demo.RecordAndEncodeVideo" %>	

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
 
  <title></title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Comfortaa&amp;display=swap'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.2/iconfont/material-icons.min.css'><link rel="stylesheet" href="/css-res/viewQuestionPaper.css">
<!-- <meta http-equiv="Refresh" content="5;url=giveExam"> -->
<script>
const startingMinutes = ${requestScope.questionpaper.qMaxTime};


</script>
</head>
<body>
 <%
 	QuestionPaper q = (QuestionPaper)request.getAttribute("questionpaper");
 	
 	LocalDateTime date1 = LocalDateTime.now();
 	System.out.println(q.toString() +" TIME : "+ date1.toString());
 	
 
 %>
  


<form method="get" action="takeAnswer">
<div class="container">
 <p id="countdown" class="timer"></p>
 <br>
  <div class='separator'><span class='preview-text'>QUESTION PREVIEW</span></div>
  <br>
  <div class="row">
    <div class="col-md-12">
      <textarea  class="form-control que-text" name="qResponse" disabled><%= q.getqResponse() %></textarea>
    </div>
  </div>




  <br><br>
  <div class='separator'><span class='preview-text'>ANSWER PREVIEW</span></div>
  <br>
  <div id="mcq">
    <div class="row">
      <div class="col-md-2">
        <input class="form-control" type="radio" name="option" value="1" />
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.questionpaper.qKaAresponse1}" name="qKaAresponse1" disabled/>
        
      </div>
    </div>
    <br>
    <div class="row">
    <div class="col-md-2">
        <input class="form-control" type="radio" name="option" value="2" />
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.questionpaper.qKaAresponse2}" name="qKaAresponse2" disabled/>
      </div>
    </div>
    <br>
    <div class="row">
  <div class="col-md-2">
        <input class="form-control" type="radio" name="option" value="3"/>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.questionpaper.qKaAresponse3}" name="qKaAresponse3" disabled/>
      </div>
    </div><br>
    <div class="row">
<div class="col-md-2">
        <input class="form-control" type="radio" name="option"  value="4" />
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.questionpaper.qKaAresponse4}" name="qKaAresponse4" disabled/>
      </div>
    </div>
    <br><br>
  </div>
  


  
  
<!-- Save Button -->
  <div class="row">
    <div class="col-md-8">
      <span class="status"></span>
    </div>
    <div class="col-md-2">
      <button type="reset" id="save" class="btn btn-default btn-block custom" >Reset</button>
    </div>
    <div class="col-md-2">
      <button type="submit" id="reset" class="btn btn-default btn-block custom">Next</button>
    </div>
  </div>
  <br>
</div>
</form>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script><script  src="/js-res/timer.js"></script>





</body>
</html>

