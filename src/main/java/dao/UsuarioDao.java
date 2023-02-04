package dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.Agenda;
import models.Alergia;
import models.Usuario;
import util.HibernateUtil;

public class UsuarioDao {
	
	private EntityManager entityManager;
    public UsuarioDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    
    public void incluirUsuario(Usuario usuario){
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public List<Usuario> getAllUsuarios(){
        entityManager.getTransaction().begin();
        List<Usuario> usuarios = entityManager.createQuery("select u from Usuario as u").getResultList();
        entityManager.getTransaction().commit();
        return usuarios;
    }
    
    public Usuario getUsuario(int id){
        entityManager.getTransaction().begin();
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.getTransaction().commit();
        return usuario;
    }
    
    public void deleteUsuario(int id){
    	Usuario usuarioDeletado = entityManager.find(Usuario.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(usuarioDeletado);
        entityManager.getTransaction().commit();
    }
    
    public Usuario alterarUsuario(Usuario usuario){
        entityManager.getTransaction().begin();
        Usuario usuarioAlterado = entityManager.merge(usuario);
        entityManager.getTransaction().commit();
        return usuarioAlterado;
    } 
    
    
    public List <Agenda> getAllAgendasUsuario(int id) {

    	List <Agenda> listaAgendasUser = null;
    	entityManager.getTransaction().begin();
    	listaAgendasUser = entityManager.createQuery("Select a from Agenda a where a.usuario.id=:id").setParameter("id", id).getResultList();
        entityManager.getTransaction().commit();
        return listaAgendasUser;
    }
    
   

	
}
