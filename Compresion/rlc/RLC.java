package rlc;

public class RLC {
	
	public static String getComprimido(String mensaje) {
		String comprimido="";
		int contar=0;
		int i=0;
		String actual;
		while (i<mensaje.length()) {
			if (mensaje.charAt(i)==' ')
				actual="espacio";
			else 
				actual=Character.toString(mensaje.charAt(i));
			contar=0;
			while (i<mensaje.length() && ( (actual.equalsIgnoreCase("espacio") && mensaje.charAt(i)==' ')   || Character.toString(mensaje.charAt(i)).equalsIgnoreCase(actual)) ){
				i++;contar++;
			}
			comprimido+= contar+actual;
		}
		return comprimido;
	}

}
