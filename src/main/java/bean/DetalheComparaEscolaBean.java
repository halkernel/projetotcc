package bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.json.JSONArray;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import dao.EscolaDAO;
import dao.EscolaTaxaDAO;
import dao.TipoTaxaDAO;
import entity.Escola;
import entity.EscolaTaxa;
import entity.Estado;
import entity.Municipio;
import entity.TipoTaxa;
import model.CalculoMunicipio;
import util.CalculaMedia;
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

	
	private Municipio municipio;
	private Estado estado;
	
	private LinkedList<Municipio> cidades;
	private LinkedList<Estado> estados;
	

	private LinkedList<TipoTaxa> taxasList;
	private LinkedList<Integer> valoresParametro = new LinkedList<>();

	private EscolaDAO escolaDao = new EscolaDAO();
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxa = new TipoTaxaDAO();
	
	private Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	private Map<String, String []> requestParamValues =	FacesContext.getCurrentInstance().getExternalContext().getRequestParameterValuesMap();
	
	private CalculoMunicipio calculoMunicipio = new CalculoMunicipio();
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;

	@PostConstruct
	public void init(){

	}




	public void detalheEscola(){
				
		idEscola = Integer.parseInt(params.get("escola"));
		escola = escolaDao.listById(idEscola);
		municipio = escola.getMunicipio();
		
		dimensao = params.get("dimensao");	
		taxa = params.get("taxa");
		dimensao = ConverteValor.removeAcento(dimensao);
		
		if(dimensao.equals("MUNICIPIO")){
			//chartEducacaoInfantil = calculoMunicipio.
		}
		else if(dimensao.equals("ESTADO")){
			
		}else if(dimensao.equals("REGIAO")){
			
		}else if (dimensao.equals("PAIS")){
			
		}
				
		taxasList = ConverteValor.toLinkedList(tipoTaxa.list());
		
//		this.pegaParametrosDeConsulta();
//		Integer[] valores = valoresParametro.toArray(new Integer[valoresParametro.size()]);		
		
		List<EscolaTaxa> nova = escolaTaxaDao.listMunicipioJoin(municipio.getId());

		LinkedList<EscolaTaxa> nova2 = ConverteValor.toLinkedList(nova);
		for (EscolaTaxa escolattx: nova2) {
				System.out.println(escolattx.getTipoTaxa().getTaxaNome());
		}

		
		escolaTaxa = escolaTaxaDao.list(escola.getId());		
//		criaModeloEducacaoInfantil();
//		criaModeloEnsinoFundamental();
//		criaModeloEnsinoMedio();
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


}
