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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="views/css/geral.css">
<script src="views/js/modal.js" crossorigin="anonymous"></script>
<script src="views/js/geral.js" crossorigin="anonymous"></script>
</head>
<body>

	<style>
		.alignCenter{
			text-align: center;
		}
	</style>
	
	<div class="container-fluid" id="container">
		
		
		<div class="row mb-5" style="background: rgba(0, 0, 0, 0.05);">
			<div class="col-md-9">
				<h1>Controle de Vacinas</h1>
			</div>
			
			<div class="col-md-3 mt-2" style="width: 13%;margin-left: 10rem;">
				<a href="views/vacina/incluir_vacina.html" class="btn btn-success">
					Incluir vacina
					<i class="fas fa-plus mx-1"></i>
				</a>	
			</div>
		</div>
		<% if (request.getAttribute("mensagem") != null) {%>
			<text>
				<script>
					Modal.renderSucesso('Vacina', '<%=request.getAttribute("mensagem")%>');				
				</script>
			</text>
		<%} %>
		<table class="table table-striped">
			<tr>
				<td>Código</td>
				<td>Titulo</td>
				<td>Descrição</td>
				<td class="alignCenter">Doses</td>
				<td class="alignCenter">Periodicidade</td>
				<td class="alignCenter">Intevalo</td>
				<td class="alignCenter">Alterar</td>
				<td class="alignCenter">Excluir</td>
			</tr>
			<% for(Vacina van : vacinas) { %>
				<tr>
					<td><%=van.getId() %></td>
					<td>
						<a href="VisualizarVacina?id=<%=van.getId()%>"><%=van.getTitulo()%></a>
					</td>
					<td><%=van.getDescricao()%></td>
					<td class="alignCenter"><%=van.getDoses()%></td>
					<% if (van.getPeriodicidade() == 1) {%>
						<td class="alignCenter">Dias</td>
					<%}else if(van.getPeriodicidade() == 2){%>
						<td class="alignCenter">Semanas</td>
					<%}else if (van.getPeriodicidade() == 3) {%>
						<td class="alignCenter">Meses</td>
					<%}else{%>
						<td class="alignCenter">Anos</td>
					<%} %>
					<td class="alignCenter"><%=van.getIntervalo()%></td>
					<td class="alignCenter"> <a href="BuscarVacina?id=<%=van.getId()%>"><i class="fas fa-edit"></i> </a> </td>
					<td class="alignCenter"><a href="ExcluirVacina?id=<%=van.getId()%>"><i class="fas fa-trash"></i></a></td>
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

