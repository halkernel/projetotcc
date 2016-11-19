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

public class CalculoMunicipio {
	
	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	private EscolaTaxa taxaEscola;
	private EscolaTaxa taxaMunicipioMedia;
	
	private TipoTaxa tipoTaxa;
	private LinkedList<EscolaTaxa> taxasMunicipio;
	
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	private TipoTaxaDAO tipoTaxaDao = new TipoTaxaDAO();
	
	private String taxa;
	
	
	public CalculoMunicipio(String taxa, Escola escola, String dimensao){		
		tipoTaxa = tipoTaxaDao.listByName(taxa);
		taxaEscola = escolaTaxaDao.listByIdAndSchool(tipoTaxa.getId(), escola.getId());		
		taxasMunicipio = ConverteValor.toLinkedList(escolaTaxaDao.listByMunicipioAndTaxa(escola.getMunicipio().getId(), tipoTaxa.getId()));
		taxaMunicipioMedia = ConverteValor.converteEscolaTaxa(taxasMunicipio, dimensao);
		
	}
	
	
//	
//
	public BarChartModel preencheModeloEducacaoInfantil(){
		BarChartModel educacaoInfantilModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieMunicipio = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieMunicipio.setLabel(taxaMunicipioMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("Creche", taxaEscola.getCreche());
		serieMunicipio.set("Creche", taxaMunicipioMedia.getCreche());
		serieEscola.set("Pré-Escola", taxaEscola.getPreEscola());
		serieMunicipio.set("Pré-Escola", taxaMunicipioMedia.getPreEscola());
		serieEscola.set("Total", taxaEscola.getTotalInfantil());
		serieMunicipio.set("Total", taxaMunicipioMedia.getTotalInfantil());
		educacaoInfantilModelo.addSeries(serieEscola);
		educacaoInfantilModelo.addSeries(serieMunicipio);
		return educacaoInfantilModelo;
	}
	
	public BarChartModel preencheModeloEnsinoFundamental(){
		BarChartModel ensinoFundamentalModelo = new BarChartModel();
		ChartSeries serieEscola = new ChartSeries();
		ChartSeries serieMunicipio = new ChartSeries();
		serieEscola.setLabel(taxaEscola.getEscola().getEscolaNome());
		serieMunicipio.setLabel(taxaMunicipioMedia.getTipoTaxa().getTaxaNome().toUpperCase());
		serieEscola.set("Anos Iniciais", taxaEscola.getPrimeiroAoQuinto());
		serieMunicipio.set("Anos Iniciais", taxaMunicipioMedia.getPrimeiroAoQuinto());
		serieEscola.set("Anos Finais", taxaEscola.getPrimeiroAoQuinto());
		serieMunicipio.set("Anos Finais", taxaMunicipioMedia.getSextoAoNono());
		serieEscola.set("1º Ano", taxaEscola.getPrimeiroAnoFundamental());
		serieMunicipio.set("1º Ano", taxaMunicipioMedia.getPrimeiroAnoFundamental());		
		serieEscola.set("2º Ano", taxaEscola.getSegundoAnoFundamental());
		serieMunicipio.set("2º Ano", taxaMunicipioMedia.getSegundoAnoFundamental());
		serieEscola.set("3º Ano", taxaEscola.getTerceiroAnoFundamental());
		serieMunicipio.set("3º Ano", taxaMunicipioMedia.getTerceiroAnoFundamental());
		serieEscola.set("4º Ano", taxaEscola.getQuartoAnoFundamental());
		serieMunicipio.set("4º Ano", taxaMunicipioMedia.getQuartoAnoFundamental());		
		serieEscola.set("5º Ano", taxaEscola.getQuintoAnoFundamental());
		serieMunicipio.set("5º Ano", taxaMunicipioMedia.getQuintoAnoFundamental());		
		serieEscola.set("6º Ano", taxaEscola.getSextoAnoFundamental());
		serieMunicipio.set("6º Ano", taxaMunicipioMedia.getSextoAnoFundamental());
		serieEscola.set("7º Ano", taxaEscola.getSetimoAnoFundamental());
		serieMunicipio.set("7º Ano", taxaMunicipioMedia.getSetimoAnoFundamental());
		serieEscola.set("8º Ano", taxaEscola.getOitavoAnoFundamental());
		serieMunicipio.set("8º Ano", taxaMunicipioMedia.getOitavoAnoFundamental());
		serieEscola.set("9º Ano", taxaEscola.getNonoAnoFundamental());
		serieMunicipio.set("9º Ano", taxaMunicipioMedia.getNonoAnoFundamental());
		serieEscola.set("Turmas Unificadas", taxaEscola.getTurmasUnificadas());
		serieEscola.set("Turmas Unificadas", taxaMunicipioMedia.getTurmasUnificadas());
		ensinoFundamentalModelo.addSeries(serieEscola);
		ensinoFundamentalModelo.addSeries(serieMunicipio);
		return ensinoFundamentalModelo;
	}	
	
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
	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Educação Infantil - Comparação com: " + taxaMunicipioMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	
	public void criaModeloEnsinoFundamental(){
		chartEnsinoFundamental = preencheModeloEnsinoFundamental();
		chartEnsinoFundamental.setTitle("Ensino Fundamental - Comparação com: " + taxaMunicipioMedia.getTipoTaxa().getTaxaNome() + " - " + ConverteValor.captalize(tipoTaxa.getTaxaNome()));		
		chartEnsinoFundamental.setLegendPosition("ne");
		Axis yAxis = chartEnsinoFundamental.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
	
//	public void criaModeloEnsinoMedio(){
//		chartEnsinoMedio = preencheModeloEnsinoMedio();
//		chartEnsinoMedio.setTitle("Ensino Médio");
//		chartEnsinoMedio.setLegendPosition("ne");
//		Axis yAxis = chartEnsinoMedio.getAxis(AxisType.Y);
//		yAxis.setMin(0);
//		yAxis.setMax(100);
//	}
//	
	
	
	public BarChartModel calculaInfantilComparandoMunicipio() {
		criaModeloEducacaoInfantil();
		return chartEducacaoInfantil;		
	}
	public BarChartModel calculaFundamentalComparandoMunicipio() {
		criaModeloEnsinoFundamental();
		return chartEnsinoFundamental;
	}
//	public BarChartModel calculaMedioComparandoMunicipio() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
