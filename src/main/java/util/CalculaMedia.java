package util;

import java.util.LinkedList;
import java.util.List;

public class CalculaMedia {
		

	public static Double calculaMedia(List<Double> list){
			double soma = 0;
			int quantidade = list.size();
			for (Double value : list) {
				soma+=value;				
			}			
			return soma/quantidade;
	}
	
	//calculo do município
	//somar todas as escolas 
	
	//cálculo do estado
	//somar todas os municípios
	
	//cálculo da região
	//somar todos os estados
	
	//calculo do país
	//soma todos os estados

}
