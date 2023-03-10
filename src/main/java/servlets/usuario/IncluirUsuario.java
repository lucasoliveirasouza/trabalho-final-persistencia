package servlets.usuario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import dao.AlergiaDao;
import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import models.Usuario;
import util.JPAUtil;


@WebServlet("/IncluirUsuario")
public class IncluirUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	
    	String nome = request.getParameter("txtNome"); 
    	String dataRecebida = request.getParameter("dtDataNasc"); 
       	String sexoRecebido = request.getParameter("selSexo"); 
       	String logradouro = request.getParameter("txtLogradouro");
       	int numero = Integer.valueOf(request.getParameter("txtNumero")); 
       	String setor = request.getParameter("txtSetor");
    	String cidade = request.getParameter("txtCidade");
    	String uf = request.getParameter("selUF");
    	char sexo = sexoRecebido.charAt(0);
    	DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
    	java.sql.Date data = null;
		try {
			data = new java.sql.Date(fmt.parse(dataRecebida).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<Alergia> alergias = new ArrayList<Alergia>();
    	
    	
        	
       	
        	
       	en = JPAUtil.getEntityManager();
    	UsuarioDao usuarioDao = new UsuarioDao(en);
    	
    	Usuario usuario = new Usuario(nome, data,sexo, logradouro, numero, setor, cidade, uf, alergias);
       	usuarioDao.incluirUsuario(usuario);
       	
       	String mensagem = "O usu??rio " + nome + " foi incluido com sucesso!";
		  
		response.sendRedirect("ListarUsuarios?mensagem="+mensagem);
    	 
       	
    }
}
