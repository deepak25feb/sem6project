<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Authentication.EntitiesObjects.QuestionPaper" %>	
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Edit Mock</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Comfortaa&amp;display=swap'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.2/iconfont/material-icons.min.css'><link rel="stylesheet" href="/css-res/CreateMock-style.css">
<%
		QuestionPaper ques = (QuestionPaper)request.getAttribute("object1");
		String local = ques.getOption();	
		System.out.println("Option Value : "+local);
			//System.out.println(q.toString());
		
%>

</head>
<body>
<!-- partial:index.partial.html -->
<form method="get" action="saveEditChanges">
<div class="container">
  <br>
  <h1>QA Mock</h1>
  <br>
  <div class="row">
    <div class="col-md-3">
      <input class="form-control" value="${requestScope.object1.qNumber}" name="qNumber"/>
    </div>
    <div class="col-md-3">
      <input class="form-control" value="${requestScope.object1.qDNumber}" name="qDNumber"/>
    </div>
    <div class="col-md-3">
      <input class="form-control" value="${requestScope.object1.qMaxMarks}" name="qMaxMarks"/>
    </div>
    <div class="col-md-3">
      <input class="form-control" value="${requestScope.object1.qMaxTime}" name="qMaxTime"/>
    </div>
  </div>
 <br>
 <br>
  <div class='separator'><span class='preview-text'>QUESTION PREVIEW</span></div>
  <br>
  <div class="row">
    <div class="col-md-12">

      <textarea  class="form-control que-text" name="qResponse">${requestScope.object1.qResponse}</textarea>
    </div>
  </div>




  <br><br>
  <div class='separator'><span class='preview-text'>ANSWER PREVIEW: TYPE AND CHOOSE ONE OR MORE ANSWERS TO SAVE</span></div>
  <br>
  <div id="mcq">
    <div class="row">
      <div class="col-md-2">
      <%
      	
      	if(local.equals("1")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"1\" checked />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"1\" />");
      	}
      %>
        
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object1.qKaAresponse1}" name="qKaAresponse1"/>
      </div>
    </div>
    <br>
    <div class="row">
    <div class="col-md-2">
        
      <%
      	
      	if(local.equals("2")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"2\" checked=\"checked\" />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"2\" />");
      	}
      %>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object1.qKaAresponse2}" name="qKaAresponse2"/>
      </div>
    </div>
    <br>
    <div class="row">
  <div class="col-md-2">
        
     <%
      	
      	if(local.equals("3")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"3\" checked=\"checked\" />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"3\" />");
      	}
      %>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object1.qKaAresponse3}" name="qKaAresponse3"/>
      </div>
    </div><br>
    <div class="row">
<div class="col-md-2">
        
     <%
      	
      	if(local.equals("4")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"4\" checked=\"checked\" />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"4\" />");
      	}
      %>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object1.qKaAresponse4}" name="qKaAresponse4"/>
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
      <button id="save" type="submit" class="btn btn-default btn-block custom" name = "status" value="false">Next</button>
    </div>
    <div class="col-md-2">
      <button  id="reset"   type="submit"  class="btn btn-default btn-block custom" name="status" value="true" >Submit</button>
    </div>
  </div>
  <br>
</div>
</form>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js'></script><script  src="./script.js"></script>

</body>
</html>	