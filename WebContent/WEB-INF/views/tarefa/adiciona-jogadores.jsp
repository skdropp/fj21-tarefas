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
	<h3> Adicionar Jogador</h3>
	<form:errors path="tarefa.descricao"/>
	<form action="adicionaJogador" method="post">
	Nome : <br />
	<textarea name="nome"  rows="5" cols="100"></textarea><br />
	<input type="submit" value="Adicionar">
	</form>
	<a href="listaJogadores"> VOltar  </a>
</body>
</html>