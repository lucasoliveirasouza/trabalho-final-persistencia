package servlets.agenda;

import java.io.IOException;
import java.util.List;

import dao.AgendaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;


@WebServlet("/ListarAgendas")
public class ListarAgendas extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private AgendaDao agendaDao;

    public void init() {
    	agendaDao = new AgendaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	List <Agenda> listaAgenda = agendaDao.getAllAgendas();
        request.setAttribute("lista", listaAgenda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("agenda/agenda.jsp");
        dispatcher.forward(request, response);
    }
}
