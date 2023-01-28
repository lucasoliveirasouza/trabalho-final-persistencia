package servlets.alergia;

import java.io.IOException;
import java.util.List;

import dao.AlergiaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;


@WebServlet("/ListarAlergias")
public class ListarAlergias extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    private AlergiaDao alergiaDao;

    public void init() {
    	alergiaDao = new AlergiaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	List <Alergia> listaAlergia = alergiaDao.getAllAlergias();
        request.setAttribute("lista", listaAlergia);
        RequestDispatcher dispatcher = request.getRequestDispatcher("alergia/alergia.jsp");
        dispatcher.forward(request, response);
    }

}
