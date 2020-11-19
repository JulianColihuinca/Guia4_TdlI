package excepciones;

public class SimboloNoEncontrado extends Exception {
	
	private String simbolo;

	public SimboloNoEncontrado(String simbolo) {
		super("No se encontro el simbolo: " + simbolo);
		this.simbolo = simbolo;
	}
	
	

}
