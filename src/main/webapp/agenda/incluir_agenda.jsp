<%@page import="java.util.ArrayList"%>
<%@page import="models.Usuario" %>
<%@page import="dao.UsuarioDao" %>
<%@page import="models.Vacina" %>
<%@page import="dao.VacinaDao" %>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="util.JPAUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>

  <%
  EntityManager en;
  en = JPAUtil.getEntityManager();
	VacinaDao vacinaDao = new VacinaDao(en);
	List <Vacina> vacinas = vacinaDao.getAllVacinas();
  
  
  UsuarioDao usuarioDao = new UsuarioDao(en);
	List <Usuario> usuarios = usuarioDao.getAllUsuarios();
	
	
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar agenda</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
</head>
<body>
	<div class="w-100 mb-4" style="background: rgba(0, 0, 0, 0.05);">
		<h1 class="mx-3">Incluir novo agendamento</h1>
	</div>
	<div class="container-fluid">
		<form action="../IncluirAgenda" method="POST">
			<div class="row">
				<div class="form-group col-md-4">
					<label>Usuário:</label>
					<select name="selUsuario" class="form-control">
						<% for(Usuario user : usuarios) { %>
							<option value="<%=user.getId() %>"><%=user.getNome() %></option>
							
						<% } %>
					</select>
				</div>
				<div class="form-group col-md-4">
					<label>Vacinas:</label>
					<select name="selVacina" class="form-control">
						<% for(Vacina vacina : vacinas) { %>
							<option value="<%=vacina.getId() %>"><%=vacina.getTitulo() %></option>
							
						<% } %>
					</select>
				</div>
				
				<div class="form-group col-md-2">
					<label>Data:</label>
					<input class="form-control" type="date" value="" name="dtData" />
				</div>
				
				<div class="form-group col-md-2">
					<label>Hora:</label>
					<input class="form-control" type="time" value="" name="tmHora" />
				</div>
				
				<div class="form-group col-md-12">
					<label>Observações:</label>
					<textarea class="form-control" name="txtObservacoes"></textarea>
				</div>
			</div>
			
			<br>
			<a href="../ListarAgendas?tipo=1" class="btn btn-secondary mt-3 me-2">
				<i class="fas fa-arrow-left me-1"></i>
				Voltar ao menu
			</a>			
			<button class="btn btn-primary mt-3" type="submit">
				Gravar
				<i class="fas fa-save mx-1"></i>
			</button>
		</form>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>