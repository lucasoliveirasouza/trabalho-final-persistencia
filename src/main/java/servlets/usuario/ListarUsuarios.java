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
import models.Usuario;
import util.JPAUtil;


@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	en = JPAUtil.getEntityManager();
    	UsuarioDao usuarioDao = new UsuarioDao(en);
    	
    	List <Usuario> listaUsuario = usuarioDao.getAllUsuarios();
        request.setAttribute("lista", listaUsuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario/usuario.jsp");
        dispatcher.forward(request, response);
    }
}
