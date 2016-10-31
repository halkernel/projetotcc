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
import util.ConverteString;
import util.Rota;

@ManagedBean
@ViewScoped
public class ComparaEscolaBean {
	
	private List<Escola> escolas;
	private String nomeEscola;
	
	private LinkedList<String> dimensao = new LinkedList<>();
	private List<TipoTaxa> taxas;
	
	private LinkedList<String> taxasEscolha = new LinkedList<>();


    private String[] taxasSelecionadas;
	private String dimensaoSelecionada = "";
	
	private String dialogHeader ="";
	private String dialogValue ="";
	
	public ComparaEscolaBean(){
		iniciaTaxas();
		iniciaDimensao();
		iniciaTaxasEscolha();
	}
	
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
	
	
	public boolean checaSelecaoTaxa(){
		if(taxasSelecionadas == null || taxasSelecionadas.length == 0)			
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
	}
	
	public void naoSelecionouDimensao(){
		this.dialogHeader = "Dimensão Não Selecionadas";
		this.dialogValue = "A dimensão não foi selecionada para comparação.";
	}	
	
	public void showDialog(){
		RequestContext requestContext = RequestContext.getCurrentInstance();
		requestContext.execute("PF('dlg2').show();");
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
		return true;
	}
	
	public void detalheEscola(){		
		if(checaEscola()){
			System.out.println("\n\n\n\n\n entrou \n\n\n\n");
			Rota.redireciona("detalheComparativo.xhtml");
		}
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

	public String[] getTaxasSelecionadas() {
		return taxasSelecionadas;
	}

	public void setTaxasSelecionadas(String[] taxasSelecionadas) {
		this.taxasSelecionadas = taxasSelecionadas;
	}
	
	
	
	
}
