package servlets.agenda;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.AgendaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;
import util.JPAUtil;


@WebServlet("/ListarAgendas")
public class ListarAgendas extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int tipo = Integer.parseInt(request.getParameter("tipo"));
    	
    	en = JPAUtil.getEntityManager();
    	AgendaDao agendaDao = new AgendaDao(en);
    	
    	List <Agenda> listaAgenda = agendaDao.getAllAgendas(tipo);
        request.setAttribute("lista", listaAgenda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agenda/agenda.jsp");
        dispatcher.forward(request, response);
    }
}
