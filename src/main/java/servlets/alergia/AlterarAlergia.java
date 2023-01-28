package servlets.alergia;

import java.io.IOException;

import dao.AlergiaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;


@WebServlet("/AlterarAlergia")
public class AlterarAlergia  extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private AlergiaDao alergiaDao;

    public void init() {
    	alergiaDao = new AlergiaDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.valueOf(request.getParameter("txtId"));
    	String nome = request.getParameter("txtNome"); 
 
        	
       	Alergia alergia = new Alergia(id,nome);
        	
       	
       	alergiaDao.alterarAlergia(alergia);
    	 
       	response.sendRedirect("ListarAlergias");
    	
    }
}
