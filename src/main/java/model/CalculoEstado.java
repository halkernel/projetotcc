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

public class CalculoEstado {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private EscolaTaxa taxaEscola;
	private EscolaTaxa taxaEstadoMedia;
	
	private TipoTaxa tipoTaxa;
	private LinkedList<EscolaTaxa> taxasEstado;
	
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
		
	
	
	public CalculoEstado(String taxa, Escola escola, String dimensao){		
		tipoTaxa = tipoTaxaDao.listByName(taxa);
		taxaEscola = escolaTaxaDao.listByIdAndSchool(tipoTaxa.getId(), escola.getId());		
		taxasEstado = ConverteValor.toLinkedList(escolaTaxaDao.listByEstadoAndTaxa(escola.getMunicipio().getEstado().getId(), tipoTaxa.getId()));
		taxaEstadoMedia = ConverteValor.converteEscolaTaxa(taxasEstado, dimensao);
		
	}
	
	
//	
//
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieEstado = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieEstado.setLabel(taxaEstadoMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("Creche", taxaEscola.getCreche());
		serieEstado.set("Creche", taxaEstadoMedia.getCreche());
		serieEscola.set("Pré-Escola", taxaEscola.getPreEscola());
		serieEstado.set("Pré-Escola", taxaEstadoMedia.getPreEscola());
		serieEscola.set("Total", taxaEscola.getTotalInfantil());
		serieEstado.set("Total", taxaEstadoMedia.getTotalInfantil());
		educacaoInfantilModelo.addSeries(serieEscola);		
		educacaoInfantilModelo.addSeries(serieEstado);
		educacaoInfantilModelo.setSeriesColors("579575, 4BB2C5");
		return educacaoInfantilModelo;
	}
	
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieEstado = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieEstado.setLabel(taxaEstadoMedia.getTipoTaxa().getTaxaNome().toUpperCase());		
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoFundamental());
		serieEstado.set("1º Ano", taxaEstadoMedia.getPrimeiroAnoFundamental());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoFundamental());
		serieEstado.set("2º Ano", taxaEstadoMedia.getSegundoAnoFundamental());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoFundamental());
		serieEstado.set("3º Ano", taxaEstadoMedia.getTerceiroAnoFundamental());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoFundamental());
		serieEstado.set("4º Ano", taxaEstadoMedia.getQuartoAnoFundamental());		
		serieEscola.set("5º Ano", taxaEscola.getQuintoAnoFundamental());
		serieEstado.set("5º Ano", taxaEstadoMedia.getQuintoAnoFundamental());		
		serieEscola.set("6º Ano", taxaEscola.getSextoAnoFundamental());
		serieEstado.set("6º Ano", taxaEstadoMedia.getSextoAnoFundamental());
		serieEscola.set("7º Ano", taxaEscola.getSetimoAnoFundamental());
		serieEstado.set("7º Ano", taxaEstadoMedia.getSetimoAnoFundamental());
		serieEscola.set("8º Ano", taxaEscola.getOitavoAnoFundamental());
		serieEstado.set("8º Ano", taxaEstadoMedia.getOitavoAnoFundamental());
		serieEscola.set("9º Ano", taxaEscola.getNonoAnoFundamental());
		serieEstado.set("9º Ano", taxaEstadoMedia.getNonoAnoFundamental());
		serieEscola.set("Turmas Unificadas", taxaEscola.getTurmasUnificadas());
		serieEscola.set("Turmas Unificadas", taxaEstadoMedia.getTurmasUnificadas());
		ensinoFundamentalModelo.addSeries(serieEscola);
		ensinoFundamentalModelo.addSeries(serieEstado);
		ensinoFundamentalModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoFundamentalModelo;
	}	
	
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieEstado = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieEstado.setLabel(taxaEstadoMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoMedio());
		serieEstado.set("1º Ano", taxaEstadoMedia.getPrimeiroAnoMedio());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoMedio());
		serieEstado.set("2º Ano", taxaEstadoMedia.getSegundoAnoMedio());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoMedio());
		serieEstado.set("3º Ano", taxaEstadoMedia.getTerceiroAnoMedio());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoMedio());
		serieEstado.set("4º Ano", taxaEstadoMedia.getQuartoAnoMedio());
		ensinoMedioModelo.addSeries(serieEscola);
		ensinoMedioModelo.addSeries(serieEstado);		
		ensinoMedioModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoMedioModelo;
	}	

	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Educação Infantil - Comparação com: " + taxaEstadoMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental - Comparação com: " + taxaEstadoMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoMedio(){
		chartEnsinoMedio = preencheModeloEnsinoMedio();
		chartEnsinoMedio.setTitle("Ensino Médio - Comparação com: " + taxaEstadoMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));
		chartEnsinoMedio.setLegendPosition("ne");
		Axis yAxis = chartEnsinoMedio.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	
	
	
	public BarChartModel calculaInfantilComparandoMunicipio() {
		criaModeloEducacaoInfantil();
		return chartEducacaoInfantil;		
	}
	public BarChartModel calculaFundamentalComparandoMunicipio() {
		criaModeloEnsinoFundamental();
		return chartEnsinoFundamental;
	}
	
	public BarChartModel calculaMedioComparandoMunicipio() {
		criaModeloEnsinoMedio();
		return chartEnsinoMedio;
	}


	public LinkedList<EscolaTaxa> getTaxasEstado() {
		return taxasEstado;
	}


	public void setTaxasEstado(LinkedList<EscolaTaxa> taxasEstado) {
		this.taxasEstado = taxasEstado;
	}
	
	



}
