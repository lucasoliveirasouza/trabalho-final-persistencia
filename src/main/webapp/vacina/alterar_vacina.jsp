<%@page import="java.util.ArrayList"%>
<%@page import="models.Vacina" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	Vacina vacina = (Vacina) request.getAttribute("vacina");

%>

<html>
<head>
<meta charset="UTF-8">
<title>Alterar Vacina</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<h3>Alterar Vacina</h3>
		
		<form action="AlterarVacina" method="POST">
			<div class="row">
					<div class="form-group col-md-2">
						<label>Id:</label>
						<input class="form-control" type="text" value="<%=vacina.getId()%>" name="txtId" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Titulo:</label>
						<input class="form-control" type="text" value="<%=vacina.getTitulo()%>" name="txtTitulo" />
					</div>
					
					<div class="form-group col-md-6">
						<label>Descricao:</label>
						<input class="form-control" type="text" value="<%=vacina.getDescricao()%>" name="txtDescricao" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Doses:</label>
						<input class="form-control" type="text" value="<%=vacina.getDoses()%>" name="txtDoses" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Periodicidade:</label>
						<select name="selPeriodicidade" class="form-control" value="<%=vacina.getPeriodicidade()%>">
							<option value="1">Dias</option>
							<option value="2">Semanas</option>
							<option value="3">Meses</option>
							<option value="4">Anos</option>
						</select>
					</div>
					
					<div class="form-group col-md-4">
						<label>Intervalo:</label>
						<input class="form-control" type="text" value="<%=vacina.getIntervalo()%>" name="txtIntervalo" />
					</div>
					
				</div>
				
		
				<br>
				
				<input class="btn btn-primary" type="submit" value="Gravar">
				
				<a href="ListarVacinas" class="btn btn-secondary">Voltar ao menu</a>
			
			
			
		</form>
	</div>	
</body>
</html>