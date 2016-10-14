package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.EscolaDAO;
import entity.Escola;
import util.ConverteString;
import util.Rota;

@ManagedBean
@ViewScoped
public class EscolaBean {
	
	private List<Escola> escolas;
	private String nomeEscola;
	
	@PostConstruct
	public void init(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}
	
	
	public void buscar(){
		EscolaDAO escolaDao = new EscolaDAO();
		escolas = escolaDao.list();
	}
	
	public void buscarPorNome(){
		EscolaDAO escolaDao = new EscolaDAO();
		nomeEscola = ConverteString.removeAcento(nomeEscola);
		nomeEscola = nomeEscola.toUpperCase();
		System.out.println(nomeEscola);
		escolas = escolaDao.listByName(nomeEscola);		
	}
	
	
	
	public void detalheEscola(){
		Rota.redireciona("escoladetalhe.xhtml");
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
