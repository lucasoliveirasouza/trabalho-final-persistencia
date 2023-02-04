package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Alergia;

import util.HibernateUtil;

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
    
    public void deleteAlergia(int id){
    	Alergia alergiadeletada = entityManager.find(Alergia.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(alergiadeletada);
        entityManager.getTransaction().commit();
    }
    
    public Alergia alterarAlergia(Alergia alergia){
        entityManager.getTransaction().begin();
        Alergia alergiaAlterada = entityManager.merge(alergia);
        entityManager.getTransaction().commit();
        return alergiaAlterada;
    } 
}
