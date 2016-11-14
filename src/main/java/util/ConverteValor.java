package util;

import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;

public class ConverteValor {
	
	
		
	public static String removeAcento(String st){
		st = Normalizer.normalize(st,Normalizer.Form.NFD);
		st = st.replaceAll("[^\\p{ASCII}]", "");
		return st;		
	}
	
	public static <T> LinkedList<T> toLinkedList(List<T> list){
		LinkedList<T> newList = new LinkedList<>();
		for (T t : list) {
			newList.add(t);
		}
		return newList;
	}

}
