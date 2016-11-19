package bean;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import dao.EscolaDAO;
import dao.TipoTaxaDAO;
import entity.Escola;
import entity.TipoTaxa;
import util.ConverteValor;
import util.Rota;

@ManagedBean
@ViewScoped
public class ComparaEscolaBean {

	private List<Escola> escolas;
	private String nomeEscola;

	private LinkedList<String> dimensao = new LinkedList<>();
	private List<TipoTaxa> taxas;

	private LinkedList<String> taxasEscolha = new LinkedList<>();


	private String taxaSelecionada = "";
	private String dimensaoSelecionada = "";

	private String dialogHeader ="";
	private String dialogValue ="";
	
	private String buttonValue ="";
	
	private boolean renderedConfirm = false;
	private boolean renderedCancel = false;
	
	private int escolaSelecionada;


	public ComparaEscolaBean(){
		iniciaTaxas();
		iniciaDimensao();
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


	public void buscar(){
		EscolaDAO escolaDao = new EscolaDAO();
		escolas = escolaDao.list();
	}

	public void buscarPorNome(){
		EscolaDAO escolaDao = new EscolaDAO();
		nomeEscola = ConverteValor.removeAcento(nomeEscola);
		nomeEscola = nomeEscola.toUpperCase();
		System.out.println(nomeEscola);
		escolas = escolaDao.listByName(nomeEscola);		
	}


	public boolean checaSelecaoTaxa(){
		if(taxaSelecionada == null || taxaSelecionada == "")			
			return false;		
		return true;
	}

	public boolean checaSelecaoDimensao(){
		if(dimensaoSelecionada == null || dimensaoSelecionada == "")
			return false;		
		return true;
	}



	public void naoSelecionouTaxa(){
		this.dialogHeader = "Taxa Não Selecionadas";
		this.dialogValue = "A taxa não foi selecionada para comparação.";
		this.buttonValue = "Cancelar";		
		this.renderedCancel = true;
		this.renderedConfirm = false;
	}

	public void naoSelecionouDimensao(){
		this.dialogHeader = "Dimensão Não Selecionadas";
		this.dialogValue = "A dimensão não foi selecionada para comparação.";
		this.buttonValue = "Cancelar";
		this.renderedCancel = true;
		this.renderedConfirm = false;
	}	
	
	public void selecionouTudo(){
		this.dialogHeader = "Você Selecionou Os Seguintes Campos";
		this.dialogValue = "Taxa: " + taxaSelecionada + "</br>" + "Dimensao: " + dimensaoSelecionada;
		this.buttonValue = "Continuar";				
		this.renderedCancel= false;
		this.renderedConfirm = true;
	}



	public void showDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').show();");							
	}
	
	public void hideDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').hide();");
	}

	public void iniciaDimensao(){
		//pegar valor do banco
		dimensao.add("MUNICÍPIO");
		dimensao.add("ESTADO");
		dimensao.add("REGIÃO");
		dimensao.add("PAÍS");				
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


	public boolean checaEscola(){		
		if(!checaSelecaoTaxa()){
			naoSelecionouTaxa();
			showDialog();
			return false;
		}
		else if(!checaSelecaoDimensao()){			
			naoSelecionouDimensao();
			showDialog();
			return false;
		}				
		else{
			selecionouTudo();
			showDialog();
			return true;
		}
	}
	
	public void redirecionaDetalhes(){
		System.out.println("FOI");
		Rota.redireciona("detalheComparativo.xhtml");
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

	public LinkedList<String> getDimensao() {
		return dimensao;
	}

	public void setDimensao(LinkedList<String> dimensao) {
		this.dimensao = dimensao;
	}

	public List<TipoTaxa> getTaxas() {
		return taxas;
	}

	public void setTaxas(List<TipoTaxa> taxas) {
		this.taxas = taxas;
	}

	public LinkedList<String> getTaxasEscolha() {
		return taxasEscolha;
	}

	public void setTaxasEscolha(LinkedList<String> taxasEscolha) {
		this.taxasEscolha = taxasEscolha;
	}

	public String getDimensaoSelecionada() {
		return dimensaoSelecionada;
	}

	public void setDimensaoSelecionada(String dimensaoSelecionada) {
		this.dimensaoSelecionada = dimensaoSelecionada;
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

	public int getEscolaSelecionada() {
		return escolaSelecionada;
	}

	public void setEscolaSelecionada(int escolaSelecionada) {
		this.escolaSelecionada = escolaSelecionada;
	}
	
	




}
