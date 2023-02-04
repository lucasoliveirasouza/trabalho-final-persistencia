package servlets.usuario;

import java.io.IOException;

import javax.persistence.EntityManager;

import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JPAUtil;

@WebServlet("/ExcluirUsuario")
public class ExcluirUsuario  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	en = JPAUtil.getEntityManager();
    	UsuarioDao usuarioDao = new UsuarioDao(en);
    	
        
        String retorno = usuarioDao.deleteUsuario(id);
    	
    	if(retorno != null) {
    		String mensagem = "O usuário " + retorno + " foi excluído com sucesso!";
  		  
    		response.sendRedirect("ListarUsuarios?mensagem="+mensagem);
    	}else {
    		String mensagem = "O usuário não pode ser deletado!";
    		response.sendRedirect("ListarUsuarios?mensagem="+mensagem);
    	}
    }
}
