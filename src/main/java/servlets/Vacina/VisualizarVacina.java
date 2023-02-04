package servlets.Vacina;

import java.io.IOException;

import javax.persistence.EntityManager;

import dao.VacinaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Vacina;
import util.JPAUtil;


@WebServlet("/VisualizarVacina")
public class VisualizarVacina extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private EntityManager en;
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        
		en = JPAUtil.getEntityManager();
    	VacinaDao vacinaDao = new VacinaDao(en);
		Vacina vacina = vacinaDao.getVacina(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("vacina/visualizar_vacina.jsp");
		request.setAttribute("vacina", vacina);
	
		rd.forward(request, response);
		
	}
}

