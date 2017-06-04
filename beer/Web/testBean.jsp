<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome to our page Welcome!

<% if (request.getParameter("nome") == null || request.getParameter("nome") == "") { %>

    <!-- Qualquer coisa escrita no response antes da <jsp:forward> e limpa, a frase Welcome to our page! NÃO e exibida  -->
    <jsp:forward page="handle.jsp"></jsp:forward>
    
<% } %>
   <jsp:useBean id="pessoa" class="com.example.model.Empregado" scope="request">
      <!-- <jsp:setProperty name="pessoa" property="nome" value='<%= request.getParameter("userName") %>' /> -->
      <!-- <jsp:setProperty name="pessoa" property="nome" param="userName" /> -->
      <jsp:setProperty name="pessoa" property="nome"  />
   </jsp:useBean>
    Empregado logado: <jsp:getProperty property="nome" name="pessoa"/>
<br>
</body>
</html>
