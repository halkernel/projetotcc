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
	public void criaModeloEducacaoInfantil(){
		chartEducacaoInfantil = preencheModeloEducacaoInfantil();
		chartEducacaoInfantil.setTitle("Educação Infantil - Comparação com: " + taxaMunicipioMedia.getTipoTaxa().getTaxaNome() + " - " + tipoTaxa.getTaxaNome());
		
		chartEducacaoInfantil.setLegendPosition("ne");
		Axis yAxis = chartEducacaoInfantil.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(100);
	}
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
	
	
	public BarChartModel calculaInfantilComparandoMunicipio() {
		criaModeloEducacaoInfantil();
		return chartEducacaoInfantil;		
	}
//	public BarChartModel calculaFundamentalComparandoMunicipio() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public BarChartModel calculaMedioComparandoMunicipio() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
