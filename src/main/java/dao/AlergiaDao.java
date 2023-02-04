package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Alergia;



public class AlergiaDao {
	
	private EntityManager entityManager;
    public AlergiaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void incluirAlergia(Alergia alergia){
        entityManager.getTransaction().begin();
        entityManager.persist(alergia);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public List<Alergia> getAllAlergias(){
        entityManager.getTransaction().begin();
        List<Alergia> alergias = entityManager.createQuery("select v from Alergia as v").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return alergias;
    }
    
    public Alergia getAlergia(int id){
        entityManager.getTransaction().begin();
        Alergia alergia = entityManager.find(Alergia.class,id);
        entityManager.getTransaction().commit();
        return alergia;
    }
    
    public String deleteAlergia(int id){
    	String retorno = null;
        try {
        	Alergia alergiadeletada = entityManager.find(Alergia.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(alergiadeletada);
            entityManager.getTransaction().commit();
            retorno = alergiadeletada.getNome();
          } catch(Exception ex) {
            entityManager.getTransaction().rollback();
          } finally {
            entityManager.close();
          }
        
        return retorno;
    }
    
    public Alergia alterarAlergia(Alergia alergia){
        entityManager.getTransaction().begin();
        Alergia alergiaAlterada = entityManager.merge(alergia);
        entityManager.getTransaction().commit();
        return alergiaAlterada;
    } 
}
