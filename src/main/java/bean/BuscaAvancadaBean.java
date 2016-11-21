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
import org.primefaces.push.PrimeAtmosphereHandler;

import dao.EscolaDAO;
import dao.TipoTaxaDAO;
import entity.Escola;
import entity.TipoTaxa;
import util.ConverteValor;
import util.PegaValores;
import util.Rota;

@ManagedBean
@ViewScoped
public class BuscaAvancadaBean {

	private List<Escola> escolas;
	private String nomePrimeiraEscola = "";
	private String nomeSegundaEscola = "";

	private List<Escola> escolasSource = new ArrayList<Escola>();
	private List<Escola> escolasTarget = new ArrayList<Escola>();
	private DualListModel<Escola> escolasEscolha = new DualListModel<>();



	private List<TipoTaxa> taxas;

	private LinkedList<String> taxasEscolha = new LinkedList<>();

	private String primeiraEscola ="";
	private String segundaEscola ="";
	
	private int idPrimeiraEscola = 0;
	private int idSegundaEscola = 0;

	private String taxaSelecionada = "";
	private String dimensaoSelecionada = "";

	private String dialogHeader ="";
	private String dialogValue ="";
	private String buttonValue ="";

	private boolean renderedConfirm = false;
	private boolean renderedCancel = false;

	public BuscaAvancadaBean(){
		iniciaTaxas();
		iniciaTaxasEscolha();
	}

	@PostConstruct
	public void init(){
		try{
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		}
		catch (IllegalStateException e) {
			e.printStackTrace();
		}
	}



	public void buscarPorNome(){
		EscolaDAO escolaDao = new EscolaDAO();
		nomePrimeiraEscola = ConverteValor.removeAcento(nomePrimeiraEscola);
		nomeSegundaEscola = ConverteValor.removeAcento(nomeSegundaEscola);
		nomePrimeiraEscola = nomePrimeiraEscola.toUpperCase();
		nomeSegundaEscola = nomeSegundaEscola.toUpperCase();
		escolas = escolaDao.listByNameOneNameTwo(nomePrimeiraEscola, nomeSegundaEscola);						
		escolasSource.addAll(escolas);				
		escolasEscolha = new DualListModel<>(escolasSource, escolasTarget);

	}

	public void redirecionaDetalhes(){
		Rota.redireciona("detalheDuasEscolas.xhtml");
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
			return true;
		}		
		return false;
	}


	public void naoSelecionou(){		
		this.dialogHeader = "Número De Escolas Insifucientes";
		this.dialogValue = "Você não selecionou o número de escolas suficientes para uma comparação";
		this.buttonValue = "Cancelar";
		renderedConfirm = false;
		renderedCancel = true;
	}

	public void selecionouMaisDeDuasEscolas(){		
		this.dialogHeader = "Número De Escolas Acima Do Permitido";
		this.dialogValue = "O limite de escolas para comparação é 2. Você selecionou um número acima do permitido.";
		this.buttonValue = "Cancelar";
		renderedConfirm = false;
		renderedCancel = true;
	}

	public void naoSelecionouTaxa(){
		this.dialogHeader = "Taxa Não Selecionadas";
		this.dialogValue = "A taxa não foi selecionada para comparação.";
		this.buttonValue = "Cancelar";
		renderedConfirm = false;
		renderedCancel = true;
		
	}

	public void confirmarValores(){
		this.dialogHeader = "Você Selecionou Os Seguintes Valores";
		this.dialogValue = "Primeira Escola: " + nomePrimeiraEscola + "</br>" + "Segunda Escola: " + nomeSegundaEscola;
		this.buttonValue = "Confirmar";
		renderedConfirm = true;
		renderedCancel = false;
	}

	public void preencherTudo(){
		this.dialogHeader = "Você Não Preencheu A Primeira Escola E/Ou A Segunda Escola";
		this.dialogValue = "Você não selecionou o número de escolas suficientes para a pesquisa";
		this.buttonValue = "Cancelar";
		renderedConfirm = false;
		renderedCancel = true;
	}

	public void confirmarValoresFinais(){
		this.dialogHeader = "Você Selecionou Os Seguintes Valores";
		this.dialogValue = "Primeira Escola: " + primeiraEscola + "</br>" + "Segunda Escola: " + segundaEscola + "</br>" + "Indicador: " + taxaSelecionada;
		this.buttonValue = "Confirmar";
		renderedConfirm = true;
		renderedCancel = false;
	}

	public void showDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg3').show();");
	}

	public void showDialogBusca(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg').show();");
	}


	public boolean checaPrimeiraEscola(){
		if(nomePrimeiraEscola == null || nomePrimeiraEscola.isEmpty()){			
			return false;
		}		
		return true;
	}

	public boolean checaSegundaEscola(){
		if(nomeSegundaEscola == null || nomeSegundaEscola.isEmpty()){			
			return false;
		}		
		return true;
	}


	public void checarNomes(){
		if(!checaPrimeiraEscola() || !checaSegundaEscola()){			
			preencherTudo();
			showDialogBusca();
		}
		else{
			confirmarValores();
			showDialogBusca();
		}
	}


	public void checarEscola(){		
		if(checaEscolhaMenor()){
			System.out.println("menor");
			naoSelecionou();	
			showDialog();
		}		
		else if(checaEscolhaMaior()){
			System.out.println("maior");
			selecionouMaisDeDuasEscolas();
			showDialog();
		}
		else if(checaSelecaoTaxa()){			
			System.out.println("taxa");
			naoSelecionouTaxa();
			showDialog();			
		}		
		else{
			pegaEscolas();
			confirmarValoresFinais();			
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
	
	public void pegaEscolas(){
		for(int i =0; i < escolasEscolha.getTarget().size(); i++){
			if(primeiraEscola.isEmpty()){
				primeiraEscola = escolasEscolha.getTarget().get(i).getEscolaNome();
				idPrimeiraEscola = escolasEscolha.getTarget().get(i).getId();
			}
			else{
				segundaEscola = escolasEscolha.getTarget().get(i).getEscolaNome();
				idSegundaEscola = escolasEscolha.getTarget().get(i).getId();
			}
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



	public String getNomePrimeiraEscola() {
		return nomePrimeiraEscola;
	}


	public void setNomePrimeiraEscola(String nomePrimeiraEscola) {
		this.nomePrimeiraEscola = nomePrimeiraEscola;
	}


	public String getNomeSegundaEscola() {
		return nomeSegundaEscola;
	}


	public void setNomeSegundaEscola(String nomeSegundaEscola) {
		this.nomeSegundaEscola = nomeSegundaEscola;
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

	public DualListModel<Escola> getEscolasEscolha() {
		return escolasEscolha;
	}

	public void setEscolasEscolha(DualListModel<Escola> escolasEscolha) {
		this.escolasEscolha = escolasEscolha;
	}


	public String getButtonValue() {
		return buttonValue;
	}


	public void setButtonValue(String buttonValue) {
		this.buttonValue = buttonValue;
	}


	public boolean isRenderedConfirm() {
		return renderedConfirm;
	}


	public void setRenderedConfirm(boolean renderedConfirm) {
		this.renderedConfirm = renderedConfirm;
	}


	public boolean isRenderedCancel() {
		return renderedCancel;
	}


	public void setRenderedCancel(boolean renderedCancel) {
		this.renderedCancel = renderedCancel;
	}

	public String getPrimeiraEscola() {
		return primeiraEscola;
	}

	public void setPrimeiraEscola(String primeiraEscola) {
		this.primeiraEscola = primeiraEscola;
	}

	public String getSegundaEscola() {
		return segundaEscola;
	}

	public void setSegundaEscola(String segundaEscola) {
		this.segundaEscola = segundaEscola;
	}

	public int getIdPrimeiraEscola() {
		return idPrimeiraEscola;
	}

	public void setIdPrimeiraEscola(int idPrimeiraEscola) {
		this.idPrimeiraEscola = idPrimeiraEscola;
	}

	public int getIdSegundaEscola() {
		return idSegundaEscola;
	}

	public void setIdSegundaEscola(int idSegundaEscola) {
		this.idSegundaEscola = idSegundaEscola;
	}

	
	








}
