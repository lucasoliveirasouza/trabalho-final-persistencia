package servlets.alergia;

import java.io.IOException;

import javax.persistence.EntityManager;

import dao.AlergiaDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import util.JPAUtil;


@WebServlet("/AlterarAlergia")
public class AlterarAlergia  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;

   
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.valueOf(request.getParameter("txtId"));
    	String nome = request.getParameter("txtNome"); 
 
        	
       	Alergia alergia = new Alergia(id,nome);
        	
       	en = JPAUtil.getEntityManager();
    	AlergiaDao alergiaDao = new AlergiaDao(en);
       	alergiaDao.alterarAlergia(alergia);
    	 
       	String mensagem = "A alergia " + nome + " foi alterada com sucesso!";
		  
		response.sendRedirect("ListarAlergias?mensagem="+mensagem);
    	
    }
}
