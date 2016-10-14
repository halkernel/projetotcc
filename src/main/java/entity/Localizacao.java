package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="localizacao")
public class Localizacao {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "localizacao_nome")
	private String localizacaoNome;
	
	@OneToMany
	@JoinColumn(name = "id_localizacao", updatable=false)	
	private List<Escola> escolas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalizacaoNome() {
		return localizacaoNome;
	}

	public void setLocalizacaoNome(String localizacaoNome) {
		this.localizacaoNome = localizacaoNome;
	}

	public List<Escola> getEscolas() {
		return escolas;
	}

	public void setEscolas(List<Escola> escolas) {
		this.escolas = escolas;
	}
	
	

}
