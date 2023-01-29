<%@page import="java.util.ArrayList"%>
<%@page import="models.Vacina" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	List<Vacina> vacinas = (List<Vacina>) request.getAttribute("lista");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Vacinas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<% if (request.getAttribute("mensagem") != null) {%>
			<p style="color:red"><%=request.getAttribute("mensagem") %></p>
		<%} %>
		<div class="row mb-5" style="background: rgba(0, 0, 0, 0.05);">
			<div class="col-md-9">
				<h1>Controle de Vacinas</h1>
			</div>
			
			<div class="col-md-3 mt-2" style="width: 13%;margin-left: 10rem;">
				<a href="vacina/incluir-vacina.html" class="btn btn-success">
					Incluir vacina
					<i class="fas fa-plus mx-1"></i>
				</a>	
			</div>
		</div>
		<table class="table table-striped">
			<tr>
				<td>Código</td>
				<td>Titulo</td>
				<td>Descrição</td>
				<td>Doses</td>
				<td>Periodicidade</td>
				<td>Intevalo</td>
				<td>Alterar</td>
				<td>Excluir</td>
			</tr>
			<% for(Vacina van : vacinas) { %>
				<tr>
					<td><%=van.getId() %></td>
					<td>
						<a href="VisualizarVacina?id=<%=van.getId()%>"><%=van.getTitulo()%></a>
					</td>
					<td><%=van.getDescricao()%></td>
					<td><%=van.getDoses()%></td>
					<td><%=van.getPeriodicidade()%></td>
					<td><%=van.getIntervalo()%></td>
					<td> <a href="BuscarVacina?id=<%=van.getId()%>"><i class="fas fa-edit"></i> </a> </td>
					<td><a href="ExcluirVacina?id=<%=van.getId()%>"><i class="fas fa-trash"></i></a></td>
				</tr>
			<% } %>
			
		</table>
		<br/>
		<a href="index.html" class="btn btn-secondary mt-3">
			<i class="fas fa-arrow-left me-1"></i>
			Voltar ao menu principal
		</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

