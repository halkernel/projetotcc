package bean;

import java.util.LinkedList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SelecionaTaxaBean {

	private LinkedList<String> categorias = new LinkedList<>();
    private String city;
	
	public SelecionaTaxaBean(){
		iniciaValores();
	}	
	
	public void init(){
				
	}
	
	public void iniciaValores(){
		//pegar valor do banco
		categorias.add("TAXA DE APROVAÇÃO");
		categorias.add("TAXA DE REPROVAÇÃO");
		categorias.add("TAXA DE EVASÃO");
		categorias.add("TAXA DE DISTORÇÃO IDADE-SÉRIE");
		categorias.add("TAXA DE MÉDIA DE ALUNOS POR TURMA");
		categorias.add("TAXA DE NÃO RESPOSTA");				
	}

	public LinkedList<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(LinkedList<String> categorias) {
		this.categorias = categorias;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
