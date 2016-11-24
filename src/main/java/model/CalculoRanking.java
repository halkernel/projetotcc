package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.EscolaTaxa;
import util.ConverteValor;

public class CalculoRanking {

	private List<EscolaTaxa> colocacaoInfantil;
	private List<EscolaTaxa> colocacaoFundamental;
	private List<EscolaTaxa> colocacaoMedio;

	public CalculoRanking(List<EscolaTaxa> escolasOrdenar){
		this.colocacaoInfantil = this.colocacaoFundamental = this.colocacaoMedio = escolasOrdenar;
	}



	public void criaRankingInfantil(){
		colocacaoInfantil = ConverteValor.mediaDeCadaNivel(colocacaoInfantil);		
		Collections.sort(colocacaoInfantil, new Comparator<EscolaTaxa>() {

			@Override
			public int compare(EscolaTaxa o1, EscolaTaxa o2) {
				if (o1.getTotalInfantil() > o2.getTotalInfantil()) {
					return 1;
				} else if (o1.getTotalInfantil() < o2.getTotalInfantil()) {
					return -1;
				}  
				return 0;
			}

		});
	}

	public void criaRankingFundamental(){
		colocacaoFundamental = ConverteValor.mediaDeCadaNivel(colocacaoFundamental);
		Collections.sort(colocacaoFundamental, new Comparator<EscolaTaxa>() {

			@Override
			public int compare(EscolaTaxa o1, EscolaTaxa o2) {
				if (o1.getTotalFundamental() > o2.getTotalFundamental()) {
					return 1;
				} else if (o1.getTotalFundamental() < o2.getTotalFundamental()) {
					return -1;
				}  
				return 0;
			}

		});
	}

	public void criaRankingMedio(){
		colocacaoMedio = ConverteValor.mediaDeCadaNivel(colocacaoMedio);
		Collections.sort(colocacaoMedio, new Comparator<EscolaTaxa>() {

			@Override
			public int compare(EscolaTaxa o1, EscolaTaxa o2) {
				if (o1.getTotalMedio() > o2.getTotalMedio()) {
					return 1;
				} else if (o1.getTotalMedio() < o2.getTotalMedio()) {
					return -1;
				}  
				return 0;
			}

		});
	}



	public List<EscolaTaxa> getColocacaoInfantil() {
		return colocacaoInfantil;
	}



	public void setColocacaoInfantil(List<EscolaTaxa> colocacaoInfantil) {
		this.colocacaoInfantil = colocacaoInfantil;
	}



	public List<EscolaTaxa> getColocacaoFundamental() {
		return colocacaoFundamental;
	}



	public void setColocacaoFundamental(List<EscolaTaxa> colocacaoFundamental) {
		this.colocacaoFundamental = colocacaoFundamental;
	}



	public List<EscolaTaxa> getColocacaoMedio() {
		return colocacaoMedio;
	}



	public void setColocacaoMedio(List<EscolaTaxa> colocacaoMedio) {
		this.colocacaoMedio = colocacaoMedio;
	}



	


}
