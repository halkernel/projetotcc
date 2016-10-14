package config;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Dependencia;
import entity.Escola;
import entity.EscolaTaxa;
import entity.Estado;
import entity.Localizacao;
import entity.Municipio;
import entity.Regiao;
import entity.TipoTaxa;


public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	
	static {
        try {
        	Configuration config = new Configuration();
        	
        	config.addAnnotatedClass(Municipio.class);
        	config.addAnnotatedClass(Escola.class);
        	config.addAnnotatedClass(Estado.class);
        	config.addAnnotatedClass(Dependencia.class);
        	config.addAnnotatedClass(Localizacao.class);
        	config.addAnnotatedClass(Regiao.class);
        	config.addAnnotatedClass(TipoTaxa.class);
        	config.addAnnotatedClass(EscolaTaxa.class);
        	
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
