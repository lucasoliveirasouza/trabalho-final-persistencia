package servlets.usuario;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/AdicionarAlergiaUsuario")
public class AdicionarAlergiaUsuario extends HttpServlet{

	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	AlergiaDao alergiaDao = new AlergiaDao(); 
    	Alergia alergia = alergiaDao.getAlergia(5);
    	
    	UsuarioDao usuarioDao = new UsuarioDao(); 
       	
       	Usuario usuario = usuarioDao.getUsuario(id);
       	
      // 	usuario.getAlergias().add(alergia);
       //	alergia.getUsuarios().add(usuario);
       //	usuarioDao.alterarUsuario(usuario);
       	//alergiaDao.alterarAlergia(alergia);	
      
    	 
       	response.sendRedirect("ListarUsuarios");
    }
}
