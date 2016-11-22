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
import model.CalculoEscola;
import util.ConverteValor;
import util.PegaValores;

/**
 * @author halkernel
 *
 */
@ManagedBean
@SessionScoped
public class DetalheEscolaBean { 
	
	private Escola escola = new Escola();
	private LinkedList<EscolaTaxa> escolaTaxa = new LinkedList<>();
	private EscolaDAO escolaDao = new EscolaDAO();
	
	private int idEscola;
	private String taxa;

	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private CalculoEscola calculoEscola;
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private LinkedList<Escola> escolasColocacao = new LinkedList<Escola>();
    
	
	@PostConstruct
	public void init(){
				
	}
	
	public void detalheEscola(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		idEscola = Integer.parseInt(PegaValores.getEscola(params));
		taxa = PegaValores.getTaxa(params);		
		escola = escolaDao.listById(idEscola);
				
		calculoEscola  = new CalculoEscola(taxa, escola);		
		chartEducacaoInfantil = calculoEscola.calculaInfantil();
		chartEnsinoFundamental = calculoEscola.calculaFundamental();
		chartEnsinoMedio = calculoEscola.calculaMedio();
		
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

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public LinkedList<Escola> getEscolasColocacao() {
		return escolasColocacao;
	}

	public void setEscolasColocacao(LinkedList<Escola> escolasColocacao) {
		this.escolasColocacao = escolasColocacao;
	}
	
	
	
	
	

}
