package bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.PieChartModel;

import dao.EscolaDAO;
import entity.Escola;

@ManagedBean
@SessionScoped
public class DetalheEscolaBean {
	
	private Escola escola = new Escola();
	private int idEscola;
    
	
	@PostConstruct
	public void init(){
		createPieModel();
	}
	
	private void createPieModel() {
        createModel();
    }
 
    private void createModel() {
    
    }	
	
	public void detalheEscola(){
		Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		idEscola = Integer.parseInt(params.get("escola"));
		EscolaDAO escolaDao = new EscolaDAO();
		escola = escolaDao.listById(idEscola);
		System.out.println(idEscola);
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

	

	
	

}
