package servlets.alergia;

import java.io.IOException;

import javax.persistence.EntityManager;

import dao.AlergiaDao;
import dao.VacinaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import models.Vacina;
import util.JPAUtil;

@WebServlet("/IncluirAlergia")
public class IncluirAlergia extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	
    	String nome = request.getParameter("txtAlergia"); 
       	
        Alergia alergia = new Alergia(nome);
       
    	en = JPAUtil.getEntityManager();
    	AlergiaDao alergiaDao = new AlergiaDao(en);
    	
       
       	alergiaDao.incluirAlergia(alergia);
    	 
       	response.sendRedirect("ListarAlergias");
    }

}
