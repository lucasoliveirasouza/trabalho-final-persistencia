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
			<div class="col-md-9">
				<h1>Controle de usuarios</h1>
			</div>
			<div class="col-md-3 mt-2" style="width: 13%;margin-left: 10rem;">
				<a href="usuario/incluir_usuario.html" class="btn btn-success">
					Incluir usuario
					<i class="fas fa-plus mx-1"></i>
				</a>	
			</div>
		</div>
		<table class="table table-striped">
			<tr>
				<td>Código</td>
				<td>Nome</td>
				<td class="alignCenter">Sexo</td>
				<td class="alignCenter">Alterar</td>
				<td class="alignCenter">Excluir</td>
			</tr>
			<% for(Usuario user : usuarios) { %>
				<tr>
					<td><%=user.getId() %></td>
					<td>
						<a href="VisualizarUsuario?id=<%=user.getId()%>"><%=user.getNome()%></a>
					</td>
					<% if (user.getSexo() == 'M') {%>
						<td class="alignCenter">Masculino</td>
					<%}else{%>
						<td class="alignCenter">Feminino</td>
					<%} %>
					<td class="alignCenter"> <i class="fas fa-edit"></i> </td>
					<td class="alignCenter"><a href="ExcluirUsuario?id=<%=user.getId()%>"><i class="fas fa-trash"></i></a></td>
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

