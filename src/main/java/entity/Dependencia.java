package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dependencia")
public class Dependencia {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "dependencia_nome")
	private String dependenciaNome;
	
	@OneToMany
	@JoinColumn(name = "id_dependencia", updatable=false)	
	private List<Escola> escolas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDependenciaNome() {
		return dependenciaNome;
	}

	public void setDependenciaNome(String dependenciaNome) {
		this.dependenciaNome = dependenciaNome;
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}
	
	

}
