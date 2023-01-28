package servlets.usuario;

import java.io.IOException;

import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirUsuario")
public class ExcluirUsuario  extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;

    public void init() {
    	usuarioDao = new UsuarioDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	usuarioDao.deleteUsuario(id);;
        response.sendRedirect("ListarUsuarios");
    }
}
