package servlets.Vacina;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import dao.VacinaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Vacina;
import util.JPAUtil;

@WebServlet("/ExcluirVacina")
public class ExcluirVacina extends HttpServlet{
	private EntityManager en;
	private static final long serialVersionUID = 1L;
   
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	throws ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	en = JPAUtil.getEntityManager();
    	VacinaDao vacinaDao = new VacinaDao(en);
        
        String retorno = vacinaDao.deleteVacina(id);
    	
    	if(retorno != null) {
    		String mensagem = "A vacina " + retorno + " foi excluída com sucesso!";
  		  
    		response.sendRedirect("ListarVacinas?mensagem="+mensagem);
    	}else {
    		String mensagem = "A vacina não pode ser deletada!";
    		response.sendRedirect("ListarVacinas?mensagem="+mensagem);
    	}
    }

}
