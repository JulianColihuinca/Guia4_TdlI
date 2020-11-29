package funcion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import arbol.Arbol;
import cod.Codigo;
import monticulo.Monticulo;
import ordenador.Ordenador;

public class Huffman {
	private ArrayList<String> simbolos;
	private ArrayList<Double> probabilidades;
	private Arbol huffmanArbol;
	private String codigo="";
	private ArrayList<Codigo> codigos = new ArrayList<Codigo>(); 
	
	public Huffman(ArrayList<String> simbolos, ArrayList<Double> probabilidades) {
		super();
		this.simbolos = simbolos;
		this.probabilidades = probabilidades;
		this.huffmanArbol=null;
		this.execute();
	}
	
	private void execute() {
		//Monticulo colaPrioridad= new Monticulo();
		PriorityQueue<Arbol> colaPrioridad= new PriorityQueue<Arbol>();
		double fz;
		Arbol x,y,z;
		for (int i=0;i<this.probabilidades.size();i++) {
			colaPrioridad.add(new Arbol(this.probabilidades.get(i),this.simbolos.get(i)));
		}
		
		for (int i=1;i<this.probabilidades.size();i++) {
			x= colaPrioridad.element();
			colaPrioridad.remove();
			y= colaPrioridad.element();
			colaPrioridad.remove();
			fz= x.getRaiz() + y.getRaiz();
			z= new Arbol(fz,x,y);
			colaPrioridad.add(z);
		}
		
		z= colaPrioridad.element();
		this.huffmanArbol=z;
	}

	public String getResumen() {
		this.executeCodigo(huffmanArbol, "");
		Ordenador.ordenaDecrecienteCodigo(codigos);
		codigo+="Simbolo Ascii    Probabilidad    Codigo\n"; 
		for (int i=0;i<this.codigos.size();i++)
			  codigo += this.codigos.get(i) + "\n";
		codigo+= String.format("\nEntropia= %.3f binits , Longitud Media= %.3f binits \n", this.entropia(),this.longMedia());
		codigo+= String.format("\nRendimiento= %.2f  , Redundancia= %.2f \n", this.rendimiento(),this.redundancia());
		return codigo;
	}
	
	private  void executeCodigo(Arbol a, String str) {
		if (a!=null) {
			if (a.getIzq()==null && a.getDer()==null) {
				this.codigos.add(new Codigo(a.getSimbolo(),a.getRaiz(),str));
			}
			else {
				this.executeCodigo(a.getIzq(), str+"0");
				this.executeCodigo(a.getDer(), str+"1");
			}
		}
	}
	
	private double entropia() {
		double entropia=0;
		for (int i=0;i<this.codigos.size();i++) {
			  double p=this.codigos.get(i).getProbabilidad();
			  entropia+= p* (Math.log10(1/p) / Math.log10(2));
		}			  
		return entropia;
	}
	
	private double longMedia() {
		double lm=0;
		for (int i=0;i<this.codigos.size();i++) {
			  lm+= this.codigos.get(i).getProbabilidad() * this.codigos.get(i).getCodigo().length();
		}			  
		return lm;
	}
	
	private double rendimiento() {
		return (this.entropia()/this.longMedia()) * 100;
	}
	
	private double redundancia() {
		return 100-rendimiento();
	}
	
	public HashMap<String,Codigo> getHashMap(){
		HashMap<String,Codigo> hash= new HashMap<String,Codigo>();
		for (int i=0;i<this.codigos.size();i++) {
			hash.put(this.codigos.get(i).getSimbolo(), this.codigos.get(i));
		}
		return hash;
	}
		
	
	
}
