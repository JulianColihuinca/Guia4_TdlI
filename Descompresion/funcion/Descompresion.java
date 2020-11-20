package funcion;

import java.util.HashMap;

import cod.Codigo;
import maximo.Operaciones;

public class Descompresion {
	
	public static String descomprimirRLC(String comprimido) {
		String mensaje= "";
		String numero;
		String letra;
		int i=0;
		while(i<comprimido.length()) {
			numero="";
			while( i<comprimido.length() &&  (comprimido.charAt(i)>='1' && comprimido.charAt(i)<='9')) {
				numero+= Character.toString(comprimido.charAt(i));
				i++;
			}
			letra="";
			while( i<comprimido.length() &&   (comprimido.charAt(i)<'0' || comprimido.charAt(i)>'9') ){
				letra+= Character.toString(comprimido.charAt(i));
				i++;
			}
			int num;
			if (numero.equalsIgnoreCase(""))
				num=0;
			else 
				num=Integer.parseInt(numero);
			for (int j=0;j<num;j++) 
					if (letra.equalsIgnoreCase("espacio"))
						  mensaje+=" ";
					else
						mensaje+=letra;
		}
		return mensaje;
	}
	
	
	public static String descomprimir(String mensaje, HashMap<String,Codigo> codigos) {
		String mensajeFinal="";
		int minimo= Operaciones.getMinimaLongitud(codigos);
		int maximo=Operaciones.getMaximaLongitud(codigos);
		int i=0;
		String codigoActual;
		while(i<mensaje.length()) {
			codigoActual="";
			for (int j=0;i<mensaje.length() && j<minimo;j++) {
				codigoActual+=Character.toString(mensaje.charAt(i));
				i++;
			}
			boolean encontrada=false;
			for (int j=0;i<=mensaje.length() && j<maximo-minimo && !encontrada;j++) {
				String esta= Operaciones.contiene(codigoActual, codigos);
				if (!esta.equalsIgnoreCase("")) {
					encontrada=true;
					if (!esta.equalsIgnoreCase("espacio"))
						mensajeFinal+= esta;
					else 
						 mensajeFinal+=" ";
				}
				else {
				codigoActual+=Character.toString(mensaje.charAt(i));
				i++;
				}
				
			}
			
		}
		return mensajeFinal;
	}
	
	

}
