package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Alergia;
import util.HibernateUtil;

public class AlergiaDao {
	
	public void incluirAlergia(Alergia alergia){
		
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            // start a transaction
            transaction = session.beginTransaction();
            
            session.save(alergia);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
	}
	
	
    public List <Alergia> getAllAlergias() {

        Transaction transaction = null;
        List <Alergia> listaAlergia = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
            
            listaAlergia = session.createQuery("from Alergia").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listaAlergia;
    }
    
    public void deleteAlergia(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Alergia alergia = session.get(Alergia.class, id);
            if (alergia != null) {
                session.delete(alergia);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void alterarAlergia(Alergia alergia) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(alergia);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Alergia getAlergia(int id) {

        Transaction transaction = null;
        Alergia alergia = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            alergia = session.get(Alergia.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return alergia;
    }
}
