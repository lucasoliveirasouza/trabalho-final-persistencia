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

@WebServlet("/ListarVacinas")
public class ListarVacinas  extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private VacinaDao vacinaDao;

    public void init() {
    	vacinaDao = new VacinaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	List <Vacina> listavacina = vacinaDao.getAllVacinas();
        request.setAttribute("lista", listavacina);
        RequestDispatcher dispatcher = request.getRequestDispatcher("vacina/vacina.jsp");
        dispatcher.forward(request, response);
    }
}
