<%@page import="java.util.ArrayList"%>
<%@page import="models.Agenda" %>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	List<Agenda> agendas = (List<Agenda>) request.getAttribute("lista");
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Agenda</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
	<style>
		.alignCenter{
			text-align: center;
		}
	</style>
	<div class="container-fluid">	
		<% if (request.getAttribute("mensagem") != null) {%>
			<p style="color:red"><%=request.getAttribute("mensagem") %></p>
		<%} %>
		
		<div class="row mb-5" style="background: rgba(0, 0, 0, 0.05);">
			<div class="col-md-6">
				<h1>Agendas do Usuário</h1>
			</div>
			
				
		</div>
		<table class="table table-striped">
			<tr>
				<td>Nome</td>
				<td>Vacina</td>
				<td class="alignCenter">Data</td>
				<td>Hora</td>
				<td>Situação</td>
			</tr>
			<% for(Agenda agenda : agendas) { %>
				<tr>
					<td><%=agenda.getUsuario().getNome()%></td>
					<td><%=agenda.getVacina().getTitulo()%></td>
					<td class="alignCenter"><%=dateFormat.format(agenda.getData())%></td>
					<td><%=agenda.getHora()%></td>
					<td><%=agenda.getSituacao()%></td>
					
				</tr>
			<% } %>
			
		</table>	
			<br/>
			<a href="ListarUsuarios" class="btn btn-secondary mt-3">
				<i class="fas fa-arrow-left me-1"></i>
				Voltar ao menu principal
			</a>
		</div>	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>

