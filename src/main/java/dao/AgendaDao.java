package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Agenda;
import models.Usuario;
import models.Vacina;
import util.HibernateUtil;

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
    
    public void deleteAgenda(int id){
    	Agenda agendadeletada = entityManager.find(Agenda.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(agendadeletada);
        entityManager.getTransaction().commit();
    }
    
    public Agenda alterarAgenda(Agenda agenda){
        entityManager.getTransaction().begin();
        Agenda agendaAlterada = entityManager.merge(agenda);
        entityManager.getTransaction().commit();
        return agendaAlterada;
    } 
    
    public List<Usuario> getAllUsuarios(){
        entityManager.getTransaction().begin();
        List<Usuario> usuarios = entityManager.createQuery("select u from Usuario as u").getResultList();
        entityManager.getTransaction().commit();
        return usuarios;
    }
    
    public List<Vacina> getAllVacinas(){
        entityManager.getTransaction().begin();
        List<Vacina> vacinas = entityManager.createQuery("select v from Vacina as v").getResultList();
        entityManager.getTransaction().commit();
        
        return vacinas;
    }
    
    
    public Usuario getUsuario(int id){
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.getTransaction().commit();
        return usuario;
    }
    
    public Vacina getVacina(int id){
        entityManager.getTransaction().begin();
        Vacina vacina = entityManager.find(Vacina.class,id);
        entityManager.getTransaction().commit();
        return vacina;
    }

    
    
    
    
}
