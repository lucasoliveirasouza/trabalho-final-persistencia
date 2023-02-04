package servlets.alergia;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/ListarAlergias")
public class ListarAlergias extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EntityManager en;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	en = JPAUtil.getEntityManager();
    	AlergiaDao alergiaDao = new AlergiaDao(en);
    	List <Alergia> listaAlergia = alergiaDao.getAllAlergias();
        request.setAttribute("lista", listaAlergia);
        request.setAttribute("mensagem", request.getParameter("mensagem"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("alergia/alergia.jsp");
        dispatcher.forward(request, response);
       
    }

}
