package servlets.alergia;

import java.io.IOException;

import javax.persistence.EntityManager;

import dao.AlergiaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Alergia;
import util.JPAUtil;


@WebServlet("/VisualizarAlergia")
public class VisualizarAlergia extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private EntityManager en;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		en = JPAUtil.getEntityManager();
    	AlergiaDao alergiaDao = new AlergiaDao(en);
    	
        Alergia alergia = alergiaDao.getAlergia(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/alergia/visualizar_alergia.jsp");
		request.setAttribute("alergia", alergia);
	
		rd.forward(request, response);
		
	}
}

