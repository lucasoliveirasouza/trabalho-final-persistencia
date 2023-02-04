<%@page import="java.util.ArrayList"%>
<%@page import="models.Agenda" %>
<%@page import="models.Situacao" %>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Agenda agenda = (Agenda) request.getAttribute("agenda");
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Informações sobre a agenda</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<style>
	.info-vacina{
		border: 1px solid var(--bs-gray-500);;
    	width: 50%;
    	border-radius: 0.5rem;
    	margin-top: 2rem;
    	box-shadow: 1px 1px 6px 1px var(--bs-dark);
	}
</style>
<div class="container-fluid">
	<div class="d-flex justify-content-center mt-3 w-100">
		<h4 class="me-2" style="color: var(--bs-gray-700);">Informações sobre a agenda</h4>
		<i class="fas fa-info-circle mt-1" style="color: var(--bs-blue); font-size: 1.4rem;"></i>
	</div>
	<div class="container-fluid d-flex justify-content-center info-vacina">
		<div class="w-100 mt-3">
			<ul style="list-style-type: none; font-size:18pt; color: var(--bs-gray-700);">
				<li>Usuário: <%=agenda.getUsuario().getNome()%></li>
				<li>Vacina: <%=agenda.getVacina().getTitulo()%></li>
				<li>Data da vacina: <%=dateFormat.format(agenda.getData())%></li>
				<li>Horário da vacina: <%=agenda.getHora()%></li>
				<li>Situação: <%=agenda.getSituacao()%></li>
				
				
				<%if(agenda.getSituacao() == Situacao.Cancelado){%>
					<li>Data do cancelamento: <%=dateFormat.format(agenda.getData_situacao())%></li>
				<%}else if(agenda.getSituacao() == Situacao.Realizado){%>
					<li>Data da realização: <%=dateFormat.format(agenda.getData_situacao())%></li>
				<%}%>
			</ul>
			
			<%
			if(agenda.getSituacao() == Situacao.Agendado){%>
				<div class = "text-center mb-3 mt-4">
					<a href="CancelarAgenda?id=<%=agenda.getId()%>" class="btn btn-danger me-3">
						Cancelar agenda
						<i class="fas fa-times mx-1"></i>
					</a>
					<a href="RealizarAgenda?id=<%=agenda.getId()%>" class="btn btn-success">
						Agenda Realizada
						<i class="fas fa-check mx-1"></i>
					</a>
				</div>
				
				
			<% }
			%>
		</div>
	</div>	
	<div class = "text-center mb-3 mt-4">
		 <a href="ListarAgendas?tipo=1" class="btn btn-secondary mt-3">
			<i class="fas fa-arrow-left me-1"></i>
			Voltar ao menu
		</a>
	</div>
	
</div>
	
</body>
</html>