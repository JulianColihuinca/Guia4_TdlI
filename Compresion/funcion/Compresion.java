package funcion;


import java.util.ArrayList;
import java.util.HashMap;

import cod.Codigo;
import excepciones.SimboloNoEncontrado;

public class Compresion {
	
	private HashMap<String,Codigo> codigos;

	
	
	
	public Compresion(HashMap<String,Codigo> codigos) {
		super();
		this.codigos = codigos;
	}




	public String comprimir(String mensaje) throws SimboloNoEncontrado {
		String compresion="";
		for (int i=0;i<mensaje.length();i++) {
			Codigo cod;
			if (mensaje.charAt(i)==' ') {
				cod=this.codigos.get("espacio");
			}
			else {
				if (this.codigos.containsKey(Character.toString(mensaje.charAt(i)))) {
					cod=this.codigos.get(Character.toString(mensaje.charAt(i)));
				}
				else 
					throw new SimboloNoEncontrado(Character.toString(mensaje.charAt(i)));
			}
			compresion+= cod.getCodigo();
		}
		return compresion;
	}
	

}
