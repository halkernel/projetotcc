package bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import dao.EscolaDAO;
import entity.Escola;
import util.ConverteString;

@ManagedBean
@ViewScoped
public class BuscaAvancadaBean {
	
	private DualListModel<Escola> escolasEscolha = new DualListModel<>();
	private List<Escola> escolas;
	private String nomeEscola;

     
    @PostConstruct
    public void init() {

     }
    
    public DualListModel<Escola> getEscolasEscolha() {
		return escolasEscolha;
	}

	public void setEscolasEscolha(DualListModel<Escola> escolasEscolha) {
		this.escolasEscolha = escolasEscolha;
	}

	public void buscarPorNome(){
		EscolaDAO escolaDao = new EscolaDAO();
		nomeEscola = ConverteString.removeAcento(nomeEscola);
		nomeEscola = nomeEscola.toUpperCase();
		System.out.println(nomeEscola);
		escolas = escolaDao.listByName(nomeEscola);	
		
		
        List<Escola> escolasSource = new ArrayList<Escola>();
        List<Escola> escolasTarget = new ArrayList<Escola>();
               
        
        escolasSource.addAll(escolas);         
        escolasEscolha = new DualListModel<Escola>(escolasSource, escolasTarget);
		
		
    }
    
    
    public void onSelect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Selected", event.getObject().toString()));
    }
     
    public void onUnselect(UnselectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item Unselected", event.getObject().toString()));
    }
     
    public void onReorder() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "List Reordered", null));
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
