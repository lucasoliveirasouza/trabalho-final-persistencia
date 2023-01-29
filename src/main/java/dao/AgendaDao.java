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
	
	
    public List <Agenda> getAllAgendas() {

        Transaction transaction = null;
        List <Agenda> listaAgenda = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
            
            listaAgenda = session.createQuery("from Agenda").getResultList();

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
