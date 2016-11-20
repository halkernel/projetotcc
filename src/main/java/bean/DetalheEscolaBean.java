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
import entity.Escola;
import entity.EscolaTaxa;
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
	
	
	
	

}
