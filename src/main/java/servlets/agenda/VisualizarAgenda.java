package servlets.agenda;

import java.io.IOException;

import dao.AgendaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;


@WebServlet("/VisualizarAgenda")
public class VisualizarAgenda extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private AgendaDao agendaDao;

    public void init() {
    	agendaDao = new AgendaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
        Agenda agenda = agendaDao.getAgenda(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("agenda/alterar_agenda.jsp");
		request.setAttribute("agenda", agenda);
	
		rd.forward(request, response);
		
	}
}
