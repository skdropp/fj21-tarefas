<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" href="resources/css/tarefas.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:errors path="jogador.nome"/>
	<form action="adicionaJogador" method="post">
	<textarea name="nome"  rows="1" cols="20"></textarea>
	<input type="submit" value="Adicionar Jogador">
	</form>
	 <br />  
	  <br />  
	
	<table>
  <tr>
    <th>Id</th>
     <th>IdCampeonato </th>
    <th>Nome: </th>
    <th>Jogos:</th>
     <th>Vitorias:</th>
      <th>Empates:</th>
       <th>Derrotas:</th>
        <th>Gols Pró:</th>
         <th>Gols Contra:</th>
          <th>Saldo de Gols:</th>
           <th>Pontos:</th>
  </tr>
  <c:forEach items="${jogadores}" var="jogadores">
    <tr>
      <td>${jogadores.id}</td>
      <td>${jogadores.idCampeonato}</td>
      <td>${jogadores.nome}</td>
      <td>${jogadores.jogos}</td>
      <td>${jogadores.vitorias}</td>
      <td>${jogadores.empates}</td>
      <td>${jogadores.derrotas}</td>
      <td>${jogadores.gp}</td>
      <td>${jogadores.gc}</td>
      <td>${jogadores.sg}</td>
     <td>${jogadores.pontos}</td>
     <td><a href="removeJogador?id=${jogadores.id}">Remover</a></td>
     </c:forEach>
  </table>
  <td><a href="confereSeTemConfrontosDoCampeonato"> Gerar Confrontos </a></td>
  <td><a href="removeConfrontos"> Remover Confrontos </a></td>
  <table>
  <tr>
    <th>Id</th>
     <th>IdCampeonato </th>
    <th>Id Jogador Casa: </th>
    <th>Nome:</th>
     <th>Gols Casa:</th>
      <th>Id Jogador Fora:</th>
       <th>Nome:</th>
        <th>Gols Fora:</th>
         
  </tr>
  <c:forEach items="${confrontos}" var="confrontos">
    <tr>
      <td>${confrontos.id}</td>
      <td>${confrontos.idCampeonato}</td>
      <td>${confrontos.idJogadorCasa}</td>
      <td>${confrontos.jogadorCasa}</td>
      <td>${confrontos.golsCasa}</td>
      <td>${confrontos.idJogadorFora}</td>
      <td>${confrontos.jogadorFora}</td>
      <td>${confrontos.golsFora}</td>
      </c:forEach>
  </table>
  
  
  
</body>
</html>