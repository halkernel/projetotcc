package model;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

public class CalculoMunicipio {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
//	
//
//	public BarChartModel preencheModeloEducacaoInfantil(){
//		BarChartModel educacaoInfantilModelo = new BarChartModel();
//		ChartSeries series = new ChartSeries();
//		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
//		series.set("Creche",  escolaTaxa.getCreche());
//		series.set("Pré-Escola", escolaTaxa.getPreEscola());
//		series.set("Total", escolaTaxa.getTotalInfantil());		
//		educacaoInfantilModelo.addSeries(series);
//		return educacaoInfantilModelo;
//	}
//	public BarChartModel preencheModeloEnsinoFundamental(){
//		BarChartModel ensinoFundamentalModelo = new BarChartModel();
//		ChartSeries series = new ChartSeries();
//
//		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
//		series.set("Anos Iniciais", escolaTaxa.getPrimeiroAoQuinto());
//		series.set("Anos Finais", escolaTaxa.getSextoAoNono());
//		series.set("1º Ano", escolaTaxa.getPrimeiroAnoFundamental());
//		series.set("2º Ano", escolaTaxa.getSegundoAnoFundamental());
//		series.set("3º Ano", escolaTaxa.getTerceiroAnoFundamental());
//		series.set("4º Ano", escolaTaxa.getQuartoAnoFundamental());
//		series.set("5º Ano", escolaTaxa.getQuintoAnoFundamental());
//		series.set("6º Ano", escolaTaxa.getSextoAnoFundamental());
//		series.set("7º Ano", escolaTaxa.getSetimoAnoFundamental());
//		series.set("8º Ano", escolaTaxa.getOitavoAnoFundamental());		
//		series.set("9º Ano", escolaTaxa.getNonoAnoFundamental());
//		series.set("Turmas Unificadas", escolaTaxa.getTurmasUnificadas());		
//		ensinoFundamentalModelo.addSeries(series);
//		return ensinoFundamentalModelo;
//	}	
//	public BarChartModel preencheModeloEnsinoMedio(){
//		BarChartModel ensinoMedioModelo = new BarChartModel();
//		ChartSeries series = new ChartSeries();
//		series.setLabel(escolaTaxa.getTipoTaxa().getTaxaNome());
//		series.set("1º Ano", escolaTaxa.getPrimeiroAnoMedio());
//		series.set("2º Ano", escolaTaxa.getSegundoAnoMedio());
//		series.set("3º Ano", escolaTaxa.getTerceiroAnoMedio());
//		series.set("4º Ano", escolaTaxa.getQuartoAnoMedio());
//		series.set("Medio Não Seriado", escolaTaxa.getMedioNaoSeriado());		
//		ensinoMedioModelo.addSeries(series);
//		return ensinoMedioModelo;
//	}	
//
//	public void criaModeloEducacaoInfantil(){
//		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
//		chartEducacaoInfantil.setTitle("Educação Infantil");
//		chartEducacaoInfantil.setLegendPosition("ne");
//		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(100);
//	}
//	public void criaModeloEnsinoFundamental(){
//		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
//		chartEnsinoFundamental.setTitle("Ensino Fundamental");
//		chartEnsinoFundamental.setLegendPosition("ne");
//		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(100);
//	}
//	public void criaModeloEnsinoMedio(){
//		chartEnsinoMedio = preencheModeloEnsinoMedio();
//		chartEnsinoMedio.setTitle("Ensino Médio");
//		chartEnsinoMedio.setLegendPosition("ne");
//		Axis yAxis = chartEnsinoMedio.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(100);
//	}
//	
	


}
