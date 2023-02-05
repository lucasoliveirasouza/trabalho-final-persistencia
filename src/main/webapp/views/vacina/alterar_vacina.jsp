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
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="views/css/geral.css">
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
		<h1 class="mx-3">Alterar Vacina</h1>
	</div>
	<div class="container-fluid" id="container">
		<form id="form0" action="AlterarVacina" method="POST">
			<div class="row">
					<div class="form-group col-md-2">
						<label>Id:</label>
						<input readonly class="form-control" type="text" value="<%=vacina.getId()%>" name="txtId" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Titulo:</label>
						<input id="titulo" class="form-control" type="text" value="<%=vacina.getTitulo()%>" name="txtTitulo" />
					</div>
					
					<div class="form-group col-md-6">
						<label>Descricao:</label>
						<input id="descricao" class="form-control" type="text" value="<%=vacina.getDescricao()%>" name="txtDescricao" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Doses:</label>
						<input id="doses" class="form-control" type="text" value="<%=vacina.getDoses()%>" name="txtDoses" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Periodicidade:</label>
						<select name="selPeriodicidade" class="form-control" value="<%=vacina.getPeriodicidade()%>">
							<% if (vacina.getPeriodicidade() == 1) {%>
								<option selected value="1">Dias</option>
							<%}else{%>
								<option value="1">Dias</option>
							<%} %> 
							<% if (vacina.getPeriodicidade() == 2) {%>
								<option selected value="2">Semanas</option>
							<%}else{%>
								<option value="2">Semanas</option>
							<%} %>
							<% if (vacina.getPeriodicidade() == 3) {%>
								<option selected value="3">Meses</option>
							<%}else{%>
								<option value="3">Meses</option>
							<%} %>
							<% if (vacina.getPeriodicidade() == 4) {%>
								<option selected value="4">Anos</option>
							<%}else{%>
								<option value="4">Anos</option>
							<%} %>
						</select>
					</div>
					
					<div class="form-group col-md-4">
						<label>Intervalo:</label>
						<input id="intervalo" class="form-control" type="text" value="<%=vacina.getIntervalo()%>" name="txtIntervalo" />
					</div>					
				</div>
				<br>
				<a href="ListarVacinas" class="btn btn-secondary mt-3">
					<i class="fas fa-arrow-left me-1"></i>
					Voltar ao menu
				</a>
				<button class="btn btn-primary mt-3" type="button" onclick="aoAlterarVacina(this)">
					Gravar
					<i class="fas fa-save mx-1"></i>
				</button>
		</form>
	</div>	
	
	<script defer>
	const ehCampoValido = {
			"titulo": () => {
				const titulo = document.getElementById('titulo');
				if(!titulo.value.trim()){
					monteMensagem(titulo, 'Titulo', 'É necessário informar o titulo');
					return false;
				}
				removaEstadoInvalido(titulo);
				return true;
			},
			"descricao": () => {
				const descricao = document.getElementById('descricao');
				if(!descricao.value.trim()){
					monteMensagem(descricao, 'Descrição', 'É necessário informar a descrição');
					return false;
				}
				removaEstadoInvalido(descricao);
				return true;
			},
			"doses": () => {
				const doses = document.getElementById('doses');
				if(!doses.value.trim()){
					monteMensagem(doses, 'Doses', 'É necessário informar a quantidade de doses');
					return false;
				}
				removaEstadoInvalido(doses);
				return true;
			},
			"intervalo": () => {
				const intervalo = document.getElementById('intervalo');
				if(!intervalo.value.trim()){
					monteMensagem(intervalo, 'Intervalo', 'É necessário informar o tempo de intervalo');
					return false;
				}
				removaEstadoInvalido(intervalo);
				return true;
			}
	};
	
		function aoAlterarVacina(ev){
			let invalido;
			if(!ehCampoValido["titulo"]()) invalido = true;
			if(!ehCampoValido["descricao"]())invalido = true;
			if(!ehCampoValido["doses"]())invalido = true;
			if(!ehCampoValido["intervalo"]())invalido = true;
			if(invalido) return;
			
			const formulario = document.getElementById('form0');
			formulario.submit();
		}
	</script>
	<script src="views/js/modal.js" crossorigin="anonymous"></script>
	<script src="views/js/geral.js" crossorigin="anonymous"></script>
</body>
</html>