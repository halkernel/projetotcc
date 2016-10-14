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
@Table (name="estado")
public class Estado {
	@Id	
	@Column(name = "id")	
	private int id;	

	@Column(name = "estado_nome")
	private String estadoNome;
	
	@OneToMany
	@JoinColumn(name = "id_estado", updatable=false)	
	private List<Municipio> municipios;
	
	@ManyToOne
	@JoinColumn(name = "id_regiao")	
	private Regiao regiao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstadoNome() {
		return estadoNome;
	}

	public void setEstadoNome(String estadoNome) {
		this.estadoNome = estadoNome;
	}

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}
	
	
	

}
