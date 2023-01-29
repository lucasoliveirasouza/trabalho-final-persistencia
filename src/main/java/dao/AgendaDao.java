package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Agenda;
import util.HibernateUtil;

public class AgendaDao {
	
	public void incluirAgenda(Agenda agenda){
		
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            // start a transaction
            transaction = session.beginTransaction();
            
            session.save(agenda);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
	}
	
	/* tipo = 1 ---> retorna todas as agendas
	 * tipo = 2 ---> retorna lista de agendas agendadas 
	 * tipo = 3 ---> retorna lista de agendas realizadas
	 * tipo = 4 ---> retorna lista de agendas canceladas
	 * tipo = 5 ---> retorna lista de agendas do dia*/
    public List <Agenda> getAllAgendas(int tipo) {

        Transaction transaction = null;
        List <Agenda> listaAgenda = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
            
            if(tipo == 1)
            	listaAgenda = session.createQuery("SELECT a FROM Agenda a ORDER BY a.situacao, a.data, a.hora").getResultList();
            else if(tipo == 2)
            	listaAgenda = session.createQuery("SELECT a FROM Agenda a where a.situacao=0 ORDER BY a.data, a.hora").getResultList();
            else if(tipo == 3)
            	listaAgenda = session.createQuery("SELECT a FROM Agenda a where a.situacao=1 ORDER BY a.data, a.hora").getResultList();
            else if(tipo == 4)
            	listaAgenda = session.createQuery("SELECT a FROM Agenda a where a.situacao=2 ORDER BY a.data, a.hora").getResultList();
            else
            	listaAgenda = session.createQuery("SELECT a FROM Agenda a WHERE CURRENT_DATE = a.data ORDER BY a.situacao ASC").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listaAgenda;
    }
    
    public void deleteAgenda(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Agenda agenda = session.get(Agenda.class, id);
            if (agenda != null) {
                session.delete(agenda);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void alterarAgenda(Agenda agenda) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(agenda);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Agenda getAgenda(int id) {

        Transaction transaction = null;
        Agenda agenda = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            agenda = session.get(Agenda.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return agenda;
    }
}
