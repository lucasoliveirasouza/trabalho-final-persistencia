package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import models.Agenda;
import models.Alergia;
import models.Usuario;
import models.Vacina;

public class HibernateUtil {
	static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
         if (sessionFactory == null) {
        	
            try {
          
                 // Hibernate settings equivalent to hibernate.cfg.xml's properties
                 Properties settings = new Properties();
          
                 settings.put(Environment.DRIVER, "org.postgresql.Driver");
                
                 settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/vacinacao");
                 
                 settings.put(Environment.USER, "postgres");
                
                 settings.put(Environment.PASS, "vitor2303");
                
                 settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                
                 settings.put(Environment.SHOW_SQL, "true");
                
                 settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                 
                 settings.put(Environment.HBM2DDL_AUTO, "update");
                 
                 Configuration configuration = new Configuration();
				 configuration.setProperties(settings);
				 configuration.addAnnotatedClass(Vacina.class);
				 configuration.addAnnotatedClass(Alergia.class); 
				 configuration.addAnnotatedClass(Usuario.class);
				 configuration.addAnnotatedClass(Agenda.class);
				  ServiceRegistry serviceRegistry = new
				 StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				 
                 sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                 ;
                 return sessionFactory;

              } catch (Exception e) {
                 e.printStackTrace();
              }
          }
        
        return sessionFactory;
    }
    
}
