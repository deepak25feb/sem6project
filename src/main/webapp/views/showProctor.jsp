<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.example.demo.Authentication.EntitiesObjects.StudentAuth" %>	
<%@ page import="java.util.List" %>	
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
 <!-- 
  <script defer src="/js-res/face-api.min.js"></script>
  <script defer src="/js-res/script.js"></script>
  
<style>

body {
	  background-color: #695681;
      margin: 0;
      padding: 0;
      width: 100vw;
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    canvas {
      position: absolute;
    }
</style>
-->
</head>
<body style="background-color: #695681;">
<!--
<video id="video" width="340" height="280" autoplay muted>
    <source src="/js-res/abc.mp4" type="video/mp4">
  </video>
-->
<center>
<h1>PROCTOR</h1>
<hr>
<br>
<%
	 List<StudentAuth> list= (List<StudentAuth>)request.getAttribute("StudentEmailData");
	for(StudentAuth a : list) {
				//System.out.println(a.toString());
				out.println("<a href=\"goto?id="+a.getStudentemail()+" \"><video id=\"video\" width=\"340\" height=\"280\" autoplay  >");
				String str = "<source src=\"../videosPlay/Student"+a.getStudentemail()+".mp4\" type=\"video/mp4\">";
				out.println(str);
				out.println("</video></a>");
				
			}
	
	
%>

<center>



</body>
</html>