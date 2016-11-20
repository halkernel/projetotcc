package model;

import java.util.LinkedList;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import dao.EscolaTaxaDAO;
import dao.TipoTaxaDAO;
import entity.Escola;
import entity.EscolaTaxa;
import entity.TipoTaxa;
import util.ConverteValor;

public class CalculoEscola {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private EscolaTaxa taxaEscola;
	
	private TipoTaxa tipoTaxa;
	
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
		
	
	public CalculoEscola(String taxa, Escola escola){		
		tipoTaxa = tipoTaxaDao.listByName(taxa);
		taxaEscola = escolaTaxaDao.listByIdAndSchool(tipoTaxa.getId(), escola.getId());
		
		
		
	}

	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieEscola.set("Creche", taxaEscola.getCreche());
		serieEscola.set("Pré-Escola", taxaEscola.getPreEscola());
		serieEscola.set("Total", taxaEscola.getTotalInfantil());
		educacaoInfantilModelo.addSeries(serieEscola);		
		educacaoInfantilModelo.setSeriesColors("579575, 4BB2C5");
		return educacaoInfantilModelo;
	}
	
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoFundamental());
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoFundamental());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoFundamental());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoFundamental());
		serieEscola.set("5º Ano", taxaEscola.getQuintoAnoFundamental());
		serieEscola.set("6º Ano", taxaEscola.getSextoAnoFundamental());
		serieEscola.set("7º Ano", taxaEscola.getSetimoAnoFundamental());
		serieEscola.set("8º Ano", taxaEscola.getOitavoAnoFundamental());
		serieEscola.set("9º Ano", taxaEscola.getNonoAnoFundamental());
		serieEscola.set("Turmas Unificadas", taxaEscola.getTurmasUnificadas());
		ensinoFundamentalModelo.addSeries(serieEscola);
		ensinoFundamentalModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoFundamentalModelo;
	}	
	
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoMedio());
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoMedio());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoMedio());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoMedio());
		ensinoMedioModelo.addSeries(serieEscola);
		ensinoMedioModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoMedioModelo;
	}	

	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Ensino Infantil - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoMedio(){
		chartEnsinoMedio = preencheModeloEnsinoMedio();
		chartEnsinoMedio.setTitle("Ensino Medio - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));
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
