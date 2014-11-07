<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/WEB-INF/views/cabecalho.jsp" />

	<h3> Adicionar Campeonato</h3>
	<form:errors path="campeonato.nome"/>
	<form action="adicionaCampeonato" method="post">
	Nome : <br />
	<textarea name="nome"  rows="5" cols="100"></textarea><br />
	<input type="submit" value="Adicionar">
	</form>
	    <br />  
	  <br />   
      <table>
  <tr>
    <th>Id</th>
     <th>IdUsuario </th>
    <th>Nome: </th>
    <th>Finalizado?:</th>
     
      
  </tr>
  <c:forEach items="${campeonatos}" var="campeonato">
    <tr>
      <td>${campeonato.id}</td>
      <td>${campeonato.idUsuario}</td>
      <td>${campeonato.nome}</td>
      <td>${campeonato.finalizado}</td>
      <td><a href="carregarCampeonato?id=${campeonato.id}">Carregar Campeonato</a></td>
      <td><a href="removeCampeonato?id=${campeonato.id}">Remover</a></td>
     </c:forEach>
  </table>
    
        
<c:import url="/WEB-INF/views/rodape.jsp" />   
</body>
</html>