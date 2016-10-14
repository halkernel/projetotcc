package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regiao")
public class Regiao {
	
	@Id
	@Column(name ="id")
	private int id;
	
	@Column(name="regiao_nome")
	private String regiaoNome;
	
	@OneToMany
	@JoinColumn(name = "id_regiao", updatable=false)
	private List<Estado> estados;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegiaoNome() {
		return regiaoNome;
	}

	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	

}
