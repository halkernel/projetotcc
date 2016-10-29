package bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
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
	private List<Escola> escolasSource = new ArrayList<Escola>();
	private List<Escola> escolasTarget = new ArrayList<Escola>();


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

		escolasSource.addAll(escolas);         
		escolasEscolha = new DualListModel<Escola>(escolasSource, escolasTarget);


	}
	
	public void checaSelecao(){
		System.err.println("passou aki 35");

	}

	public void checaEscolasSelecionadas(){		
		int i = 9;
		i++;
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.openDialog("PF('dlg2').show()");
		System.out.println("passou aki 35");
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

	public List<Escola> getEscolasSource() {
		return escolasSource;
	}

	public void setEscolasSource(List<Escola> escolasSource) {
		this.escolasSource = escolasSource;
	}

	public List<Escola> getEscolasTarget() {
		return escolasTarget;
	}

	public void setEscolasTarget(List<Escola> escolasTarget) {
		this.escolasTarget = escolasTarget;
	}





}
