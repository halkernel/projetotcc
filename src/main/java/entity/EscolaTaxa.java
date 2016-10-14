package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "escola_taxa")
public class EscolaTaxa {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="primeiro_ano_m")
	private Double primeiroAnoMedio;
	
	@Column(name="segundo_ano_m")
	private Double segundoAnoMedio;
	
	@Column(name="terceiro_ano_m")
	private Double terceiroAnoMedio;
	
	@Column(name="quarto_ano_m")
	private Double quartoAnoMedio;
	
	@Column(name="primeiro_ano")
	private Double primeiroAnoFundamental;
	
	@Column(name="segundo_ano")
	private Double segundoAnoFundamental;
	
	@Column(name="terceiro_ano")
	private Double terceiroAnoFundamental;
	
	@Column(name="quarto_ano")
	private Double quartoAnoFundamental;
	
	@Column(name="quinto_ano")
	private Double quintoAnoFundamental;
	
	@Column(name="sexto_ano")
	private Double sextoAnoFundamental;
	
	@Column(name="setimo_ano")
	private Double setimoAnoFundamental;
	
	@Column(name="oitavo_ano")	
	private Double oitavoAnoFundamental;
	
	@Column(name="nono_ano")
	private Double nonoAnoFundamental;
	
	@Column(name="creche")
	private Double creche;
	
	@Column(name="pre_escola")
	private Double preEscola;
	
	@Column(name="primeiro_ao_quinto")
	private Double primeiroAoQuinto;
	
	@Column(name="sexto_ao_nono")
	private Double sextoAoNono;
	
	@Column(name="turmas_unificadas")
	private Double turmasUnificadas;
	
	@Column(name="medio_nao_seriado")
	private Double medioNaoSeriado;
	
	@Column(name="total_medio")
	private Double totalMedio;
	
	@Column(name="total_fundamental")	
	private Double totalFundamental;
	
	@Column(name="total_infantil")
	private Double totalInfantil;
	
	@ManyToOne
	@JoinColumn(name="id_escola", updatable=false)
	private Escola escola;
	
	@ManyToOne
	@JoinColumn(name="id_taxa", updatable=false)
	private TipoTaxa tipoTaxa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getPrimeiroAnoMedio() {
		return primeiroAnoMedio;
	}

	public void setPrimeiroAnoMedio(Double primeiroAnoMedio) {
		this.primeiroAnoMedio = primeiroAnoMedio;
	}

	public Double getSegundoAnoMedio() {
		return segundoAnoMedio;
	}

	public void setSegundoAnoMedio(Double segundoAnoMedio) {
		this.segundoAnoMedio = segundoAnoMedio;
	}

	public Double getTerceiroAnoMedio() {
		return terceiroAnoMedio;
	}

	public void setTerceiroAnoMedio(Double terceiroAnoMedio) {
		this.terceiroAnoMedio = terceiroAnoMedio;
	}

	public Double getQuartoAnoMedio() {
		return quartoAnoMedio;
	}

	public void setQuartoAnoMedio(Double quartoAnoMedio) {
		this.quartoAnoMedio = quartoAnoMedio;
	}

	public Double getPrimeiroAnoFundamental() {
		return primeiroAnoFundamental;
	}

	public void setPrimeiroAnoFundamental(Double primeiroAnoFundamental) {
		this.primeiroAnoFundamental = primeiroAnoFundamental;
	}

	public Double getSegundoAnoFundamental() {
		return segundoAnoFundamental;
	}

	public void setSegundoAnoFundamental(Double segundoAnoFundamental) {
		this.segundoAnoFundamental = segundoAnoFundamental;
	}

	public Double getTerceiroAnoFundamental() {
		return terceiroAnoFundamental;
	}

	public void setTerceiroAnoFundamental(Double terceiroAnoFundamental) {
		this.terceiroAnoFundamental = terceiroAnoFundamental;
	}

	public Double getQuartoAnoFundamental() {
		return quartoAnoFundamental;
	}

	public void setQuartoAnoFundamental(Double quartoAnoFundamental) {
		this.quartoAnoFundamental = quartoAnoFundamental;
	}

	public Double getQuintoAnoFundamental() {
		return quintoAnoFundamental;
	}

	public void setQuintoAnoFundamental(Double quintoAnoFundamental) {
		this.quintoAnoFundamental = quintoAnoFundamental;
	}

	public Double getSextoAnoFundamental() {
		return sextoAnoFundamental;
	}

	public void setSextoAnoFundamental(Double sextoAnoFundamental) {
		this.sextoAnoFundamental = sextoAnoFundamental;
	}

	public Double getSetimoAnoFundamental() {
		return setimoAnoFundamental;
	}

	public void setSetimoAnoFundamental(Double setimoAnoFundamental) {
		this.setimoAnoFundamental = setimoAnoFundamental;
	}

	public Double getOitavoAnoFundamental() {
		return oitavoAnoFundamental;
	}

	public void setOitavoAnoFundamental(Double oitavoAnoFundamental) {
		this.oitavoAnoFundamental = oitavoAnoFundamental;
	}

	public Double getNonoAnoFundamental() {
		return nonoAnoFundamental;
	}

	public void setNonoAnoFundamental(Double nonoAnoFundamental) {
		this.nonoAnoFundamental = nonoAnoFundamental;
	}

	public Double getCreche() {
		return creche;
	}

	public void setCreche(Double creche) {
		this.creche = creche;
	}

	public Double getPreEscola() {
		return preEscola;
	}

	public void setPreEscola(Double preEscola) {
		this.preEscola = preEscola;
	}

	public Double getPrimeiroAoQuinto() {
		return primeiroAoQuinto;
	}

	public void setPrimeiroAoQuinto(Double primeiroAoQuinto) {
		this.primeiroAoQuinto = primeiroAoQuinto;
	}

	public Double getSextoAoNono() {
		return sextoAoNono;
	}

	public void setSextoAoNono(Double sextoAoNono) {
		this.sextoAoNono = sextoAoNono;
	}

	public Double getTurmasUnificadas() {
		return turmasUnificadas;
	}

	public void setTurmasUnificadas(Double turmasUnificadas) {
		this.turmasUnificadas = turmasUnificadas;
	}

	public Double getMedioNaoSeriado() {
		return medioNaoSeriado;
	}

	public void setMedioNaoSeriado(Double medioNaoSeriado) {
		this.medioNaoSeriado = medioNaoSeriado;
	}

	public Double getTotalMedio() {
		return totalMedio;
	}

	public void setTotalMedio(Double totalMedio) {
		this.totalMedio = totalMedio;
	}

	public Double getTotalFundamental() {
		return totalFundamental;
	}

	public void setTotalFundamental(Double totalFundamental) {
		this.totalFundamental = totalFundamental;
	}

	public Double getTotalInfantil() {
		return totalInfantil;
	}

	public void setTotalInfantil(Double totalInfantil) {
		this.totalInfantil = totalInfantil;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public TipoTaxa getTipoTaxa() {
		return tipoTaxa;
	}

	public void setTipoTaxa(TipoTaxa tipoTaxa) {
		this.tipoTaxa = tipoTaxa;
	}
	
	
	

}
