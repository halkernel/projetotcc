package util;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class Rota {
	
	private static String page = "../pages/";
	
	
	public static void redireciona(String path){
		try{
			FacesContext.getCurrentInstance().getExternalContext().redirect(page+path);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
