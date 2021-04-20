<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
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
</head>
<body>
<center>
<video id="video" width="340" height="280" autoplay muted>
<%
	String name = (String)request.getAttribute("emailIdofStudentProc");
	String str ="<source src=\"../videosPlay/Student"+name+".mp4\" type=\"video/mp4\">";
	out.println(str);
%>
  </video>
</center>
  

 
  
</body>
</html>