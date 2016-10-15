package bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import dao.EscolaTaxaDAO;
import dao.EscolaDAO;
import entity.Escola;
import entity.EscolaTaxa;

@ManagedBean
@SessionScoped
public class DetalheEscolaBean {
	
	private Escola escola = new Escola();
	private EscolaTaxa escolaTaxa = new EscolaTaxa();
	private int idEscola;
	private BarChartModel chartEscola;	
    
	
	@PostConstruct
	public void init(){
				
	}
	
	public BarChartModel preencheModelo(){
		BarChartModel escolaModelo = new BarChartModel();
		ChartSeries series = new ChartSeries();
		EscolaTaxaDAO daotest = new EscolaTaxaDAO();
		escolaTaxa = daotest.list(escola.getId());
		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
		series.set("Pré-Escola", escolaTaxa.getPreEscola());
		series.set("1º Ano", escolaTaxa.getPrimeiroAnoFundamental());
		series.set("2º Ano", escolaTaxa.getSegundoAnoFundamental());
		series.set("3º Ano", escolaTaxa.getTerceiroAnoFundamental());
		series.set("4º Ano", escolaTaxa.getQuartoAnoFundamental());
		series.set("5º Ano", escolaTaxa.getQuintoAnoFundamental());
		series.set("6º Ano", escolaTaxa.getSextoAnoFundamental());
		series.set("7º Ano", escolaTaxa.getSetimoAnoFundamental());
		series.set("8º Ano", escolaTaxa.getOitavoAnoFundamental());		
		series.set("9º Ano", escolaTaxa.getNonoAnoFundamental());		
		System.out.println(escolaTaxa.getTipoTaxa().getTaxaNome()); 
		
		escolaModelo.addSeries(series);
		return escolaModelo;
	}
	
	public void criaModelo(){
		chartEscola = preencheModelo();
		chartEscola.setTitle(escolaTaxa.getTipoTaxa().getTaxaNome());
		chartEscola.setLegendPosition("ne");
		
		Axis yAxis = chartEscola.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	
		
	public void detalheEscola(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		idEscola = Integer.parseInt(params.get("escola"));
		EscolaDAO escolaDao = new EscolaDAO();
		escola = escolaDao.listById(idEscola);
		System.out.println(idEscola);
		criaModelo();
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


	public BarChartModel getChartEscola() {
		return chartEscola;
	}


	public void setChartEscola(BarChartModel chartEscola) {
		this.chartEscola = chartEscola;
	}

	
	

	
	

}
