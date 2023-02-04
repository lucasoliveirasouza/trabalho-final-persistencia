package servlets.usuario;

import java.io.IOException;
import java.util.List;

import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;

@WebServlet("/ListarAgendamentos")
public class ListarAgendamentos extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;

    public void init() {
    	usuarioDao = new UsuarioDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int idUser = Integer.parseInt(request.getParameter("id"));
    	List <Agenda> listaAgenda = usuarioDao.getAllAgendasUsuario(idUser);
        request.setAttribute("lista", listaAgenda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario/visualizar_agendamentos.jsp");
        dispatcher.forward(request, response);
    }
}
