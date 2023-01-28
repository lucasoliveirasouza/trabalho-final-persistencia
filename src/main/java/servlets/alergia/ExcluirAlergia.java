package servlets.alergia;

import java.io.IOException;

import dao.AlergiaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExcluirAlergia")
public class ExcluirAlergia extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private AlergiaDao alergiaDao;

    public void init() {
    	alergiaDao = new AlergiaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	alergiaDao.deleteAlergia(id);;
        response.sendRedirect("ListarAlergias");
    }
}
