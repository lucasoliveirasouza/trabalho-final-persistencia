package servlets.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import models.Usuario;
import util.JPAUtil;

@WebServlet("/VisualizarUsuario")
public class VisualizarUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	en = JPAUtil.getEntityManager();
    	UsuarioDao usuarioDao = new UsuarioDao(en);
    	
    	Usuario usuario = usuarioDao.getUsuario(id);
    	
    	
    	
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/usuario/visualizar_usuario.jsp");
        dispatcher.forward(request, response);
    }
}
