package bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.BarChartModel;

import dao.EscolaDAO;
import dao.EscolaTaxaDAO;
import dao.TipoTaxaDAO;
import entity.Escola;
import entity.EscolaTaxa;
import entity.TipoTaxa;
import model.CalculoMunicipio;
import model.CalculoRanking;
import util.ConverteValor;
import util.PegaValores;

/**
 * @author halkernel
 *
 */
@ManagedBean
@SessionScoped
public class DetalheComparaEscolaBean { 

	private Escola escola = new Escola();
	private EscolaTaxa escolaTaxa = new EscolaTaxa();
	private int idEscola;	
	private String taxa;
	private String dimensao; 

	private EscolaDAO escolaDao = new EscolaDAO();
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();

	private CalculoMunicipio calculoMunicipio;

	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;

	private List<EscolaTaxa> escolasColocacaoInfantil;
	private List<EscolaTaxa> escolasColocacaoFundamental;
	private List<EscolaTaxa> escolasColocacaoMedio;



	private CalculoRanking ranking;;



	public DetalheComparaEscolaBean() {

	}

	@PostConstruct
	public void init(){

	}




	public void detalheEscola(){	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();


		idEscola = Integer.parseInt(PegaValores.getEscola(params));


		dimensao = PegaValores.getDimensao(params);
		dimensao = ConverteValor.removeAcento(dimensao);

		taxa = PegaValores.getTaxa(params);		


		escola = escolaDao.listById(idEscola);

		if(dimensao.equals("MUNICIPIO")){
			calculoMunicipio = new CalculoMunicipio(taxa, escola, dimensao);
			chartEducacaoInfantil = calculoMunicipio.calculaInfantilComparandoMunicipio();
			chartEnsinoFundamental = calculoMunicipio.calculaFundamentalComparandoMunicipio();
			chartEnsinoMedio = calculoMunicipio.calculaMedioComparandoMunicipio();
		}
		else if(dimensao.equals("ESTADO")){

		}else if(dimensao.equals("REGIAO")){

		}else if (dimensao.equals("PAIS")){

		}

		initvalues();

	}


	public void initvalues(){
		int indexOf = 0;
		TipoTaxa tipoTaxa = tipoTaxaDao.listByName(taxa);
		LinkedList<EscolaTaxa> taxasMunicipio = ConverteValor.toLinkedList(escolaTaxaDao.listByMunicipioAndTaxa(escola.getMunicipio().getId(), tipoTaxa.getId()));
		ranking = new CalculoRanking(taxasMunicipio);
		ranking.criaRankingInfantil();
		ranking.criaRankingFundamental();
		ranking.criaRankingMedio();

		escolasColocacaoInfantil = ranking.getColocacaoInfantil();
		escolasColocacaoFundamental = ranking.getColocacaoFundamental();
		escolasColocacaoMedio = ranking.getColocacaoMedio();	
		
		escolasColocacaoInfantil = ajustaLista(escolasColocacaoInfantil);
		escolasColocacaoFundamental = ajustaLista(escolasColocacaoFundamental);
		escolasColocacaoMedio = ajustaLista(escolasColocacaoMedio);
				
		escolasColocacaoInfantil = sublist(escolasColocacaoInfantil, escola.getEscolaNome());
		escolasColocacaoFundamental = sublist(escolasColocacaoFundamental, escola.getEscolaNome());
		escolasColocacaoMedio = sublist(escolasColocacaoMedio, escola.getEscolaNome());
		
		
	}

	public String indexOfInfantil(String esNome){
		for(int i = 0; i < escolasColocacaoInfantil.size(); i++){
			if(escolasColocacaoInfantil.get(i).getEscola().getEscolaNome().equals(esNome)){
				return new Integer(escolasColocacaoInfantil.get(i).getId()).toString();
			}
		}
		return "0";
	}

	public String indexOfFundamental(String esNome){
		for(int i = 0; i < escolasColocacaoFundamental.size(); i++){
			if(escolasColocacaoFundamental.get(i).getEscola().getEscolaNome().equals(esNome)){
				return new Integer(escolasColocacaoFundamental.get(i).getId()).toString();
			}
		}
		return "0";
	}

	public String indexOfMedio(String esNome){
		for(int i = 0; i < escolasColocacaoMedio.size(); i++){
			if(escolasColocacaoMedio.get(i).getEscola().getEscolaNome().equals(esNome)){
				return new Integer(escolasColocacaoMedio.get(i).getId()).toString();
			}
		}
		return "0";
	}

	public List<EscolaTaxa> ajustaLista(List<EscolaTaxa> listaAjuste){
		List<EscolaTaxa> estmp = new LinkedList<>();
		for (int i = 0;  i < listaAjuste.size(); i++) {			
			listaAjuste.get(i).setId(i+1);
			estmp.add(listaAjuste.get(i));			
		}		
		return estmp;
	}
	
	public List<EscolaTaxa> sublist(List<EscolaTaxa> list, String nome){
		for (EscolaTaxa escolaTaxa : list) {
			if(escolaTaxa.getEscola().getEscolaNome().equals(nome)){
				return list.subList(list.indexOf(escolaTaxa), list.size());
			}
		}
		return list;
	}

	public Escola getEscola() {
		return escola;
	}
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	public int getIdEscola() {
		return idEscola;
	}
	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}

	public BarChartModel getChartEducacaoInfantil() {
		return chartEducacaoInfantil;
	}

	public void setChartEducacaoInfantil(BarChartModel chartEducacaoInfantil) {
		this.chartEducacaoInfantil = chartEducacaoInfantil;
	}

	public BarChartModel getChartEnsinoFundamental() {
		return chartEnsinoFundamental;
	}

	public void setChartEnsinoFundamental(BarChartModel chartEnsinoFundamental) {
		this.chartEnsinoFundamental = chartEnsinoFundamental;
	}

	public BarChartModel getChartEnsinoMedio() {
		return chartEnsinoMedio;
	}

	public void setChartEnsinoMedio(BarChartModel chartEnsinoMedio) {
		this.chartEnsinoMedio = chartEnsinoMedio;
	}

	public EscolaTaxa getEscolaTaxa() {
		return escolaTaxa;
	}

	public void setEscolaTaxa(EscolaTaxa escolaTaxa) {
		this.escolaTaxa = escolaTaxa;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public String getDimensao() {
		return dimensao;
	}

	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}

	public List<EscolaTaxa> getEscolasColocacaoInfantil() {
		return escolasColocacaoInfantil;
	}

	public void setEscolasColocacaoInfantil(List<EscolaTaxa> escolasColocacaoInfantil) {
		this.escolasColocacaoInfantil = escolasColocacaoInfantil;
	}

	public List<EscolaTaxa> getEscolasColocacaoFundamental() {
		return escolasColocacaoFundamental;
	}

	public void setEscolasColocacaoFundamental(List<EscolaTaxa> escolasColocacaoFundamental) {
		this.escolasColocacaoFundamental = escolasColocacaoFundamental;
	}

	public List<EscolaTaxa> getEscolasColocacaoMedio() {
		return escolasColocacaoMedio;
	}

	public void setEscolasColocacaoMedio(List<EscolaTaxa> escolasColocacaoMedio) {
		this.escolasColocacaoMedio = escolasColocacaoMedio;
	}










}
