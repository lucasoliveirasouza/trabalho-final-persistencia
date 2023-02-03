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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
<link rel="stylesheet" href="css/geral.css">
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
	<div class="container-fluid" id="container">		
		<form action="AlterarAlergia" method="POST" id="form0">
			<div class="row">
					<div class="form-group col-md-2">
						<label>Id:</label>
						<input readonly class="form-control" type="text" value="<%=alergia.getId()%>" name="txtId" />
					</div>
					
					<div class="form-group col-md-4">
						<label>Titulo:</label>
						<input id="nome" class="form-control" type="text" value="<%=alergia.getNome()%>" name="txtNome" />
					</div>
				</div>
				<br>
				<a href="ListarAlergias" class="btn btn-secondary mt-3">
					<i class="fas fa-arrow-left me-1"></i>
					Voltar ao menu
				</a>
				<button class="btn btn-primary mt-3" type="button" onclick="aoAlterarAlergia(this)">
					Gravar
					<i class="fas fa-save mx-1"></i>
				</button>
		</form>
	</div>	
	<script defer>
		const ehCampoValido = {
				"nome": () => {
					const nome = document.getElementById('nome');
					if(!nome.value.trim()){
						monteMensagem(nome, 'Nome', 'É necessário informar o nome para a alergia');
						return false;
					}
					removaEstadoInvalido(nome);
					return true;
				}
		};
	
		function aoAlterarAlergia(ev){
			let invalido;
			if(!ehCampoValido["nome"]()) invalido = true;
			if(invalido) return;
			
			const formulario = document.getElementById('form0');
			formulario.submit();
		}
		
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<script src="js/modal.js" crossorigin="anonymous"></script>
	<script src="js/geral.js" crossorigin="anonymous"></script>
</body>
</html>