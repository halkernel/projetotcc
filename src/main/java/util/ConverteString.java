package util;

import java.text.Normalizer;

public class ConverteString {
	
	
		
	public static String removeAcento(String st){
		st = Normalizer.normalize(st,Normalizer.Form.NFD);
		st = st.replaceAll("[^\\p{ASCII}]", "");
		return st;		
	}

}
