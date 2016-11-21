package bean;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.EscolaDAO;
import dao.EscolaTaxaDAO;
import entity.EscolaTaxa;
import util.PegaValores;

@ManagedBean
@SessionScoped
public class DetalheComparaDuasEscolasBean {
	
	private int idPrimeiraEscola = 0;
	private int idSegundaEscola = 0;
	private String taxa;
	
	private EscolaDAO escolaDao = new EscolaDAO();
	private EscolaTaxaDAO escolaTaxaDao = new EscolaTaxaDAO();
	
	private List<EscolaTaxa> taxaPrimeiraEscola;
	private List<EscolaTaxa> taxaSegundaEscola;
	
	private EscolaTaxa primeiraEscola;
	private EscolaTaxa segundaEscola;

	
	public void detalhesEscolas(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		
		taxa = PegaValores.getTaxa(params);		
		idPrimeiraEscola = Integer.parseInt(PegaValores.getPrimeiraEscola(params));
		idSegundaEscola = Integer.parseInt(PegaValores.getSegundaEscola(params));

		primeiraEscola = getTaxa(taxa, escolaTaxaDao.listTaxas(idPrimeiraEscola));
		segundaEscola = getTaxa(taxa, escolaTaxaDao.listTaxas(idSegundaEscola));			
		
	}
	
	public EscolaTaxa getTaxa(String taxaNome, List<EscolaTaxa> taxas){
		for (EscolaTaxa t : taxas) {
			if(t.getTipoTaxa().getTaxaNome().equals(taxaNome)){
				return t;
			}
		}
		return null;
	}

	public EscolaTaxa getPrimeiraEscola() {
		return primeiraEscola;
	}

	public void setPrimeiraEscola(EscolaTaxa primeiraEscola) {
		this.primeiraEscola = primeiraEscola;
	}

	public EscolaTaxa getSegundaEscola() {
		return segundaEscola;
	}

	public void setSegundaEscola(EscolaTaxa segundaEscola) {
		this.segundaEscola = segundaEscola;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}
	
	
	

}
