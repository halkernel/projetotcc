package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_taxa")
public class TipoTaxa {
	 
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="taxa_nome")
	private String taxaNome;
	
	@OneToMany
	@JoinColumn(name="id_taxa", updatable=false)
	private List<EscolaTaxa> escolaTaxa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaxaNome() {
		return taxaNome;
	}

	public void setTaxaNome(String taxaNome) {
		this.taxaNome = taxaNome;
	}
	
	
	

}
