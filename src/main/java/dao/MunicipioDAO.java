package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Municipio;

public class MunicipioDAO {
	
	public Municipio listByName(String nome) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();		
			Query q = session.createQuery("from Municipio m where m.municipioNome like :municipioNome");							
			q.setString("municipioNome", "%"+nome+"%");			
			Municipio municipio = (Municipio) q.uniqueResult();			
			tx.commit();			
			return municipio;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}
	}

}
