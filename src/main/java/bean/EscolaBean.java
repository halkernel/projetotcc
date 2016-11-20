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
public class EscolaBean {
	
	private List<Escola> escolas;	
	private List<TipoTaxa> taxas;
	private List<String> taxasEscolha = new LinkedList<>();
	
	private int escolaSelecionada;
	
	private String taxaSelecionada = "";
	private String dialogHeader ="";
	private String dialogValue ="";
	private String buttonValue ="";

	private boolean renderedConfirm = false;
	private boolean renderedCancel = false;
	
	private String nomeEscola;
	
	public EscolaBean(){
		iniciaTaxas();
		iniciaTaxasEscolha();
	}
		
	public void iniciaTaxasEscolha(){
		for (TipoTaxa tt : taxas) {
			taxasEscolha.add(tt.getTaxaNome());			
		}
	}

	private void iniciaTaxas() {
		TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
		taxas = tipoTaxaDao.list();					
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
	
	
	public void showDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').show();");							
	}
	
	public void hideDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').hide();");
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
	
	public void naoSelecionouTaxa(){
		this.dialogHeader = "Taxa Não Selecionadas";
		this.dialogValue = "A taxa não foi selecionada para comparação.";
		this.buttonValue = "Cancelar";		
		this.renderedCancel = true;
		this.renderedConfirm = false;
	}
	public void selecionouTudo(){
		this.dialogHeader = "Você Selecionou A Seguinte Taxa";
		this.dialogValue = "Taxa: " + taxaSelecionada;
		this.buttonValue = "Continuar";				
		this.renderedCancel= false;
		this.renderedConfirm = true;
	}
	
	public boolean checaSelecaoTaxa(){
		if(taxaSelecionada == null || taxaSelecionada == "")			
			return false;		
		return true;
	}
	
	
	public boolean checaEscola(){
		System.out.println("AEHOO");
		if(!checaSelecaoTaxa()){
			naoSelecionouTaxa();
			showDialog();
			return false;
		}
		else{
			selecionouTudo();
			showDialog();
			return true;
		}
	}
	
	public void redirecionaDetalheEscola(){
		Rota.redireciona("detalheSimples.xhtml");
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

	public List<String> getTaxasEscolha() {
		return taxasEscolha;
	}

	public void setTaxasEscolha(List<String> taxasEscolha) {
		this.taxasEscolha = taxasEscolha;
	}

	public String getTaxaSelecionada() {
		return taxaSelecionada;
	}

	public void setTaxaSelecionada(String taxaSelecionada) {
		this.taxaSelecionada = taxaSelecionada;
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

	public int getEscolaSelecionada() {
		return escolaSelecionada;
	}

	public void setEscolaSelecionada(int escolaSelecionada) {
		this.escolaSelecionada = escolaSelecionada;
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
	
	

	
	
	
	
	
	
	
}
