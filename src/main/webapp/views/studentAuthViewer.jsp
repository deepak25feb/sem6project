<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.example.demo.Authentication.EntitiesObjects.StudentAuth" %>	
<%@ page import="java.util.List" %>	

<%@ page isELIgnored="false" %>

<%
		System.out.println("INSIDE VIEWER---------------------");
			List<StudentAuth> list=(List<StudentAuth>) request.getAttribute("studentauth");
			
	//		for(StudentAuth a : list) {
	//			out.println(a.toString());
	//		}
	
	
		%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Excel-Export</title>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'><link rel="stylesheet" href="/css-res/StudentView-style.css">
<!-- .................................................................. -->
<script>
function exportTableToExcel(tableID, filename = ''){
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'excel_data.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
}
</script>

<!-- .................................................................. -->

</head>
<body>
<!-- partial:index.partial.html -->
<h1>Student Authentication</h1>
<br/><br/><br/>
<form action="sendAllStudentMail" method="get" >
<div id="dvData" class="container">
  <table class="table table-bordered" id="tblData">
      <tr>
          <th>Student Email</th>
          <th>Student Name</th>
          <th>Student Roll No</th>
          <th>Student Password</th>
      </tr>
      
      <%
      for(StudentAuth a : list) {
      out.println("<tr>");
        out.println("<td>"+a.getStudentemail()+"</td>");
        out.println("<td>"+a.getStudentname()+"</td>");
        out.println("<td>"+a.getStudentrollno()+"</td>");
        out.println("<td>"+a.getStudentpassword()+"</td>");
         out.println("</tr>");  
 
     }
     	%>
       
  </table>
  <br/>
  <input type="submit"  class="btn btn-default btn-lg pull-right" value="Send Mail" />
  <input type="button" onclick="exportTableToExcel('tblData')" class="btn btn-default btn-lg pull-right" value=" Export Auth Data into Excel " />
</div>
</form>

  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script><script  src="/js-res/StudentView-script.js"></script>

</body>
</html>

	