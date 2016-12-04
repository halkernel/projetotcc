package dao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
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
	
	public List<EscolaTaxa> listTaxas(int id_escola){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();			
			Query q = session.createQuery("from EscolaTaxa e where e.escola.id =:id");						
			q.setInteger("id", id_escola);			
			List<EscolaTaxa> escolasTaxas = q.list();				
			tx.commit();			
			return escolasTaxas;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}
	}


	public EscolaTaxa listByIdAndSchool(int id_taxa, int id_escola) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		 
		try {
			tx = session.beginTransaction();			
			Query q = session.createQuery("from EscolaTaxa e where e.escola.id = :idEscola and e.tipoTaxa.id = :idTaxa");						
			q.setInteger("idTaxa", id_taxa);
			q.setInteger("idEscola", id_escola);			
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

	public List<EscolaTaxa> listByMunicipioAndTaxa(int id_municipio, int id_taxa) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
//			Query q = session.createQuery("from EscolaTaxa as est inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id = :idMunicipio and est.tipoTaxa.id = :idTaxa");
			Query q = session.createQuery("from EscolaTaxa as est  WHERE est.escola.municipio.id = :idMunicipio and est.tipoTaxa.id = :idTaxa");
			//inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id in :id");
			q.setParameter("idMunicipio", id_municipio);
			q.setParameter("idTaxa", id_taxa);
			//45934
			List<EscolaTaxa> escolasTaxas = q.list();
			tx.commit();			
			return escolasTaxas;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}	
	}
	
	public List<EscolaTaxa> listByEstadoAndTaxa(int id_estado, int id_taxa) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
//			Query q = session.createQuery("from EscolaTaxa as est inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id = :idMunicipio and est.tipoTaxa.id = :idTaxa");
			Query q = session.createQuery("from EscolaTaxa as est  WHERE est.escola.municipio.estado.id = :idEstado and est.tipoTaxa.id = :idTaxa");
			//inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id in :id");
			q.setParameter("idEstado", id_estado);
			q.setParameter("idTaxa", id_taxa);
			//45934
			List<EscolaTaxa> escolasTaxas = q.list();
			tx.commit();			
			return escolasTaxas;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}	
	}
	
	public List<EscolaTaxa> listByRegiaoAndTaxa(int id_regiao, int id_taxa) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();			
//			Query q = session.createQuery("from EscolaTaxa as est inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id = :idMunicipio and est.tipoTaxa.id = :idTaxa");
			Query q = session.createQuery("from EscolaTaxa as est  WHERE est.escola.municipio.estado.regiao.id = :idRegiao and est.tipoTaxa.id = :idTaxa");
			//inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id in :id");
			q.setParameter("idRegiao", id_regiao);
			q.setParameter("idTaxa", id_taxa);
			//45934
			List<EscolaTaxa> escolasTaxas = q.list();
			tx.commit();			
			return escolasTaxas;
			
		} catch (RuntimeException e) {
			tx.rollback();
			throw e; // or display error message
		} finally {
			session.clear();
			session.close();
		}	
	}

}
