package util;

import java.io.IOException;

import javax.faces.context.FacesContext;

public class Rota {
	
	
	public static void redireciona(String path){
		try{
			FacesContext.getCurrentInstance().getExternalContext().redirect(path);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}
