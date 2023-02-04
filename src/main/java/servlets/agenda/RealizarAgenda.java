package servlets.agenda;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;

import dao.AgendaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;
import models.Situacao;
import util.JPAUtil;

@WebServlet("/RealizarAgenda")
public class RealizarAgenda  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		en = JPAUtil.getEntityManager();
    	AgendaDao agendaDao = new AgendaDao(en);
        Agenda agenda = agendaDao.getAgenda(id);
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
    	Date date = new Date();
    	dateFormat.format(date);
    	
    	agenda.setData_situacao(date);
        agenda.setSituacao(Situacao.Realizado);
        
        
		
       	agendaDao.alterarAgenda(agenda);
       	
       	response.sendRedirect("ListarAgendas?tipo=1");
		
	}
}
