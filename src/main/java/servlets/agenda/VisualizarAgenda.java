package servlets.agenda;

import java.io.IOException;

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


@WebServlet("/VisualizarAgenda")
public class VisualizarAgenda extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		en = JPAUtil.getEntityManager();
    	AgendaDao agendaDao = new AgendaDao(en);
        Agenda agenda = agendaDao.getAgenda(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("agenda/alterar_agenda.jsp");
		request.setAttribute("agenda", agenda);
	
		rd.forward(request, response);
		
	}
}
