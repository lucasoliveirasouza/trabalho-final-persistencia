package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;


import models.Vacina;
import util.HibernateUtil;

public class VacinaDao {
	
	private EntityManager entityManager;
    public VacinaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void incluir(Vacina vacina){
        entityManager.getTransaction().begin();
        entityManager.persist(vacina);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public List<Vacina> getAllVacinas(){
        entityManager.getTransaction().begin();
        List<Vacina> vacinas = entityManager.createQuery("select v from Vacina as v").getResultList();
        entityManager.getTransaction().commit();
        
        return vacinas;
    }
    
    public Vacina getVacina(int id){
        entityManager.getTransaction().begin();
        Vacina vacina = entityManager.find(Vacina.class,id);
        entityManager.getTransaction().commit();
        return vacina;
    }
    
    public void deleteVacina(int id){
        Vacina vacinadel = entityManager.find(Vacina.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(vacinadel);
        entityManager.getTransaction().commit();
    }
    
    public Vacina alterarVacina(Vacina vacina){
        entityManager.getTransaction().begin();
        Vacina vacinaAlterada = entityManager.merge(vacina);
        entityManager.getTransaction().commit();
        return vacinaAlterada;
    }  

}
