<%@page import="java.util.ArrayList"%>
<%@page import="models.Alergia" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	List<Alergia> alergias = (List<Alergia>) request.getAttribute("lista");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Alergias</title>
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
		
		
		<div class="row mb-5" style="background: rgba(0, 0, 0, 0.05);">
			<div class="col-md-9">
				<h1>Controle de alergias</h1>
			</div>
			
			<div class="col-md-3 mt-2" style="width: 13%;margin-left: 10rem;">
				<a href="alergia/incluir_alergia.html" class="btn btn-success">
					Incluir alergia
					<i class="fas fa-plus mx-1"></i>
				</a>	
			</div>
		</div>
		<% if (request.getAttribute("mensagem") != null) {%>
			<text>
				<script>
					Modal.renderSucesso('Alergia', '<%=request.getAttribute("mensagem")%>');				
				</script>
			</text>
		<%} %>	
		<table class="table table-striped">
			<tr>
				<td>Código</td>
				<td>Nome</td>
				<td class="alignCenter">Alterar</td>
				<td class="alignCenter">Excluir</td>
			</tr>
			<% for(Alergia alergia : alergias) { %>
				<tr>
					<td><%=alergia.getId() %></td>
					<td>
						<a href="VisualizarAlergia?id=<%=alergia.getId()%>"><%=alergia.getNome()%></a>
					</td>
					<td class="alignCenter"> <a href="BuscarAlergia?id=<%=alergia.getId()%>"><i class="fas fa-edit"></i> </a> </td>
					<td class="alignCenter"><a href="ExcluirAlergia?id=<%=alergia.getId()%>"><i class="fas fa-trash"></i></a></td>
				</tr>
			<% } %>
		</table>
		<br/>
		
		<div class = "text-center mb-3 mt-4">
		
		</div>
		<a href="index.html" class="btn btn-secondary mt-3">
			<i class="fas fa-arrow-left me-1"></i>
			Voltar ao menu principal
		</a>
		
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

