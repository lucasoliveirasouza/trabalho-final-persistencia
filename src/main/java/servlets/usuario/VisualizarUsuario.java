package servlets.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import models.Usuario;

@WebServlet("/VisualizarUsuario")
public class VisualizarUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;

    public void init() {
    	usuarioDao = new UsuarioDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	Usuario usuario = usuarioDao.getUsuario(id);
    	
    	
    	List<Alergia> alergias = usuarioDao.getAllAlergiaUsuarios(id);
    	usuario.setAlergias(alergias);
    	
    	
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario/visualizar_usuario.jsp");
        dispatcher.forward(request, response);
    }
}
