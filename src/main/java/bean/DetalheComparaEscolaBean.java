package bean;

import java.util.LinkedList;
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
	private LinkedList<Escola> escolasColocacao = new LinkedList<>();



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
		for(int i = 0; i < taxasMunicipio.size(); i++){
			escolasColocacao.add(taxasMunicipio.get(i).getEscola());
		}
		for(Escola e : escolasColocacao){
			if(e.getEscolaNome().equals(escola.getEscolaNome())){
				indexOf = escolasColocacao.indexOf(e);
			}
		}
		LinkedList<Escola> escolasFinal = new LinkedList<>();
		for(int i = indexOf; i < indexOf+3; i++){
			escolasFinal.add(escolasColocacao.get(i));
		}
		escolasColocacao.clear();
		escolasColocacao.addAll(escolasFinal);
		
	}
	
	public String indexOf(String esNome){
		for (Escola escola : escolasColocacao) {
			if(escola.getEscolaNome().equals(esNome)){
				return new Integer(escolasColocacao.indexOf(escola) + 37).toString();
			}
		}
		return null;
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



	public LinkedList<Escola> getEscolasColocacao() {
		return escolasColocacao;
	}



	public void setEscolasColocacao(LinkedList<Escola> escolasColocacao) {
		this.escolasColocacao = escolasColocacao;
	}








}
