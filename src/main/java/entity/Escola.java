package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "escola")

public class Escola {

	@Id	
	@Column(name = "id")	
	private int id;	

	@Column(name = "escola_nome")
	private String escolaNome;

	@Column(name = "cod_escola")
	private int codEscola;

	@ManyToOne
	@JoinColumn(name = "id_municipio")	
	private Municipio municipio;
	
	@ManyToOne
	@JoinColumn(name="id_dependencia")
	private Dependencia dependencia;
	
	@ManyToOne
	@JoinColumn(name="id_localizacao")
	private Localizacao localizacao;
	
	@OneToMany
	@JoinColumn(name="id_escola", updatable=false)
	private List<EscolaTaxa> escolaTaxa;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getEscolaNome() {
		return escolaNome;
	}

	public void setEscolaNome(String escolaNome) {
		this.escolaNome = escolaNome;
	}

	public int getCodEscola() {
		return codEscola;
	}

	public void setCodEscola(int codEscola) {
		this.codEscola = codEscola;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public List<EscolaTaxa> getEscolaTaxa() {
		return escolaTaxa;
	}

	public void setEscolaTaxa(List<EscolaTaxa> escolaTaxa) {
		this.escolaTaxa = escolaTaxa;
	}

	



}
