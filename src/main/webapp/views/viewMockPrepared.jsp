<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Authentication.EntitiesObjects.QuestionPaper" %>	
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>View Mock</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css'>
<link rel='stylesheet' href='https://fonts.googleapis.com/css2?family=Comfortaa&amp;display=swap'>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.2/iconfont/material-icons.min.css'><link rel="stylesheet" href="/css-res/viewMock-style.css">
<%
		QuestionPaper ques = (QuestionPaper)request.getAttribute("object2");
		String local = ques.getOption();	
		System.out.println("Option Value : "+local);
			//System.out.println(q.toString());
		
%>

</head>
<body>
<!-- partial:index.partial.html -->
<form method="get" action="submitViewMock">
<div class="container">
  <br>
  <div class='separator'><span class='preview-text'>QUESTION PREVIEW</span></div>
  <br>
  <div class="row">
    <div class="col-md-12">

      <textarea  class="form-control que-text" name="qResponse" disabled>${requestScope.object2.qResponse}</textarea>
    </div>
  </div>




  <br><br>
  <div class='separator'><span class='preview-text'>ANSWER PREVIEW</span></div>
  <br>
  <div id="mcq">
    <div class="row">
      <div class="col-md-2">
      <%
      	
      	if(local.equals("1")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"1\" checked  disabled/>");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"1\"  disabled/>");
      	}
      %>
        
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object2.qKaAresponse1}" name="qKaAresponse1" disabled/>
      </div>
    </div>
    <br>
    <div class="row">
    <div class="col-md-2">
        
      <%
      	
      	if(local.equals("2")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"2\" checked=\"checked\" disabled />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"2\" disabled />");
      	}
      %>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object2.qKaAresponse2}" name="qKaAresponse2" disabled/>
      </div>
    </div>
    <br>
    <div class="row">
  <div class="col-md-2">
        
     <%
      	
      	if(local.equals("3")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"3\" checked=\"checked\" disabled />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"3\" disabled />");
      	}
      %>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object2.qKaAresponse3}" name="qKaAresponse3" disabled/>
      </div>
    </div><br>
    <div class="row">
<div class="col-md-2">
        
     <%
      	
      	if(local.equals("4")){
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"4\" checked=\"checked\" disabled />");
      	}else{
      	out.println("<input class=\"form-control\" type=\"radio\" name=\"option\" value=\"4\" />");
      	}
      %>
      </div>
      <div class="col-md-10">
        <input class="form-control ans-text" value="${requestScope.object2.qKaAresponse4}" name="qKaAresponse4" disabled/>
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