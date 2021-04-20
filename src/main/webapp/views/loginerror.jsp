<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


LOGOUT SUCCESS
<%
	if(session!=null){
	session.invalidate();
	}
%>

<a href="../webpages/TeacherAuthentication/index.html">Try Again </a>