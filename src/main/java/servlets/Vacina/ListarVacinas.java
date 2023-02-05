package servlets.Vacina;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/ListarVacinas")
public class ListarVacinas  extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private EntityManager en;

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	en = JPAUtil.getEntityManager();
    	VacinaDao vacinaDao = new VacinaDao(en);
    	List <Vacina> listavacina = vacinaDao.getAllVacinas();
        request.setAttribute("lista", listavacina);
        request.setAttribute("mensagem", request.getParameter("mensagem"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/vacina/vacina.jsp");
        dispatcher.forward(request, response);
    }
}
