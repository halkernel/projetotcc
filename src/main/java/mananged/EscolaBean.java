package mananged;

import java.util.List;

import javax.faces.bean.ManagedBean;

import bean.Escola;
import dao.EscolaDAO;

@ManagedBean
public class EscolaBean {
	
	private List<Escola> escolas;
	private String nomeEscola;
	
	
	public void buscar(){
		EscolaDAO escolaDao = new EscolaDAO();
		escolas = escolaDao.list();
	}
	
	public void buscarPorNome(){
		EscolaDAO escolaDao = new EscolaDAO();
		escolas = escolaDao.listByName(nomeEscola);
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	
	
	
}
