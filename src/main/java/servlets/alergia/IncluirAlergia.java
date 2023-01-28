package servlets.alergia;

import java.io.IOException;

import dao.AlergiaDao;
import dao.VacinaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import models.Vacina;

@WebServlet("/IncluirAlergia")
public class IncluirAlergia extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	
    	String nome = request.getParameter("txtAlergia"); 
       	
        Alergia alergia = new Alergia(nome);
       
        	
       	AlergiaDao alergiaDao = new AlergiaDao(); 
       	alergiaDao.incluirAlergia(alergia);
    	 
       	response.sendRedirect("ListarAlergias");
    }

}
