package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Agenda;
import models.Alergia;
import models.Usuario;
import models.Vacina;


public class AgendaDao {
	
	private EntityManager entityManager;
    public AgendaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    
    public void incluirAgenda(Agenda agenda){
        entityManager.getTransaction().begin();
        entityManager.persist(agenda);
        entityManager.getTransaction().commit();
       
    }
    
    /* tipo = 1 ---> retorna todas as agendas
	 * tipo = 2 ---> retorna lista de agendas agendadas 
	 * tipo = 3 ---> retorna lista de agendas realizadas
	 * tipo = 4 ---> retorna lista de agendas canceladas
	 * tipo = 5 ---> retorna lista de agendas do dia*/
    public List<Agenda> getAllAgendas(int tipo){
        entityManager.getTransaction().begin();
        List <Agenda> listaAgenda = null;
        
        if(tipo == 1)
        	listaAgenda = entityManager.createQuery("SELECT a FROM Agenda a ORDER BY a.situacao, a.data, a.hora").getResultList();
        else if(tipo == 2)
        	listaAgenda = entityManager.createQuery("SELECT a FROM Agenda a where a.situacao=0 ORDER BY a.data, a.hora").getResultList();
        else if(tipo == 3)
        	listaAgenda = entityManager.createQuery("SELECT a FROM Agenda a where a.situacao=1 ORDER BY a.data, a.hora").getResultList();
        else if(tipo == 4)
        	listaAgenda = entityManager.createQuery("SELECT a FROM Agenda a where a.situacao=2 ORDER BY a.data, a.hora").getResultList();
        else
        	listaAgenda = entityManager.createQuery("SELECT a FROM Agenda a WHERE CURRENT_DATE = a.data ORDER BY a.situacao ASC").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return listaAgenda;
    }
    
    public Agenda getAgenda(int id){
        entityManager.getTransaction().begin();
        Agenda agenda = entityManager.find(Agenda.class,id);
        entityManager.getTransaction().commit();
        return agenda;
    }
    
    public String deleteAgenda(int id){
    	
        
        String retorno = null;
        try {
        	Agenda agendadeletada = entityManager.find(Agenda.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(agendadeletada);
            entityManager.getTransaction().commit();
            retorno = "Deletada";
          } catch(Exception ex) {
            entityManager.getTransaction().rollback();
          } finally {
            entityManager.close();
          }
        
        return retorno;
    }
    
    public Agenda alterarAgenda(Agenda agenda){
        entityManager.getTransaction().begin();
        Agenda agendaAlterada = entityManager.merge(agenda);
        entityManager.getTransaction().commit();
        return agendaAlterada;
    } 
    
    
    
    
    
    
}
