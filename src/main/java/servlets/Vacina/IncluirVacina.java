package servlets.Vacina;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import dao.VacinaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Vacina;
import util.JPAUtil;


@WebServlet("/IncluirVacina")
public class IncluirVacina  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	
    	String titulo = request.getParameter("txtTitulo"); 
       	String descricao = request.getParameter("txtDescricao"); int doses =
      	Integer.valueOf(request.getParameter("txtDoses")); int periodicidade =
       	Integer.valueOf(request.getParameter("selPeriodicidade")); int intervalo =
      	Integer.valueOf(request.getParameter("txtIntervalo"));
        	
       	Vacina vacina = new Vacina(titulo, descricao, doses, periodicidade,intervalo);
        	
       	en = JPAUtil.getEntityManager();
    	VacinaDao vacinaDao = new VacinaDao(en);
    	vacinaDao.incluir(vacina);
    	 
       	response.sendRedirect("ListarVacinas");
    }

}
