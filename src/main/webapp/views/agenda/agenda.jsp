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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="css/geral.css">
<script src="js/modal.js" crossorigin="anonymous"></script>
<script src="js/geral.js" crossorigin="anonymous"></script>
</head>
<body>
	<style>
		.alignCenter{
			text-align: center;
		}
	</style>
	<div class="container-fluid" id="container">	
		<% if (request.getAttribute("mensagem") != null) {%>
			<text>
				<script>
					Modal.renderSucesso('Agenda', '<%=request.getAttribute("mensagem")%>');				
				</script>
			</text>
		<%} %>
		
		<div class="row mb-5" style="background: rgba(0, 0, 0, 0.05);">
			<div class="col-md-6">
				<h1>Controle de Agendamentos</h1>
			</div>
			
			<div class="d-flex justify-content-end col-xl-6 mt-2">
				<div class="col-md-3">
				<div class="dropdown show">
					<a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    	Filtrar Agendas
					</a>
				
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item" href="ListarAgendas?tipo=1">Todas</a>
				    	<a class="dropdown-item" href="ListarAgendas?tipo=2">Agendadas</a>
				    	<a class="dropdown-item" href="ListarAgendas?tipo=3">Realizadas</a>
				    	<a class="dropdown-item" href="ListarAgendas?tipo=4">Canceladas</a>
				    	<a class="dropdown-item" href="ListarAgendas?tipo=5">Agendas do dia</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<a href="views/agenda/incluir_agenda.jsp" class="btn btn-success">
					Incluir agendamento
					<i class="fas fa-plus mx-1"></i>
				</a>	
			</div>
			</div>			
		</div>
		<table class="table table-striped">
			<tr>
				<td>Nome</td>
				<td>Vacina</td>
				<td class="alignCenter">Data</td>
				<td>Hora</td>
				<td>Situação</td>
				<td class="alignCenter">Detalhes</td>
				<td class="alignCenter">Excluir</td>
			</tr>
			<% for(Agenda agenda : agendas) { %>
				<tr>
					<td><%=agenda.getUsuario().getNome()%></td>
					<td><%=agenda.getVacina().getTitulo()%></td>
					<td class="alignCenter"><%=dateFormat.format(agenda.getData())%></td>
					<td><%=agenda.getHora()%></td>
					<td><%=agenda.getSituacao()%></td>
					<td class="alignCenter"><a href="VisualizarAgenda?id=<%=agenda.getId()%>"><i class="fas fa-info-circle"></i></a></td>
					<td class="alignCenter"><a href="ExcluirAgenda?id=<%=agenda.getId()%>"><i class="fas fa-trash"></i></a></td>
				</tr>
			<% } %>
			
		</table>	
			<br/>
			<a href="index.html" class="btn btn-secondary mt-3">
				<i class="fas fa-arrow-left me-1"></i>
				Voltar ao menu principal
			</a>
		</div>	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>

