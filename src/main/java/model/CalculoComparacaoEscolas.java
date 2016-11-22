package model;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import entity.EscolaTaxa;
import util.ConverteValor;

public class CalculoComparacaoEscolas {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private EscolaTaxa primeiraEscola;
	private EscolaTaxa segundaEscola;
	
		
	public CalculoComparacaoEscolas(EscolaTaxa primeiraEscola, EscolaTaxa segundaEscola){
		this.primeiraEscola = primeiraEscola;
		this.segundaEscola = segundaEscola;
		
	}
	
	
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries seriePrimeiraEscola = new ChartSeries();
		ChartSeries serieSegundaEscola = new ChartSeries();
		seriePrimeiraEscola.setLabel(primeiraEscola.getEscola().getEscolaNome());
		serieSegundaEscola.setLabel(segundaEscola.getEscola().getEscolaNome());
		seriePrimeiraEscola.set("Creche", primeiraEscola.getCreche());
		serieSegundaEscola.set("Creche", segundaEscola.getCreche());
		seriePrimeiraEscola.set("Pré-Escola", primeiraEscola.getPreEscola());
		serieSegundaEscola.set("Pré-Escola", segundaEscola.getPreEscola());
		seriePrimeiraEscola.set("Total", primeiraEscola.getTotalInfantil());
		serieSegundaEscola.set("Total", segundaEscola.getTotalInfantil());
		educacaoInfantilModelo.addSeries(seriePrimeiraEscola);		
		educacaoInfantilModelo.setSeriesColors("579575, 4BB2C5");
		return educacaoInfantilModelo;
	}
	
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();		
		ChartSeries seriePrimeiraEscola = new ChartSeries();
		ChartSeries serieSegundaEscola = new ChartSeries();
		seriePrimeiraEscola.setLabel(primeiraEscola.getEscola().getEscolaNome());
		serieSegundaEscola.setLabel(segundaEscola.getEscola().getEscolaNome());
		seriePrimeiraEscola.set("1º Ano", primeiraEscola.getPrimeiroAnoFundamental());
		serieSegundaEscola.set("1º Ano", segundaEscola.getPrimeiroAnoFundamental());		
		seriePrimeiraEscola.set("2º Ano", primeiraEscola.getSegundoAnoFundamental());
		serieSegundaEscola.set("2º Ano", segundaEscola.getSegundoAnoFundamental());
		seriePrimeiraEscola.set("3º Ano", primeiraEscola.getTerceiroAnoFundamental());
		serieSegundaEscola.set("3º Ano", segundaEscola.getTerceiroAnoFundamental());
		seriePrimeiraEscola.set("4º Ano", primeiraEscola.getQuartoAnoFundamental());
		serieSegundaEscola.set("4º Ano", segundaEscola.getQuartoAnoFundamental());
		seriePrimeiraEscola.set("5º Ano", primeiraEscola.getQuintoAnoFundamental());
		serieSegundaEscola.set("5º Ano", segundaEscola.getQuintoAnoFundamental());
		seriePrimeiraEscola.set("6º Ano", primeiraEscola.getSextoAnoFundamental());
		serieSegundaEscola.set("6º Ano", segundaEscola.getSextoAnoFundamental());
		seriePrimeiraEscola.set("7º Ano", primeiraEscola.getSetimoAnoFundamental());
		serieSegundaEscola.set("7º Ano", segundaEscola.getSetimoAnoFundamental());
		seriePrimeiraEscola.set("8º Ano", primeiraEscola.getOitavoAnoFundamental());
		serieSegundaEscola.set("8º Ano", segundaEscola.getOitavoAnoFundamental());
		seriePrimeiraEscola.set("9º Ano", primeiraEscola.getNonoAnoFundamental());
		serieSegundaEscola.set("9º Ano", segundaEscola.getNonoAnoFundamental());
		seriePrimeiraEscola.set("Turmas Unificadas", primeiraEscola.getTurmasUnificadas());
		serieSegundaEscola.set("Turmas Unificadas", segundaEscola.getTurmasUnificadas());
		ensinoFundamentalModelo.addSeries(seriePrimeiraEscola);
		ensinoFundamentalModelo.addSeries(serieSegundaEscola);
		ensinoFundamentalModelo.setSeriesColors("579575, 4BB2C5");		
		return ensinoFundamentalModelo;
		
	}
			
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();
		ChartSeries seriePrimeiraEscola = new ChartSeries();
		ChartSeries serieSegundaEscola = new ChartSeries();
		seriePrimeiraEscola.setLabel(primeiraEscola.getEscola().getEscolaNome());
		serieSegundaEscola.setLabel(segundaEscola.getEscola().getEscolaNome());
		seriePrimeiraEscola.set("1º Ano", primeiraEscola.getPrimeiroAnoMedio());
		serieSegundaEscola.set("1º Ano", segundaEscola.getPrimeiroAnoMedio());
		seriePrimeiraEscola.set("2º Ano", primeiraEscola.getSegundoAnoMedio());
		serieSegundaEscola.set("2º Ano", segundaEscola.getSegundoAnoMedio());
		seriePrimeiraEscola.set("3º Ano", primeiraEscola.getTerceiroAnoMedio());
		serieSegundaEscola.set("3º Ano", segundaEscola.getTerceiroAnoMedio());
		seriePrimeiraEscola.set("4º Ano", primeiraEscola.getQuartoAnoMedio());
		serieSegundaEscola.set("4º Ano", segundaEscola.getQuartoAnoMedio());
		ensinoMedioModelo.addSeries(seriePrimeiraEscola);
		ensinoMedioModelo.addSeries(serieSegundaEscola);
		ensinoMedioModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoMedioModelo;
	}
		
	
	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Ensino Infantil - " + ConverteValor.captalize(primeiraEscola.getTipoTaxa().getTaxaNome()));		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental - " + ConverteValor.captalize(primeiraEscola.getTipoTaxa().getTaxaNome()));		
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoMedio(){
		chartEnsinoMedio = preencheModeloEnsinoMedio();
		chartEnsinoMedio.setTitle("Ensino Medio - " + ConverteValor.captalize(primeiraEscola.getTipoTaxa().getTaxaNome()));
		chartEnsinoMedio.setLegendPosition("ne");
		Axis yAxis = chartEnsinoMedio.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	
	
	
	
	public BarChartModel calculaInfantil() {
		criaModeloEducacaoInfantil();
		return chartEducacaoInfantil;		
	}
	public BarChartModel calculaFundamental() {
		criaModeloEnsinoFundamental();
		return chartEnsinoFundamental;
	}
	
	public BarChartModel calculaMedio() {
		criaModeloEnsinoMedio();
		return chartEnsinoMedio;
	}

}
