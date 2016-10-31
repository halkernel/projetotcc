package bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import dao.EscolaDAO;
import dao.TipoTaxaDAO;
import entity.Escola;
import entity.TipoTaxa;
import util.ConverteString;

@ManagedBean
@ViewScoped
public class BuscaAvancadaBean {

	private DualListModel<Escola> escolasEscolha = new DualListModel<>();
	private List<Escola> escolas;
	private String nomeEscola;
	private List<Escola> escolasSource = new ArrayList<Escola>();
	private List<Escola> escolasTarget = new ArrayList<Escola>();
		
	private List<TipoTaxa> taxas;
	
	private LinkedList<String> taxasEscolha = new LinkedList<>();


	private String taxaSelecionada = "";
	private String dimensaoSelecionada = "";
	
	private String dialogHeader ="";
	private String dialogValue ="";
	
	public BuscaAvancadaBean(){
		iniciaTaxas();
		iniciaTaxasEscolha();
	}


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
	
	public boolean checaEscolhaMenor(){
		if(escolasEscolha.getTarget().size() < 2)
			return true;
		return false;
	}
	
	public boolean checaEscolhaMaior(){
		if(escolasEscolha.getTarget().size() > 2)
			return true;
		return false;
	}
	
	public boolean checaSelecaoTaxa(){
		if(taxaSelecionada == null || taxaSelecionada == ""){
			System.out.println("true");
			return true;
		}		
		return false;
	}
	
	
	public void naoSelecionou(){		
		this.dialogHeader = "Número de Escolas Insifucientes";
		this.dialogValue = "Você não selecionou o número de escolas suficientes para uma comparação";		
	}
	
	public void selecionouMaisDeDuasEscolas(){		
		this.dialogHeader = "Número de Escolas Acima do Permitido";
		this.dialogValue = "O limite de escolas para comparação é 2. Você selecionou um número acima do permitido.";
	}
	
	public void naoSelecionouTaxa(){
		this.dialogHeader = "Taxa Não Selecionadas";
		this.dialogValue = "A taxa não foi selecionada para comparação.";
	}
	
	
	public void showDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').show();");
	}
	
	
	public void checarEscola(){		
		if(checaEscolhaMenor()){
			naoSelecionou();	
			showDialog();
		}		
		else if(checaEscolhaMaior()){
			selecionouMaisDeDuasEscolas();
			showDialog();
		}
		else if(checaSelecaoTaxa()){			
			naoSelecionouTaxa();
			showDialog();
			
		}		
	}
	
	

	
	public void iniciaTaxas(){
		//pegar valor do banco
		TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
		taxas = tipoTaxaDao.list();					
	}
	
	public void iniciaTaxasEscolha(){
		for (TipoTaxa tt : taxas) {
			taxasEscolha.add(tt.getTaxaNome());
		}
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


	
	public void setTaxas(List<TipoTaxa> taxas) {
		this.taxas = taxas;
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

	public String getDialogHeader() {
		return dialogHeader;
	}

	public void setDialogHeader(String dialogHeader) {
		this.dialogHeader = dialogHeader;
	}

	public String getDialogValue() {
		return dialogValue;
	}

	public void setDialogValue(String dialogValue) {
		this.dialogValue = dialogValue;
	}


	public String getTaxaSelecionada() {
		return taxaSelecionada;
	}


	public void setTaxaSelecionada(String taxaSelecionada) {
		this.taxaSelecionada = taxaSelecionada;
	}


	public String getDimensaoSelecionada() {
		return dimensaoSelecionada;
	}


	public void setDimensaoSelecionada(String dimensaoSelecionada) {
		this.dimensaoSelecionada = dimensaoSelecionada;
	}


	public LinkedList<String> getTaxasEscolha() {
		return taxasEscolha;
	}


	public void setTaxasEscolha(LinkedList<String> taxasEscolha) {
		this.taxasEscolha = taxasEscolha;
	}

	
	
	




}
