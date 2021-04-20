<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ page import="com.example.demo.Authentication.EntitiesObjects.StudentFirstInput" %>	
<%@ page import="java.time.LocalDateTime" %>	
<%@ page import="java.time.format.DateTimeFormatter" %>	


<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Student Exam</title>
  <link rel="stylesheet" href="/css-res/showTest.css">
<%
	LocalDateTime date1 = LocalDateTime.now();
    
	StudentFirstInput student =(StudentFirstInput) request.getAttribute("studenttestdetails");
	
	String str = student.getExamdate()+" "+student.getExamtime(); //2016-03-04 11:30
	System.out.println("TIME : "+str);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
	LocalDateTime dateTime = LocalDateTime.parse(str, formatter);


	LocalDateTime date2 = dateTime;
	//LocalDateTime date2 = LocalDateTime.of(2021, 4, 5, 12, 25, 45); Commented Section
	int diff = date1.compareTo(date2);
       
%>
</head>
<body >
<div class="wrapper">
    <table>
        <thead>
          <tr>
            <th>Subject </th>
            <th>Date</th>
            <th>Time</th>
            <th>Click</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><%= student.getSubjectname() %></td>
            <td><%= student.getExamdate() %></td>
            <td><%= student.getExamtime()%></td>
            <%
            if(diff > 0) {
            out.println("<td><form action=\"giveExam\"><input type=\"submit\" value=\"Start Exam\"></form></td>");
        } else if (diff < 0) {
             out.println("<td><form action=\"giveExam\"><input type=\"submit\" value=\"Start Exam\" disabled></form></td>");
        } else {
             out.println("<td><form action=\"giveExam\"><input type=\"submit\" value=\"Start Exam\" ></form></td>");
        }
            	
            %>
            
          </tr>
         
        </tbody>
      </table>
</div>

</body>
</html>
