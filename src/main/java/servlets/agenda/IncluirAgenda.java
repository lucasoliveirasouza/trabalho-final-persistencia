
package servlets.agenda;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dao.AgendaDao;
import dao.UsuarioDao;
import dao.VacinaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Agenda;
import models.Situacao;
import models.Usuario;
import models.Vacina;


@WebServlet("/IncluirAgenda")
public class IncluirAgenda extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		    	
		 
		 String dataRecebida = request.getParameter("dtData"); 
		 String hora = request.getParameter("tmHora"); 
		 String observacoes = request.getParameter("txtObservacoes");
		 int idUsuario = Integer.valueOf(request.getParameter("selUsuario")); 
		 System.out.println(dataRecebida);
		 int idVacina = Integer.valueOf(request.getParameter("selVacina")); 
		 DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd"); 
		 java.sql.Date data = null;
		 try {
			 data = new java.sql.Date(fmt.parse(dataRecebida).getTime());
		 } catch (ParseException e) {
			 e.printStackTrace();
		 }
		 
		 java.sql.Date dataSituacao = null;
		
		 UsuarioDao usuarioDao = new UsuarioDao();
		 Usuario usuario = usuarioDao.getUsuario(idUsuario);
		 
		 VacinaDao vacinaDao = new VacinaDao();
		 Vacina vacina = vacinaDao.getVacina(idVacina);
		 
		 AgendaDao agendaDao = new AgendaDao(); 
		 
		 for(int i = 0; i<vacina.getDoses();i++) {
			 Agenda agenda = new Agenda(data,hora,Situacao.Agendado,dataSituacao, observacoes,usuario,vacina);
			 agendaDao.incluirAgenda(agenda);
			 
			 try {
				data = novaData(fmt.format(data).toString(),vacina.getPeriodicidade(), vacina.getIntervalo());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }

		    	 
		response.sendRedirect("ListarAgendas");
	}
	 
	private java.sql.Date novaData(String dataString, int periodicidade, int intervalo) throws ParseException {

		java.sql.Date data = null;
        DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(formato.parse(dataString));
        if(periodicidade == 1) {
        	c.add(Calendar.DATE, intervalo);
        }else if(periodicidade == 2) {
        	c.add(Calendar.WEEK_OF_MONTH, intervalo);
        }else if(periodicidade == 3) {
        	c.add(Calendar.MONTH, intervalo);
        }else {
        	c.add(Calendar.YEAR, intervalo);
        }
        
        dataString = formato.format(c.getTime());


        data = new java.sql.Date(formato.parse(dataString).getTime());

        return data;
		
	}
}
