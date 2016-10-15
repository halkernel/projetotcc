package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Escola;
import entity.EscolaTaxa;

public class EscolaTaxaDAO {
	
	public EscolaTaxa list(int id){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();			
			Query q = session.createQuery("from EscolaTaxa e where e.escola.id =:id");						
			q.setInteger("id", id);			
			EscolaTaxa escolaTaxa = (EscolaTaxa) q.uniqueResult();		
			tx.commit();			
			return escolaTaxa;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}

	}

}
