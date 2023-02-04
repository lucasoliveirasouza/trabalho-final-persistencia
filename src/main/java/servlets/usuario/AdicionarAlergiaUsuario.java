package servlets.usuario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import dao.AlergiaDao;
import dao.UsuarioDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import models.Usuario;
import models.Vacina;
import util.JPAUtil;

@WebServlet("/AdicionarAlergiaUsuario")
public class AdicionarAlergiaUsuario extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EntityManager en;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int idAlergia = Integer.parseInt(request.getParameter("selAlergia"));
    	int id = Integer.parseInt(request.getParameter("txtId"));
    	
    	en = JPAUtil.getEntityManager();
    	AlergiaDao alergiaDao = new AlergiaDao(en);
    	Alergia alergia = alergiaDao.getAlergia(idAlergia);
    	
    	UsuarioDao usuarioDao = new UsuarioDao(en); 
       	
       	Usuario usuario = usuarioDao.getUsuario(id);
       	
	    usuario.getAlergias().add(alergia);
	     
	    usuarioDao.alterarUsuario(usuario);	
      
    	 
       	response.sendRedirect("VisualizarUsuario?id="+id);
    }
}
