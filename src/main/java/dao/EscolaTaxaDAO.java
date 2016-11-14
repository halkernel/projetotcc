package dao;

import java.util.Arrays;
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
	
	public List<EscolaTaxa> listMunicipio(Integer[] values){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		List<Integer> ids = Arrays.asList(values);		
		try {
			tx = session.beginTransaction();			
			Query q = session.createSQLQuery("SELECT escola_taxa.id, escola_taxa.id_escola, escola_taxa.id_taxa, primeiro_ano_m, segundo_ano_m, terceiro_ano_m, quarto_ano_m "
					+ "primeiro_ano, segundo_ano, terceiro_ano, quarto_ano, quinto_ano,"
					+ "sexto_ano, setimo_ano, oitavo_ano, nono_ano, creche, pre_escola, primeiro_ao_quinto,"
					+ "sexto_ao_nono, turmas_unificadas, medio_nao_seriado, total_medio,"
					+ "total_fundamental, total_infantil FROM escola_taxa INNER JOIN escola "
					+ "ON(escola_taxa.id_escola = escola.id) WHERE escola.id_municipio in :values");		
			q.setParameterList("values", ids);
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
	
	public List<EscolaTaxa> listMunicipioJoin(Integer[] values){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		List<Integer> ids = Arrays.asList(values);		
		System.out.println(values[0]);
		for (Integer integer : ids) {
			System.out.println(integer);
		}
		try {
			tx = session.beginTransaction();			
			Query q = session.createQuery("from EscolaTaxa as est inner join fetch est.escola as esc inner join fetch esc.municipio as mun WHERE mun.id in :values");		
			q.setParameterList("values", ids);
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
