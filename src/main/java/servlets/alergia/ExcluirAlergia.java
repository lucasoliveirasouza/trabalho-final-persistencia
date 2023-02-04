package servlets.alergia;

import java.io.IOException;

import javax.persistence.EntityManager;

import dao.AlergiaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.JPAUtil;

@WebServlet("/ExcluirAlergia")
public class ExcluirAlergia extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	en = JPAUtil.getEntityManager();
    	AlergiaDao alergiaDao = new AlergiaDao(en);
    	alergiaDao.deleteAlergia(id);;
        response.sendRedirect("ListarAlergias");
    }
}
