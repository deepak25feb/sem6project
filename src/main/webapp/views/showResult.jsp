<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>

<%@ page import="java.util.List" %>	
<%@ page import="com.example.demo.Authentication.EntitiesObjects.MarksOfStudent" %>	



<%
	
	List<MarksOfStudent> list = (List<MarksOfStudent>)request.getAttribute("studentresult");
//	for(MarksOfStudent s : list){
//          String str = "[\""+s.getStudentemail()+"\","+s.getMarks()+"],";
//         	System.out.println(str);
//         }

%>

<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawStuff);

      function drawStuff() {
        var data = new google.visualization.arrayToDataTable([
          ['Student Name', 'Marks'],
       <%
          for(MarksOfStudent s : list){
          String str = "[\""+s.getStudentemail()+"\","+s.getMarks()+"],";
         	out.println(str);
         }
         
         
          
          %>
        ]);

        var options = {
          title: 'Students Performance',
          width: 900,
          legend: { position: 'none' },
          chart: { title: 'Students Performance',
                   subtitle: 'Marks by percentage' },
          bars: 'horizontal', // Required for Material Bar Charts.
          axes: {
            x: {
              0: { side: 'top', label: 'Percentage'} // Top x-axis.
            }
          },
          bar: { groupWidth: "90%" }
        };

        var chart = new google.charts.Bar(document.getElementById('top_x_div'));
        chart.draw(data, options);
      };
    </script>
  </head>
  <body>
    <center><div id="top_x_div" style="width: 900px; height: 500px;"></div></center>
  </body>
</html>

