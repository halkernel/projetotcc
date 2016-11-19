package bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.BarChartModel;

import dao.EscolaDAO;
import dao.EscolaTaxaDAO;
import entity.Escola;
import entity.EscolaTaxa;
import model.CalculoMunicipio;
import util.ConverteValor;
import util.PegaValores;

/**
 * @author halkernel
 *
 */
@ManagedBean
@SessionScoped
public class DetalheComparaEscolaBean { 

	private Escola escola = new Escola();
	private EscolaTaxa escolaTaxa = new EscolaTaxa();
	private int idEscola;	
	private String taxa;
	private String dimensao;
 

	private EscolaDAO escolaDao = new EscolaDAO();

	private CalculoMunicipio calculoMunicipio;

	private BarChartModel chartEducacaoInfantil;
	private BarChartModel chartEnsinoFundamental;
	private BarChartModel chartEnsinoMedio;
	
	
	public  DetalheComparaEscolaBean() {

	}

	@PostConstruct
	public void init(){
		
	}



	public void detalheEscola(){	
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();


		idEscola = Integer.parseInt(PegaValores.getEscola(params));
		
		
		dimensao = PegaValores.getDimensao(params);
		dimensao = ConverteValor.removeAcento(dimensao);
		
		taxa = PegaValores.getTaxa(params);		
		

		escola = escolaDao.listById(idEscola);

		if(dimensao.equals("MUNICIPIO")){
			calculoMunicipio = new CalculoMunicipio(taxa, escola, dimensao);
			chartEducacaoInfantil = calculoMunicipio.calculaInfantilComparandoMunicipio();
			chartEnsinoFundamental = calculoMunicipio.calculaFundamentalComparandoMunicipio();
//			chartEnsinoFundamental = calculoMunicipio.calculaMedioComparandoMunicipio();
		}
		else if(dimensao.equals("ESTADO")){

		}else if(dimensao.equals("REGIAO")){

		}else if (dimensao.equals("PAIS")){

		}


		//		this.pegaParametrosDeConsulta();
		//		Integer[] valores = valoresParametro.toArray(new Integer[valoresParametro.size()]);		


		//		criaModeloEducacaoInfantil();
		//		criaModeloEnsinoFundamental();
		//		criaModeloEnsinoMedio();
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
