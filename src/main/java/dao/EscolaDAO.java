package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Escola;
import teste.HibernateUtil;

public class EscolaDAO {

	
	public List<Escola> list(){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();
			
			Query q = session.createQuery("from Escola e where e.municipio.id =:id");
			
			q.setMaxResults(400);
			
			q.setInteger("id", new Integer(2));
			
			List<Escola> lista = q.list();
			
			tx.commit();
			
			return lista;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}

	}

	public List<Escola> listByName(String nome) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();		
			Query q = session.createQuery("from Escola e where e.escolaNome like :escolaNome");							
			q.setString("escolaNome", "%"+nome+"%");			
			List<Escola> lista = q.list();			
			tx.commit();			
			return lista;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}
	}
	
}
