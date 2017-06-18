<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome to our page Welcome!<br><br>



<% if (request.getParameter("nome") == null || request.getParameter("nome") == "") { %>
    
        
    <jsp:forward page="handle.jsp">
         <jsp:param value="Teste JSP Param" name="subTitulo" />
    </jsp:forward>
    
<% } %>
   <jsp:useBean id="pessoa" class="com.example.model.Empregado" scope="request">
      <!-- <jsp:setProperty name="pessoa" property="nome" value='<%= request.getParameter("userName") %>' /> -->
      <!-- <jsp:setProperty name="pessoa" property="nome" param="userName" /> -->
      <jsp:setProperty name="pessoa" property="nome"  />
   </jsp:useBean>
    Empregado logado: <jsp:getProperty property="nome" name="pessoa"/>
<br><br>

<c:set var="meuNome" value="${pessoa.nome}" scope="request"/>

<c:set var="meuNomeBody" scope="request" >
    Teste do c:set com corpo (Body).
</c:set>

teste c:set e c:out: <c:out value="${requestScope.meuNome}" /><br><br>

teste c:set com corpo: <c:out value="${requestScope.meuNomeBody}" /><br><br>

Teste c:choose:<br>

<c:choose>
    <c:when test="${pessoa.nome eq 'wellington'}">
         Bem vindo Wellington - sua certificação está a caminho.
    </c:when>
    
    <c:when test="${pessoa.nome eq 'wallace'}">
        Bem vindo Wallace.
    </c:when>
    
    <c:when test="${pessoa.nome eq 'adriana'}">
       Bem vinda Adriana.
    </c:when>

    <c:otherwise>
        Bem vindo anonimo.
    </c:otherwise>
</c:choose>
</body>
</html>
