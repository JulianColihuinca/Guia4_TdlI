package funcion;

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

}
