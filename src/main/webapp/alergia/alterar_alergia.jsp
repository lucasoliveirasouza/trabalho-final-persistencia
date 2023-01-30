<%@page import="java.util.ArrayList"%>
<%@page import="models.Alergia" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Alergia alergia = (Alergia) request.getAttribute("alergia");

%>

<html>
<head>
<meta charset="UTF-8">
<title>Alterar Alergia</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
	<style>
	input[readonly]{
				cursor: default;
	    		background-color: #e9ecef;
	    		opacity: 1;
			}
	</style>
	<div class="w-100 mb-4" style="background: rgba(0, 0, 0, 0.05);">
		<h1 class="mx-3">Alterar alergia</h1>
	</div>
	<div class="container-fluid">		
		<form action="AlterarAlergia" method="POST">
			<div class="row">
					<div class="form-group col-md-2">
						<label>Id:</label>
						<input readonly class="form-control" type="text" value="<%=alergia.getId()%>" name="txtId" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Titulo:</label>
						<input class="form-control" type="text" value="<%=alergia.getNome()%>" name="txtNome" />
					</div>
				</div>
				<br>
				<a href="ListarAlergias" class="btn btn-secondary mt-3">
					<i class="fas fa-arrow-left me-1"></i>
					Voltar ao menu
				</a>
				<button class="btn btn-primary mt-3" type="submit">
					Gravar
					<i class="fas fa-save mx-1"></i>
				</button>
		</form>
	</div>	
</body>
</html>