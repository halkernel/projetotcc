package bean;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.BarChartModel;

import dao.EscolaDAO;
import dao.EscolaTaxaDAO;
import entity.EscolaTaxa;
import model.CalculoComparacaoEscolas;
import util.PegaValores;

@ManagedBean
@SessionScoped
public class DetalheComparaDuasEscolasBean {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private int idPrimeiraEscola = 0;
	private int idSegundaEscola = 0;
	private String taxa;
	
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	
	private EscolaTaxa primeiraEscola;
	private EscolaTaxa segundaEscola;
	
	private CalculoComparacaoEscolas calculoComparacaoEscolas;

	
	public void detalhesEscolas(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		taxa = PegaValores.getTaxa(params);		
		idPrimeiraEscola = Integer.parseInt(PegaValores.getPrimeiraEscola(params));
		idSegundaEscola = Integer.parseInt(PegaValores.getSegundaEscola(params));

		primeiraEscola = getTaxa(taxa, escolaTaxaDao.listTaxas(idPrimeiraEscola));
		segundaEscola = getTaxa(taxa, escolaTaxaDao.listTaxas(idSegundaEscola));
		
		calculoComparacaoEscolas = new CalculoComparacaoEscolas(primeiraEscola, segundaEscola);
		
		chartEducacaoInfantil = calculoComparacaoEscolas.calculaInfantil();
		chartEnsinoFundamental = calculoComparacaoEscolas.calculaFundamental();
		chartEnsinoMedio = calculoComparacaoEscolas.calculaMedio();
		
	}
	
	public EscolaTaxa getTaxa(String taxaNome, List<EscolaTaxa> taxas){
		for (EscolaTaxa t : taxas) {
			if(t.getTipoTaxa().getTaxaNome().equals(taxaNome)){
				return t;
			}
		}
		return null;
	}

	public EscolaTaxa getPrimeiraEscola() {
		return primeiraEscola;
	}

	public void setPrimeiraEscola(EscolaTaxa primeiraEscola) {
		this.primeiraEscola = primeiraEscola;
	}

	public EscolaTaxa getSegundaEscola() {
		return segundaEscola;
	}

	public void setSegundaEscola(EscolaTaxa segundaEscola) {
		this.segundaEscola = segundaEscola;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
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
