<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>
<%@ page import="java.util.*, com.example.model.Counter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page</title>
</head>
<body>
  Ocorreu um erro!!!!!!!!!<br>
  
  <b>${pageContext.exception}</b>
  
  <c:catch>
      
      <br>Antes da divisão por zero.
      <% int x = 100/10; %>
      
      <br>Depois da divisão...
  
  </c:catch>
  
  <br> Depois do bloco catch!!!
</body>
</html>