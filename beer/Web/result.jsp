<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*, com.example.model.Counter" %>
<%@ page isELIgnored ="false" %>

<%@ taglib prefix="my" uri="regraTag" %>
 
<html>
<jsp:include page="head.jsp">

      <jsp:param value="Teste JSP Param" name="subTitulo"/>
</jsp:include>
<h1>Beer Recommendation JSP</h1>
<body>
<form action="testBean.jsp">

  User name: <input type="text" name="nome"><br>
  User ID:   <input type="text" name="userID"><br>
  
  <input type="submit">
  
</form>
Method HTTP: ${pageContext.request.method}<br>
initParam: ${initParam.email}

<br>
Function : ${my:regra("Welington testando function")}

<br>
EL - Cargo: ${empregado.cargo["descricao"]}
<br>
Lista EL operador [] ${lista[0]}
<br>
<jsp:useBean id="usuarioLogado" class="com.example.model.Usuario" scope="session"/>
usuario logado: <jsp:getProperty property="nome" name="usuarioLogado"/>
<br>
<jsp:useBean id="pessoa" type="com.example.model.Pessoa" scope="request">
   <jsp:setProperty name="pessoa" property="nome" value="Anonimo" />
</jsp:useBean>
Pessoa logado: <jsp:getProperty property="nome" name="pessoa"/>
<br>
Nome :<%=request.getAttribute("nome") %><br>
Email: <%=request.getAttribute("email") %><br>

Quant usuários na sessão: <%=session.getAttribute("usuarios_sessao") %><br>

<%

   List style = (List) request.getAttribute("style");
   Iterator it = style.iterator();
   while(it.hasNext()){
	   out.print("<br> Try: " + it.next());
   }


%>

<br><br>
Count:
<%
    out.print(Counter.getCount());
%>
<br>
<%! int count = 0; %>
Count ++: <%= count++ %>

<%!
      int doubleCount(){
	
	           count = count*2;
	           return count;
	

      }
%>

<br><br>
Double count: 
<%= doubleCount() %>

<br>
Teste scriptless...
<%
   ArrayList lista = new ArrayList();
   lista.add(new String("foo"));
%>
<%=lista.get(0) %>


Test scriptlets... 

<%! int x = 42; %>
<% int x = 22; %> 
<%= x %>

<br>
<%!
   public void jspInit(){
	
	   ServletConfig config = getServletConfig();
	   
	   String email = config.getInitParameter("email");
	   
	   ServletContext s = config.getServletContext();
	   
	   s.setAttribute("mail", email);
  }


%>
<br>
Mail init param: 
<%= application.getAttribute("mail") %>
<br>
<%= pageContext.getAttribute("mail", PageContext.APPLICATION_SCOPE) %>

 

</body>
</html>