package teste;

import java.util.Properties;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import bean.Escola;
import bean.Estado;
import bean.Municipio;


public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
        try {
        	Configuration config = new Configuration();
        	
        	config.addAnnotatedClass(Municipio.class);
        	config.addAnnotatedClass(Escola.class);
        	config.addAnnotatedClass(Estado.class);
        	
            sessionFactory = config.configure().buildSessionFactory();
            
            
        } catch (Throwable ex) {
            // Log exception!
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
	

}
