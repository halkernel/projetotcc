package util;

import java.util.Map;

public class PegaValores {

	public static String getTaxa(Map<String, String> params){
		for(String s : params.keySet()){			
			String values = params.get(s);		
			if(s.contains("taxa")){
				return values;
			}
		}
		return null;
	}
	
	public static String getDimensao(Map<String, String> params){
		for(String s : params.keySet()){			
			String values = params.get(s);		
			if(s.contains("dimensao")){
				return values;
			}
		}
		return null;
	}
	
	public static String getEscola(Map<String, String> params){
		for(String s : params.keySet()){			
			String values = params.get(s);		
			if(s.contains("escola")){
				return values;
			}
		}
		return null;
	}


}
