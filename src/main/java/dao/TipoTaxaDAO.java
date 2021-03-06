package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.TipoTaxa;

public class TipoTaxaDAO {

	public List<TipoTaxa> list() {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from TipoTaxa t");						
			List<TipoTaxa> lista = q.list();
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
	
	
	public TipoTaxa listByName(String nome) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from TipoTaxa t where t.taxaNome like :taxaNome");									
			q.setString("taxaNome", "%"+nome+"%");
			TipoTaxa tipoTaxa = (TipoTaxa) q.uniqueResult();
			tx.commit();
			return tipoTaxa;

		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}

	}
	

}
