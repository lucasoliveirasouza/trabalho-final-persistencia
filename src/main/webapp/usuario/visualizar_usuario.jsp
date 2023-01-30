<%@page import="java.util.ArrayList"%>
<%@page import="models.Usuario" %>
<%@page import="models.Alergia" %>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Usuario usuario = (Usuario) request.getAttribute("usuario");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Informações sobre o usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
<style>
	.info-usuario{
		border: 1px solid var(--bs-gray-500);;
    	width: 50%;
    	border-radius: 0.5rem;
    	margin-top: 2rem;
    	box-shadow: 1px 1px 6px 1px var(--bs-dark);
	}
</style>
<div class="container-fluid">
	<div class="d-flex justify-content-center mt-3 w-100">
		<h4 class="me-2" style="color: var(--bs-gray-700);">Informações sobre o usuario</h4>
		<i class="fas fa-info-circle mt-1" style="color: var(--bs-blue); font-size: 1.4rem;"></i>
	</div>
	<div class="container-fluid d-flex justify-content-center info-usuario">
		<div class="w-100 mt-3">
			<ul style="list-style-type: none; font-size:18pt; color: var(--bs-gray-700);">
				<li>Nome do usuario: <%=usuario.getNome()%></li>
			<% if (usuario.getSexo() == 'M') {%>
				<li>Sexo: Masculino</li>
			<%}else{%>
				<li>Sexo: Feminino</li>
			<%} %>
			</ul>
		</div>
	</div>	
	
	<div class="container-fluid">
		<% if (usuario.getAlergias().isEmpty()) {%>
				<h4>O usuario nao possui alergias</h1>
			<%}else{%>
				<h4>Alergias do usuario</h1>
				<table class="table table-striped">
					<tr>
						<td>Codigo</td>
						<td>Nome</td>
					</tr>
				<% for(Alergia alergia : usuario.getAlergias()) { %>
					<tr>
						<td><%=alergia.getId() %></td>
						<td><%=alergia.getNome()%></td>
					</tr>
			<% } %>
			
				</table>
			<%} %>
	</div>
	
	<a href="ListarUsuarios" class="btn btn-secondary mt-3">
		<i class="fas fa-arrow-left me-1"></i>
		Voltar ao menu
	</a>
</div>
	
</body>
</html>