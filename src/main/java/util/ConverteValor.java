package util;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entity.Escola;
import entity.EscolaTaxa;
import entity.TipoTaxa;

public class ConverteValor {



	public static String removeAcento(String st){
		st = Normalizer.normalize(st,Normalizer.Form.NFD);
		st = st.replaceAll("[^\\p{ASCII}]", "");
		return st;		
	}

	public static <T> LinkedList<T> toLinkedList(List<T> list){
		LinkedList<T> newList = new LinkedList<>();
		newList.addAll(list);
		return newList;
	}

	public static <T> ArrayList<T> toArrayList(List<T> list){
		ArrayList<T> newList = new ArrayList<>();
		for (T t : list) {
			newList.add(t);
		}
		return newList;
	}



	public static String captalize(String s) {            
		String words[] = s.split(" ");
		String nString = "";
		for (String w : words) {
			String value = w.toUpperCase().replace(w.substring(1), w.substring(1).toLowerCase());
			nString += " " + value;
		}           
		return nString;
	}



	public static EscolaTaxa converteEscolaTaxa(LinkedList<EscolaTaxa> escolaTaxaList, String dimensao){
		EscolaTaxa escolaTaxa = new EscolaTaxa();
		for (EscolaTaxa iterator : escolaTaxaList) {
			escolaTaxa.setCreche(escolaTaxa.getCreche() + iterator.getCreche());
			escolaTaxa.setPreEscola(escolaTaxa.getPreEscola()+ iterator.getPreEscola());
			escolaTaxa.setTotalInfantil(escolaTaxa.getTotalFundamental() + iterator.getTotalInfantil());			
			escolaTaxa.setPrimeiroAoQuinto(escolaTaxa.getPrimeiroAoQuinto() + iterator.getPrimeiroAoQuinto());
			escolaTaxa.setSextoAoNono(escolaTaxa.getSextoAoNono() + iterator.getSextoAoNono());
			escolaTaxa.setPrimeiroAnoFundamental(escolaTaxa.getPrimeiroAnoFundamental()+iterator.getPrimeiroAnoFundamental());
			escolaTaxa.setSegundoAnoFundamental(escolaTaxa.getSegundoAnoFundamental()+iterator.getSegundoAnoFundamental());
			escolaTaxa.setTerceiroAnoFundamental(escolaTaxa.getTerceiroAnoFundamental()+iterator.getTerceiroAnoFundamental());			
			escolaTaxa.setQuartoAnoFundamental(escolaTaxa.getQuartoAnoFundamental() + iterator.getQuartoAnoFundamental());
			escolaTaxa.setQuintoAnoFundamental(escolaTaxa.getQuintoAnoFundamental()+iterator.getQuintoAnoFundamental());
			escolaTaxa.setSextoAnoFundamental(escolaTaxa.getSextoAnoFundamental()+iterator.getSextoAnoFundamental());
			escolaTaxa.setSetimoAnoFundamental(escolaTaxa.getSetimoAnoFundamental() + iterator.getSetimoAnoFundamental());
			escolaTaxa.setOitavoAnoFundamental(escolaTaxa.getOitavoAnoFundamental() + iterator.getOitavoAnoFundamental());
			escolaTaxa.setNonoAnoFundamental(escolaTaxa.getNonoAnoFundamental() + iterator.getNonoAnoFundamental());
			escolaTaxa.setTotalFundamental(escolaTaxa.getTotalFundamental() + iterator.getTotalFundamental());			
			escolaTaxa.setPrimeiroAnoMedio(escolaTaxa.getPrimeiroAnoMedio() + iterator.getPrimeiroAnoMedio());
			escolaTaxa.setSegundoAnoMedio(escolaTaxa.getSegundoAnoMedio() + iterator.getSegundoAnoMedio());
			escolaTaxa.setTerceiroAnoMedio(escolaTaxa.getTerceiroAnoMedio() + iterator.getTerceiroAnoMedio());
			escolaTaxa.setQuartoAnoMedio(escolaTaxa.getQuartoAnoMedio() + iterator.getQuartoAnoMedio());			
			escolaTaxa.setMedioNaoSeriado(escolaTaxa.getMedioNaoSeriado() + iterator.getMedioNaoSeriado());
			escolaTaxa.setTotalMedio(escolaTaxa.getTotalMedio() + iterator.getTotalMedio());									
		}

		escolaTaxa.setCreche(escolaTaxa.getCreche()/escolaTaxaList.size());
		escolaTaxa.setPreEscola(escolaTaxa.getPreEscola()/escolaTaxaList.size());
		escolaTaxa.setTotalInfantil(escolaTaxa.getTotalFundamental()/escolaTaxaList.size());			
		escolaTaxa.setPrimeiroAoQuinto(escolaTaxa.getPrimeiroAoQuinto()/escolaTaxaList.size());
		escolaTaxa.setSextoAoNono(escolaTaxa.getSextoAoNono()/escolaTaxaList.size());
		escolaTaxa.setPrimeiroAnoFundamental(escolaTaxa.getPrimeiroAnoFundamental()/escolaTaxaList.size());
		escolaTaxa.setSegundoAnoFundamental(escolaTaxa.getSegundoAnoFundamental()/escolaTaxaList.size());
		escolaTaxa.setTerceiroAnoFundamental(escolaTaxa.getTerceiroAnoFundamental()/escolaTaxaList.size());
		escolaTaxa.setQuartoAnoFundamental(escolaTaxa.getQuartoAnoFundamental() /escolaTaxaList.size());
		escolaTaxa.setQuintoAnoFundamental(escolaTaxa.getQuintoAnoFundamental()/escolaTaxaList.size());
		escolaTaxa.setSextoAnoFundamental(escolaTaxa.getSextoAnoFundamental()/escolaTaxaList.size());
		escolaTaxa.setSetimoAnoFundamental(escolaTaxa.getSetimoAnoFundamental() /escolaTaxaList.size());
		escolaTaxa.setOitavoAnoFundamental(escolaTaxa.getOitavoAnoFundamental()/escolaTaxaList.size());
		escolaTaxa.setNonoAnoFundamental(escolaTaxa.getNonoAnoFundamental() /escolaTaxaList.size());
		escolaTaxa.setTotalFundamental(escolaTaxa.getTotalFundamental() /escolaTaxaList.size());			
		escolaTaxa.setPrimeiroAnoMedio(escolaTaxa.getPrimeiroAnoMedio()/escolaTaxaList.size());
		escolaTaxa.setSegundoAnoMedio(escolaTaxa.getSegundoAnoMedio() /escolaTaxaList.size());
		escolaTaxa.setTerceiroAnoMedio(escolaTaxa.getTerceiroAnoMedio() /escolaTaxaList.size());
		escolaTaxa.setQuartoAnoMedio(escolaTaxa.getQuartoAnoMedio() /escolaTaxaList.size());			
		escolaTaxa.setMedioNaoSeriado(escolaTaxa.getMedioNaoSeriado()/escolaTaxaList.size());
		escolaTaxa.setTotalMedio(escolaTaxa.getTotalMedio() /escolaTaxaList.size());

		escolaTaxa.setTipoTaxa(new TipoTaxa());
		escolaTaxa.getTipoTaxa().setTaxaNome(captalize(dimensao));



		return escolaTaxa; 
	}

	public static Double divisao(Double valores, int n){
		return valores/n;
	}

	public static List<EscolaTaxa> mediaMedio(List<EscolaTaxa> taxas){
		List<EscolaTaxa> taxasConvertidas = new LinkedList<>();
		List<EscolaTaxa> taxasConverter = taxas;

		EscolaTaxa escolaConversao;
		for (EscolaTaxa iterator : taxasConverter) {
			escolaConversao = new EscolaTaxa();			
			escolaConversao.setEscola(iterator.getEscola());
			escolaConversao.setTotalMedio(iterator.getPrimeiroAnoMedio() + iterator.getSegundoAnoMedio() + iterator.getTerceiroAnoMedio());
			escolaConversao.setTotalMedio(escolaConversao.getTotalMedio() + iterator.getQuartoAnoMedio());
			if(escolaConversao.getQuartoAnoMedio() == 0.0){
				escolaConversao.setTotalMedio(divisao(escolaConversao.getTotalMedio(), 3));
			}
			else
				escolaConversao.setTotalMedio(divisao(escolaConversao.getTotalMedio(), 4));
			if(!(escolaConversao.getTotalMedio().isInfinite() || escolaConversao.getTotalMedio().isNaN() || escolaConversao.getTotalMedio() == 0.0)){
				taxasConvertidas.add(escolaConversao);
			}
		}
		return taxasConvertidas;
	}

	public static List<EscolaTaxa> mediaFundamental(List<EscolaTaxa> taxas){
		List<EscolaTaxa> taxasConvertidas = new LinkedList<>();
		List<EscolaTaxa> taxasConverter = taxas;

		EscolaTaxa escolaConversao;
		for (EscolaTaxa iterator : taxasConverter) {
			escolaConversao = new EscolaTaxa();			
			escolaConversao.setEscola(iterator.getEscola());
			escolaConversao.setTotalFundamental(iterator.getPrimeiroAnoFundamental() + iterator.getSegundoAnoFundamental() + iterator.getTerceiroAnoFundamental());
			escolaConversao.setTotalFundamental(iterator.getTotalFundamental() + iterator.getQuartoAnoFundamental() + iterator.getQuintoAnoFundamental());
			escolaConversao.setTotalFundamental(iterator.getTotalFundamental() + iterator.getSextoAnoFundamental() + iterator.getSetimoAnoFundamental());
			escolaConversao.setTotalFundamental(iterator.getTotalFundamental() + iterator.getOitavoAnoFundamental() + iterator.getNonoAnoFundamental());
			escolaConversao.setTotalFundamental(iterator.getTotalFundamental() + iterator.getTurmasUnificadas());
			if(escolaConversao.getTurmasUnificadas() == 0.0){
				escolaConversao.setTotalFundamental(divisao(escolaConversao.getTotalFundamental(), 10));
			}
			else{
				escolaConversao.setTotalFundamental(divisao(escolaConversao.getTotalFundamental(), 9));
			}
			if(!(escolaConversao.getTotalFundamental().isInfinite() || escolaConversao.getTotalFundamental().isNaN() || escolaConversao.getTotalFundamental() == 0.0)){
				taxasConvertidas.add(escolaConversao);
			}
		}
		return taxasConvertidas;
	}

	public static List<EscolaTaxa> mediaInfantil(List<EscolaTaxa> taxas){
		List<EscolaTaxa> taxasConvertidas = new LinkedList<>();
		List<EscolaTaxa> taxasConverter = taxas;

		EscolaTaxa escolaConversao;
		for (EscolaTaxa iterator : taxasConverter) {
			escolaConversao = new EscolaTaxa();			
			escolaConversao.setEscola(iterator.getEscola());
			escolaConversao.setTotalInfantil(iterator.getCreche() + iterator.getPreEscola());								
			escolaConversao.setTotalInfantil(divisao(escolaConversao.getTotalInfantil(), 2));			
			if(escolaConversao.getCreche() == 0.0 || escolaConversao.getPreEscola() == 0.0){
				escolaConversao.setTotalInfantil(divisao(escolaConversao.getTotalInfantil(), 1));	
			}
			else{
				escolaConversao.setTotalInfantil(divisao(escolaConversao.getTotalInfantil(), 2));
			}
			if(!(escolaConversao.getTotalInfantil().isInfinite() || escolaConversao.getTotalInfantil().isNaN() || escolaConversao.getTotalInfantil() == 0.0)){
				taxasConvertidas.add(escolaConversao);
			}
		}
		return taxasConvertidas;
	}


}
