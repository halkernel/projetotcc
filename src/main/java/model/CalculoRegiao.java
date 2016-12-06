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

public class CalculoRegiao {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private EscolaTaxa taxaEscola;
	private EscolaTaxa taxaRegiaoMedia;
	
	private TipoTaxa tipoTaxa;
	private LinkedList<EscolaTaxa> taxasRegiao;
	
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
		
	
	
	public CalculoRegiao(String taxa, Escola escola, String dimensao){		
		tipoTaxa = tipoTaxaDao.listByName(taxa);
		taxaEscola = escolaTaxaDao.listByIdAndSchool(tipoTaxa.getId(), escola.getId());		
		taxasRegiao = ConverteValor.toLinkedList(escolaTaxaDao.listByRegiaoAndTaxa(escola.getMunicipio().getEstado().getRegiao().getId(), tipoTaxa.getId()));
		taxaRegiaoMedia = ConverteValor.converteEscolaTaxa(taxasRegiao, dimensao);
		
	}
	
	
//	
//
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries seriesRegiao = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		seriesRegiao.setLabel(taxaRegiaoMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("Creche", taxaEscola.getCreche());
		seriesRegiao.set("Creche", taxaRegiaoMedia.getCreche());
		serieEscola.set("Pré-Escola", taxaEscola.getPreEscola());
		seriesRegiao.set("Pré-Escola", taxaRegiaoMedia.getPreEscola());
		serieEscola.set("Total", taxaEscola.getTotalInfantil());
		seriesRegiao.set("Total", taxaRegiaoMedia.getTotalInfantil());
		educacaoInfantilModelo.addSeries(serieEscola);		
		educacaoInfantilModelo.addSeries(seriesRegiao);
		educacaoInfantilModelo.setSeriesColors("579575, 4BB2C5");
		return educacaoInfantilModelo;
	}
	
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieRegiao = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieRegiao.setLabel(taxaRegiaoMedia.getTipoTaxa().getTaxaNome().toUpperCase());		
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoFundamental());
		serieRegiao.set("1º Ano", taxaRegiaoMedia.getPrimeiroAnoFundamental());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoFundamental());
		serieRegiao.set("2º Ano", taxaRegiaoMedia.getSegundoAnoFundamental());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoFundamental());
		serieRegiao.set("3º Ano", taxaRegiaoMedia.getTerceiroAnoFundamental());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoFundamental());
		serieRegiao.set("4º Ano", taxaRegiaoMedia.getQuartoAnoFundamental());		
		serieEscola.set("5º Ano", taxaEscola.getQuintoAnoFundamental());
		serieRegiao.set("5º Ano", taxaRegiaoMedia.getQuintoAnoFundamental());		
		serieEscola.set("6º Ano", taxaEscola.getSextoAnoFundamental());
		serieRegiao.set("6º Ano", taxaRegiaoMedia.getSextoAnoFundamental());
		serieEscola.set("7º Ano", taxaEscola.getSetimoAnoFundamental());
		serieRegiao.set("7º Ano", taxaRegiaoMedia.getSetimoAnoFundamental());
		serieEscola.set("8º Ano", taxaEscola.getOitavoAnoFundamental());
		serieRegiao.set("8º Ano", taxaRegiaoMedia.getOitavoAnoFundamental());
		serieEscola.set("9º Ano", taxaEscola.getNonoAnoFundamental());
		serieRegiao.set("9º Ano", taxaRegiaoMedia.getNonoAnoFundamental());
		serieEscola.set("Turmas Unificadas", taxaEscola.getTurmasUnificadas());
		serieEscola.set("Turmas Unificadas", taxaRegiaoMedia.getTurmasUnificadas());
		ensinoFundamentalModelo.addSeries(serieEscola);
		ensinoFundamentalModelo.addSeries(serieRegiao);
		ensinoFundamentalModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoFundamentalModelo;
	}	
	
	public BarChartModel preencheModeloEnsinoMedio(){
		BarChartModel ensinoMedioModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieRegiao = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieRegiao.setLabel(taxaRegiaoMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoMedio());
		serieRegiao.set("1º Ano", taxaRegiaoMedia.getPrimeiroAnoMedio());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoMedio());
		serieRegiao.set("2º Ano", taxaRegiaoMedia.getSegundoAnoMedio());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoMedio());
		serieRegiao.set("3º Ano", taxaRegiaoMedia.getTerceiroAnoMedio());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoMedio());
		serieRegiao.set("4º Ano", taxaRegiaoMedia.getQuartoAnoMedio());
		ensinoMedioModelo.addSeries(serieEscola);
		ensinoMedioModelo.addSeries(serieRegiao);		
		ensinoMedioModelo.setSeriesColors("579575, 4BB2C5");
		return ensinoMedioModelo;
	}	

	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Educação Infantil - Comparação com: " + taxaRegiaoMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental - Comparação com: " + taxaRegiaoMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(110);
	}
	
	public void criaModeloEnsinoMedio(){
		chartEnsinoMedio = preencheModeloEnsinoMedio();
		chartEnsinoMedio.setTitle("Ensino Médio - Comparação com: " + taxaRegiaoMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));
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


	public LinkedList<EscolaTaxa> getTaxasRegiao() {
		return taxasRegiao;
	}


	public void setTaxasRegiao(LinkedList<EscolaTaxa> taxasRegiao) {
		this.taxasRegiao = taxasRegiao;
	}

	

}
