package servlets.usuario;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;
import util.JPAUtil;

@WebServlet("/ListarAgendamentos")
public class ListarAgendamentos extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int idUser = Integer.parseInt(request.getParameter("id"));
    	
    	en = JPAUtil.getEntityManager();
    	UsuarioDao usuarioDao = new UsuarioDao(en);
    	
    	List <Agenda> listaAgenda = usuarioDao.getAllAgendasUsuario(idUser);
        request.setAttribute("lista", listaAgenda);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuario/visualizar_agendamentos.jsp");
        dispatcher.forward(request, response);
    }
}
