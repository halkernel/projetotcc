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

public class CalculoPais {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private EscolaTaxa taxaEscola;
	private EscolaTaxa taxaMunicipioMedia;
	
	private TipoTaxa tipoTaxa;
	private LinkedList<EscolaTaxa> taxasPais;
	
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
		
	
	
	public CalculoPais(String taxa, Escola escola, String dimensao){		
		tipoTaxa = tipoTaxaDao.listByName(taxa);
		taxaEscola = escolaTaxaDao.listByIdAndSchool(tipoTaxa.getId(), escola.getId());		
		taxasPais = ConverteValor.toLinkedList(escolaTaxaDao.listAll(tipoTaxa.getId()));
		taxaMunicipioMedia = ConverteValor.converteEscolaTaxa(taxasPais, dimensao);
		
	}
	
	
//	
//
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries seriePais = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		seriePais.setLabel(taxaMunicipioMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("Creche", taxaEscola.getCreche());
		seriePais.set("Creche", taxaMunicipioMedia.getCreche());
		serieEscola.set("Pré-Escola", taxaEscola.getPreEscola());
		seriePais.set("Pré-Escola", taxaMunicipioMedia.getPreEscola());
		serieEscola.set("Total", taxaEscola.getTotalInfantil());
		seriePais.set("Total", taxaMunicipioMedia.getTotalInfantil());
		educacaoInfantilModelo.addSeries(serieEscola);		
		educacaoInfantilModelo.addSeries(seriePais);
		educacaoInfantilModelo.setSeriesColors("579575, 4BB2C5");
		return educacaoInfantilModelo;
	}
	
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries seriePais = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		seriePais.setLabel(taxaMunicipioMedia.getTipoTaxa().getTaxaNome().toUpperCase());		
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoFundamental());
		seriePais.set("1º Ano", taxaMunicipioMedia.getPrimeiroAnoFundamental());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoFundamental());
		seriePais.set("2º Ano", taxaMunicipioMedia.getSegundoAnoFundamental());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoFundamental());
		seriePais.set("3º Ano", taxaMunicipioMedia.getTerceiroAnoFundamental());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoFundamental());
		seriePais.set("4º Ano", taxaMunicipioMedia.getQuartoAnoFundamental());		
		serieEscola.set("5º Ano", taxaEscola.getQuintoAnoFundamental());
		seriePais.set("5º Ano", taxaMunicipioMedia.getQuintoAnoFundamental());		
		serieEscola.set("6º Ano", taxaEscola.getSextoAnoFundamental());
		seriePais.set("6º Ano", taxaMunicipioMedia.getSextoAnoFundamental());
		serieEscola.set("7º Ano", taxaEscola.getSetimoAnoFundamental());
		seriePais.set("7º Ano", taxaMunicipioMedia.getSetimoAnoFundamental());
		serieEscola.set("8º Ano", taxaEscola.getOitavoAnoFundamental());
		seriePais.set("8º Ano", taxaMunicipioMedia.getOitavoAnoFundamental());
		serieEscola.set("9º Ano", taxaEscola.getNonoAnoFundamental());
		seriePais.set("9º Ano", taxaMunicipioMedia.getNonoAnoFundamental());
		serieEscola.set("Turmas Unificadas", taxaEscola.getTurmasUnificadas());
		serieEscola.set("Turmas Unificadas", taxaMunicipioMedia.getTurmasUnificadas());
		ensinoFundamentalModelo.addSeries(serieEscola);
		ensinoFundamentalModelo.addSeries(seriePais);
		ensinoFundamentalModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoFundamentalModelo;
	}	
	
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries seriePais = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		seriePais.setLabel(taxaMunicipioMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoMedio());
		seriePais.set("1º Ano", taxaMunicipioMedia.getPrimeiroAnoMedio());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoMedio());
		seriePais.set("2º Ano", taxaMunicipioMedia.getSegundoAnoMedio());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoMedio());
		seriePais.set("3º Ano", taxaMunicipioMedia.getTerceiroAnoMedio());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoMedio());
		seriePais.set("4º Ano", taxaMunicipioMedia.getQuartoAnoMedio());
		ensinoMedioModelo.addSeries(serieEscola);
		ensinoMedioModelo.addSeries(seriePais);		
		ensinoMedioModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoMedioModelo;
	}	

	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Educação Infantil - Comparação com: " + taxaMunicipioMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental - Comparação com: " + taxaMunicipioMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoMedio(){
		chartEnsinoMedio = preencheModeloEnsinoMedio();
		chartEnsinoMedio.setTitle("Ensino Médio - Comparação com: " + taxaMunicipioMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));
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


	public LinkedList<EscolaTaxa> getTaxasPais() {
		return taxasPais;
	}


	public void setTaxasPais(LinkedList<EscolaTaxa> taxasPais) {
		this.taxasPais = taxasPais;
	}


	

}
