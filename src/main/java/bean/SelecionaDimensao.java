package bean;

import java.util.LinkedList;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SelecionaDimensao {
	
	private LinkedList<String> dimensao = new LinkedList<>();    
	
	public SelecionaDimensao(){
		iniciaValores();
	}	
	
	public void init(){
				
	}
	
	public void iniciaValores(){
		//pegar valor do banco
		dimensao.add("MUNICÍPIO");
		dimensao.add("ESTADO");
		dimensao.add("REGIÃO");
		dimensao.add("PAÍS");				
	}

	public LinkedList<String> getDimensao() {
		return dimensao;
	}

	public void setDimensao(LinkedList<String> dimensao) {
		this.dimensao = dimensao;
	}

	

}
