package bean;

import java.util.LinkedList;
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
import util.ConverteValor;

/**
 * @author halkernel
 *
 */
@ManagedBean
@SessionScoped
public class DetalheEscolaBean { 
	
	private Escola escola = new Escola();
	private LinkedList<EscolaTaxa> escolaTaxa = new LinkedList<>();
	private int idEscola;
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
    
	
	@PostConstruct
	public void init(){
				
	}
	
	//plotar os dados do municipio num boxplot 
	//
	//
	
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();		
		for (EscolaTaxa e : escolaTaxa) {
			ChartSeries series = new ChartSeries();
			series.setLabel(e.getTipoTaxa().getTaxaNome());
			series.set("Creche",  e.getCreche());
			series.set("Pré-Escola", e.getPreEscola());
			series.set("Total", e.getTotalInfantil());		
			educacaoInfantilModelo.addSeries(series);			
		}		
		return educacaoInfantilModelo;
	}
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();		
		for (EscolaTaxa e : escolaTaxa) {
			ChartSeries series = new ChartSeries();
			series.setLabel(e.getTipoTaxa().getTaxaNome());
			series.set("Anos Iniciais", e.getPrimeiroAoQuinto());
			series.set("Anos Finais", e.getSextoAoNono());
			series.set("1º Ano", e.getPrimeiroAnoFundamental());
			series.set("2º Ano", e.getSegundoAnoFundamental());
			series.set("3º Ano", e.getTerceiroAnoFundamental());
			series.set("4º Ano", e.getQuartoAnoFundamental());
			series.set("5º Ano", e.getQuintoAnoFundamental());
			series.set("6º Ano", e.getSextoAnoFundamental());
			series.set("7º Ano", e.getSetimoAnoFundamental());
			series.set("8º Ano", e.getOitavoAnoFundamental());		
			series.set("9º Ano", e.getNonoAnoFundamental());
			series.set("Turmas Unificadas", e.getTurmasUnificadas());				
			ensinoFundamentalModelo.addSeries(series);			
		}		
		return ensinoFundamentalModelo;
	}	
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();		
		for(int i = 0; i < 1; i++){
			ChartSeries seriesEscola = new ChartSeries();
			ChartSeries seriesMunicipio = new ChartSeries();
			seriesEscola.setLabel("ESCOLA");
			seriesEscola.set("1º Ano", escolaTaxa.get(i).getPrimeiroAnoMedio());
			seriesMunicipio.set("1º Ano Mun", escolaTaxa.get(i).getTerceiroAnoMedio());
			seriesEscola.set("2º Ano", escolaTaxa.get(i).getSegundoAnoMedio());
			seriesMunicipio.set("2º Ano Mun", escolaTaxa.get(i).getPrimeiroAnoMedio());
			seriesMunicipio.setLabel("MUNICIPIO");
//			series.set("3º Ano", e.getTerceiroAnoMedio());
//			series.set("4º Ano", e.getQuartoAnoMedio());
//			series.set("Medio Não Seriado", e.getMedioNaoSeriado());		
			ensinoMedioModelo.addSeries(seriesEscola);	
			ensinoMedioModelo.addSeries(seriesMunicipio);
		}		
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
		EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
		escolaTaxa = ConverteValor.toLinkedList(escolaTaxaDao.listTaxas(escola.getId()));		
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
