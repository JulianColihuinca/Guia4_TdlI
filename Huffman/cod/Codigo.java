package cod;

public class Codigo {
	
	private String simbolo;
	private double probabilidad;
	private String codigo;
	
	
	public Codigo(String simbolo, double probabilidad, String codigo) {
		super();
		this.simbolo = simbolo;
		this.probabilidad = probabilidad;
		this.codigo = codigo;
	}


	public String getSimbolo() {
		return simbolo;
	}


	public double getProbabilidad() {
		return probabilidad;
	}


	public String getCodigo() {
		return codigo;
	}


	@Override
	public String toString() {
		return simbolo + " " + probabilidad + " " + codigo;
	}


	public void agregarCodigo(String codigo) {
		this.codigo+= codigo;
	}
	
	
	
	
	
	

}
