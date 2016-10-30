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
	
	private LinkedList<String> dimensao = new LinkedList<>();
	private LinkedList<String> categorias = new LinkedList<>();


	
	private String dialogHeader;
	private String dialogValue;
	
	public BuscaAvancadaBean(){
		iniciaDimensao();
		iniciaCategorias();
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
	
	public boolean checaTarget(){
		if(escolasEscolha.getTarget().size() < 2)
			return true;
		return false;
	}
	
	
	public String naoSelecionou(){		
		return "nao selecionou";
	}
	
	public String selecionouMaisDeDuasEscolas(){		
		return "selecionou mais de duas";
	}
	
	public String naoSelecionouTaxaOuDimensao(){
		return "taxa ou dimensao nao selecionada";
	}
	
	
	
	public void checarEscola(){
		System.out.println(escolasEscolha.getTarget().size());
		if(checaTarget()){
			RequestContext requestContext = RequestContext.getCurrentInstance();
			requestContext.execute("PF('dlg2').show();");
		}		
		
		System.err.println("oioi");
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
	
	public void iniciaDimensao(){
		//pegar valor do banco
		dimensao.add("MUNICÍPIO");
		dimensao.add("ESTADO");
		dimensao.add("REGIÃO");
		dimensao.add("PAÍS");				
	}
	
	public void iniciaCategorias(){
		//pegar valor do banco
		categorias.add("TAXA DE APROVAÇÃO");
		categorias.add("TAXA DE REPROVAÇÃO");
		categorias.add("TAXA DE EVASÃO");
		categorias.add("TAXA DE DISTORÇÃO IDADE-SÉRIE");
		categorias.add("TAXA DE MÉDIA DE ALUNOS POR TURMA");
		categorias.add("TAXA DE NÃO RESPOSTA");				
	}

	public LinkedList<String> getDimensao() {
		return dimensao;
	}

	public void setDimensao(LinkedList<String> dimensao) {
		this.dimensao = dimensao;
	}
	
	public LinkedList<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(LinkedList<String> categorias) {
		this.categorias = categorias;
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

	




}
