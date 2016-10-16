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

import dao.EscolaDAO;
import dao.EscolaTaxaDAO;
import entity.Escola;
import entity.EscolaTaxa;

/**
 * @author halkernel
 *
 */
@ManagedBean
@SessionScoped
public class DetalheEscolaBean {
	
	private Escola escola = new Escola();
	private EscolaTaxa escolaTaxa = new EscolaTaxa();
	private int idEscola;
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
    
	
	@PostConstruct
	public void init(){
				
	}
	
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries series = new ChartSeries();
		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
		series.set("Creche",  escolaTaxa.getCreche());
		series.set("Pré-Escola", escolaTaxa.getPreEscola());
		series.set("Total", escolaTaxa.getTotalInfantil());		
		educacaoInfantilModelo.addSeries(series);
		return educacaoInfantilModelo;
	}
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();
		ChartSeries series = new ChartSeries();
		
		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
		series.set("Anos Iniciais", escolaTaxa.getPrimeiroAoQuinto());
		series.set("Anos Finais", escolaTaxa.getSextoAoNono());
		series.set("1º Ano", escolaTaxa.getPrimeiroAnoFundamental());
		series.set("2º Ano", escolaTaxa.getSegundoAnoFundamental());
		series.set("3º Ano", escolaTaxa.getTerceiroAnoFundamental());
		series.set("4º Ano", escolaTaxa.getQuartoAnoFundamental());
		series.set("5º Ano", escolaTaxa.getQuintoAnoFundamental());
		series.set("6º Ano", escolaTaxa.getSextoAnoFundamental());
		series.set("7º Ano", escolaTaxa.getSetimoAnoFundamental());
		series.set("8º Ano", escolaTaxa.getOitavoAnoFundamental());		
		series.set("9º Ano", escolaTaxa.getNonoAnoFundamental());
		series.set("Turmas Unificadas", escolaTaxa.getTurmasUnificadas());		
		System.out.println(escolaTaxa.getTipoTaxa().getTaxaNome()); 		
		ensinoFundamentalModelo.addSeries(series);
		return ensinoFundamentalModelo;
	}	
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();
		ChartSeries series = new ChartSeries();
		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
		series.set("1º Ano", escolaTaxa.getPrimeiroAnoMedio());
		series.set("2º Ano", escolaTaxa.getSegundoAnoMedio());
		series.set("3º Ano", escolaTaxa.getTerceiroAnoMedio());
		series.set("4º Ano", escolaTaxa.getQuartoAnoMedio());
		series.set("Medio Não Seriado", escolaTaxa.getMedioNaoSeriado());		
		ensinoMedioModelo.addSeries(series);
		return ensinoMedioModelo;
	}	
	
	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Educação Infantil");
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental");
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	public void criaModeloEnsinoMedio(){
		chartEnsinoMedio = preencheModeloEnsinoMedio();
		chartEnsinoMedio.setTitle("Ensino Médio");
		chartEnsinoMedio.setLegendPosition("ne");
		Axis yAxis = chartEnsinoMedio.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	
		
	public void detalheEscola(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		idEscola = Integer.parseInt(params.get("escola"));
		EscolaDAO escolaDao = new EscolaDAO();
		escola = escolaDao.listById(idEscola);
		EscolaTaxaDAO daotest = new EscolaTaxaDAO();
		escolaTaxa = daotest.list(escola.getId());
		System.out.println(idEscola);
		criaModeloEducacaoInfantil();
		criaModeloEnsinoFundamental();
		criaModeloEnsinoMedio();
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
