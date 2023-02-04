<%@page import="java.util.ArrayList"%>
<%@page import="models.Usuario" %>
<%@page import="models.Alergia" %>
<%@page import="dao.AlergiaDao" %>
<%@page import="java.util.List"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="util.JPAUtil"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	EntityManager en;
	en = JPAUtil.getEntityManager();
	AlergiaDao alergiaDao = new AlergiaDao(en);
	List<Alergia> alergias = alergiaDao.getAllAlergias();
	Usuario usuario = (Usuario) request.getAttribute("usuario");
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
	
		<form action="AdicionarAlergiaUsuario" method="POST">
			<div class="w-100 mt-3">
				<ul style="list-style-type: none; font-size:18pt; color: var(--bs-gray-700);">
					<li>Nome do usuário: <%=usuario.getNome()%></li>
				<% if (usuario.getSexo() == 'M') {%>
					<li>Sexo: Masculino</li>
				<%}else{%>
					<li>Sexo: Feminino</li>
					
				<%} %>
					
					<li>Data de nascimento: <%=dateFormat.format(usuario.getData_nascimento())%></li>
					<li>Endereço: <%=usuario.getLogradouro() + ", "+ usuario.getNumero() + ", "+usuario.getSetor() + ", " + usuario.getCidade() + " - " + usuario.getUf()%></li>
				</ul>
				<div >
					<% if (usuario.getAlergias().isEmpty()) {%>
						<h5>O usuário não possui alergias</h5>
					<%}else{%>
						<h5>O usuário possui as seguintes alergias:</h5>
						<table class="table">
							
						<% for(Alergia alergia : usuario.getAlergias()) { %>
							<tr>
								<td><%=alergia.getNome()%></td>
							</tr>
					<% } %>
					
						</table>
					<%} %>
				</div>
				
				<div class="row">
					<div class="col-md-6 form-group">
								<label>Alergia:</label>
								<select name="selAlergia" class="form-control">
									<%for(Alergia alergia : alergias) { %>
										<option value="<%=alergia.getId() %>"><%=alergia.getNome() %></option>
										
									<% } %>
								</select>
								<input type="text" value="<%=usuario.getId()%>" hidden name="txtId" />
						
					</div>
					<div class="col-md-3">
						<button class="btn btn-primary mt-3" type="submit">
							Incluir alergia
							
						</button>
					</div>
				</div> 
					
			</div>
		</form>
	</div>	
	<br/>
	<br/>
	
	
	
	<div class = "text-center mb-3 mt-4">
		<a href="ListarUsuarios" class="btn btn-secondary mt-3">
			<i class="fas fa-arrow-left me-1"></i>
			Voltar ao menu
		</a>
		
		<a href="ListarAgendamentos?id=<%=usuario.getId()%>" class="btn btn-primary mt-3">
			Visualizar Agendas
		</a>
	</div>
	
	
	
</div>
	
</body>
</html>