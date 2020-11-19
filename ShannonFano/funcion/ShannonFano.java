package funcion;

import java.util.ArrayList;
import java.util.HashMap;

import cod.Codigo;

public class ShannonFano {
	private ArrayList<String> simbolos;
	private ArrayList<Double> probabilidades;
	private HashMap<String, Codigo> codigos;
	
	
	public ShannonFano(ArrayList<String> simbolos, ArrayList<Double> probabilidades) {
		super();
		this.simbolos = simbolos;
		this.probabilidades = probabilidades;
		this.codigos= new HashMap<String,Codigo>();
		for (int i=0;i<this.simbolos.size();i++) {
			this.codigos.put(this.simbolos.get(i), new Codigo(this.simbolos.get(i),this.probabilidades.get(i),""));
		}
		this.execute();
	}
	
	private void execute() {
		if (this.simbolos.size()<2) {
			this.codigos.get(this.simbolos.get(0)).agregarCodigo("1");
		}
		else {
			int cabeza=2;
			for (int j=0;j<this.simbolos.size()/2;j++) {
				if (cabeza>=this.probabilidades.size()) {
					this.codigos.get(this.simbolos.get(cabeza-2)).agregarCodigo("1");
					this.codigos.get(this.simbolos.get(cabeza-1)).agregarCodigo("0");
				}
				else {
					this.codigos.get(this.simbolos.get(cabeza-2)).agregarCodigo("11");
					this.codigos.get(this.simbolos.get(cabeza-1)).agregarCodigo("10");
				}
				for (int i=cabeza; i<this.simbolos.size();i++) {
					this.codigos.get(this.simbolos.get(i)).agregarCodigo("0");
				}
				cabeza+=2;
			}	
		}
	}
	
	private double entropia() {
		double entropia=0;
		for (int i=0;i<this.probabilidades.size();i++) {
			  double p=this.probabilidades.get(i);
			  entropia+= p* (Math.log10(1/p) / Math.log10(2));
		}			  
		return entropia;
	}
	
	private double longMedia() {
		double lm=0;
		for (int i=0;i<this.simbolos.size();i++) {
			  lm+= this.probabilidades.get(i)* this.codigos.get(this.simbolos.get(i)).getCodigo().length();
		}			  
		return lm;
	}
	
	private double rendimiento() {
		return (this.entropia()/this.longMedia()) * 100;
	}
	
	private double redundancia() {
		return 100-rendimiento();
	}
	
	public String getResumen() {
		String codigo="";
		for (int i=0;i<this.simbolos.size();i++)
			  codigo += this.codigos.get(this.simbolos.get(i)) + "\n";
		codigo+= String.format("\nEntropia= %.3f binits , Longitud Media= %.3f binits \n", this.entropia(),this.longMedia());
		codigo+= String.format("\nRendimiento= %.2f  , Redundancia= %.2f \n", this.rendimiento(),this.redundancia());
		return codigo;
	}
	

}
