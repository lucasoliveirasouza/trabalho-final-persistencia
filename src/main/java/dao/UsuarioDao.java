package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Alergia;
import models.Usuario;
import util.HibernateUtil;

public class UsuarioDao {
	
	
	public void incluirUsuario(Usuario usuario){
		
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	
            // start a transaction
            transaction = session.beginTransaction();
            
            session.save(usuario);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
	}
	
	
    public List <Usuario> getAllUsuarios() {

        Transaction transaction = null;
        List <Usuario> listaUsuario = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
            
            listaUsuario  = session.createQuery("from Usuario").getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listaUsuario;
    }
    
    public List <Alergia> getAllAlergiaUsuarios(int id) {

        Transaction transaction = null;
        List <Alergia> listaAlergiasUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            
            transaction = session.beginTransaction();
            
            Query query =session.createQuery("Select p from Alergia p join fetch p.usuarios f where f.id=:id");
            query.setParameter("id", id);
            
            listaAlergiasUser  = query.getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listaAlergiasUser;
    }
    
    public void deleteUsuario(int id) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, id);
            if (usuario != null) {
                session.delete(usuario);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void alterarUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public Usuario getUsuario(int id) {

        Transaction transaction = null;
        Usuario usuario = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            usuario = session.get(Usuario.class, id);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuario;
    }

}
