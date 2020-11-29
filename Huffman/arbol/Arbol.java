package arbol;

public class Arbol implements Comparable<Arbol> {
	
	private double raiz;
	private String simbolo;
	private Arbol izq,der;
	
	public Arbol(double raiz, String simbolo, Arbol izq, Arbol der) {
		super();
		this.raiz = raiz;
		this.simbolo = simbolo;
		this.izq = izq;
		this.der = der;
	}
	
	public Arbol(double raiz, String simbolo) {
		super();
		this.raiz = raiz;
		this.simbolo = simbolo;
		this.izq = null;
		this.der = null;
	}
	
	public Arbol(double raiz, Arbol izq, Arbol der) {
		super();
		this.raiz = raiz;
		this.simbolo = null;
		this.izq = izq;
		this.der = der;
	}

	public double getRaiz() {
		return raiz;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public Arbol getIzq() {
		return izq;
	}

	public Arbol getDer() {
		return der;
	}

	@Override
	public int compareTo(Arbol arg0) {
		int res;
		if (this.getRaiz()>=arg0.getRaiz())
			res=1;
		else 
			res=-1;
		return res;
	}
	
	
	
}
