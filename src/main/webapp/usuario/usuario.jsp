<%@page import="java.util.ArrayList"%>
<%@page import="models.Usuario" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	List<Usuario> usuarios = (List<Usuario>) request.getAttribute("lista");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
	
		
		<% if (request.getAttribute("mensagem") != null) {%>
			<p style="color:red"><%=request.getAttribute("mensagem") %></p>
		<%} %>
		
		<div class="row">
			<div class="col-md-9">
				<h1>Controle de Usuarios</h1>
			</div>
			
			<div class="col-md-3">
				<a href="vacina/incluir-vacina.html" class="btn btn-success">Incluir vacina</a>	
			</div>
		</div>
		<table class="table table-striped">
			<tr>
				<td>Código</td>
				<td>Nome</td>
				<td>Sexo</td>
				<td>Alterar</td>
				<td>Excluir</td>
			</tr>
			<% for(Usuario user : usuarios) { %>
				<tr>
					<td><%=user.getId() %></td>
					<td><%=user.getNome()%></td>
					<td><%=user.getSexo()%></td>
					<td> <i class="fas fa-edit"></i> </td>
					<td><a href="ExcluirUsuario?id=<%=user.getId()%>"><i class="fas fa-trash"></i></a></td>
				</tr>
			<% } %>
			
		</table>
		

		<br/>
		<a href="index.html" class="btn btn-secondary">Voltar ao menu principal</a>
	
	</div>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>

