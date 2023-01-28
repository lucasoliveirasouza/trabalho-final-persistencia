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
</head>
<body>
	<div class="container-fluid">
		<h3>Alterar Alergia</h3>
		
		<form action="AlterarAlergia" method="POST">
			<div class="row">
					<div class="form-group col-md-2">
						<label>Id:</label>
						<input class="form-control" type="text" value="<%=alergia.getId()%>" name="txtId" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Titulo:</label>
						<input class="form-control" type="text" value="<%=alergia.getNome()%>" name="txtNome" />
					</div>
			
					
				</div>
				
		
				<br>
				
				<input class="btn btn-primary" type="submit" value="Gravar">
				
				<a href="ListarAlergias" class="btn btn-secondary">Voltar ao menu</a>
			
			
			
		</form>
	</div>	
</body>
</html>