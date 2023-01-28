package servlets.Vacina;

import java.io.IOException;
import java.util.List;

import dao.VacinaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Vacina;

@WebServlet("/ExcluirVacina")
public class ExcluirVacina extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    private VacinaDao vacinaDao;

    public void init() {
    	vacinaDao = new VacinaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	vacinaDao.deleteVacina(id);;
        response.sendRedirect("ListarVacinas");
    }

}
