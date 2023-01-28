package servlets.Vacina;

import java.io.IOException;

import dao.VacinaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Vacina;

@WebServlet("/AlterarVacina")
public class AlterarVacina extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private VacinaDao vacinaDao;

    public void init() {
    	vacinaDao = new VacinaDao();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.valueOf(request.getParameter("txtId"));
    	String titulo = request.getParameter("txtTitulo"); 
       	String descricao = request.getParameter("txtDescricao"); 
       	int doses = Integer.valueOf(request.getParameter("txtDoses")); 
       	int periodicidade = Integer.valueOf(request.getParameter("selPeriodicidade")); 
       	int intervalo = Integer.valueOf(request.getParameter("txtIntervalo"));
        	
       	Vacina vacina = new Vacina(id,titulo, descricao, doses, periodicidade,intervalo);
        	
       	VacinaDao vdao = new VacinaDao(); 
       	vdao.alterarVacina(vacina);
    	 
       	response.sendRedirect("ListarVacinas");
    	
    }
}
