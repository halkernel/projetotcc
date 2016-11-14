package util;

import java.util.Map;

public class PegaValores {

	public static String[] getTaxas(Map<String, String[]> params){
		for(String s : params.keySet()){			
			String[] values = params.get(s);			
			for(int i = 0; i < values.length; i++){		
				if(values[i].contains("TAXA") || values[i].contains("MEDIA")){
					return values;
				}
			}			
		}
		return null;
	}


}
