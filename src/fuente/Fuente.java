package fuente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import ordenador.Ordenador;

public class Fuente {
	private  ArrayList<String> simbolos;
	private ArrayList<String> codigos;
	private ArrayList<Double> probabilidades;
	private ArrayList<Integer> frecuencias;
	
	public Fuente(String texto,boolean archivo) {
		
		if (archivo) {
			try {
				Scanner arch= new Scanner(new File(texto));
				this.codigos= new ArrayList<String>();
				this.probabilidades= new ArrayList<Double>();
				while (arch.hasNext()) {
					this.probabilidades.add(Double.parseDouble(arch.next()));
					this.codigos.add(arch.next());
				}
				this.simbolos= new ArrayList<String>();
				for (int i=0;i<this.probabilidades.size();i++) 
					this.simbolos.add("S" + (i+1));
				arch.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("No se encontro el archivo: " + texto);
			}
		}
		else {
			this.simbolos= new ArrayList<String>();
			int suma=0;
			this.frecuencias=new ArrayList<Integer>();
			this.probabilidades= new ArrayList<Double>();
			for (int i=0;i<texto.length();i++) {
				if (this.simbolos.isEmpty() || !this.simbolos.contains(Character.toString(texto.charAt(i)))) { 
					this.simbolos.add(Character.toString(texto.charAt(i)));
					this.probabilidades.add(1.0);
					this.frecuencias.add(1);
				}	
				else {
					int pos= this.simbolos.indexOf(Character.toString(texto.charAt(i)));
					double nuevo= this.probabilidades.get(pos) + 1;
					this.frecuencias.set(pos, this.frecuencias.get(pos)+1);
					this.probabilidades.set(pos, nuevo);
				}
				suma++;
			}
			for (int i=0;i<this.probabilidades.size();i++) {
				double nuevo= this.probabilidades.get(i)/suma;
				this.probabilidades.set(i, nuevo );
			}	
			Ordenador.ordenaDecreciente(this.simbolos, this.frecuencias, this.probabilidades);
		}
	}
		
	
	public void muestra() {
		System.out.println("\nFuente:");
		boolean sinCodigo= (this.codigos==null || this.codigos.isEmpty());
		for (int i=0;i<this.probabilidades.size();i++) {
			if (!sinCodigo)
			System.out.println(String.format("%s  %.3f  %s", this.simbolos.get(i),this.probabilidades.get(i),this.codigos.get(i)));
			else
			System.out.println(String.format("%s  %d  %.3f ", this.simbolos.get(i),this.frecuencias.get(i),this.probabilidades.get(i)));	
		}
	}
	
	public double longitudMedia(int orden) {
		double res= 0;
		for (int i=0;i<this.codigos.size();i++) {
			res+=this.codigos.get(i).length() * this.probabilidades.get(i);
		}
		return orden*res;
	}
	
	public double entropia(int orden) {
		double res= 0;
		for (int i=0;i<this.probabilidades.size();i++) {
			res+= this.probabilidades.get(i)* (Math.log10(1/this.probabilidades.get(i))/ Math.log10(2));
		}
		return orden*res;
	}
	
	public boolean cumpleShannon(int orden) {
		double l1=this.longitudMedia(orden)/orden;
		double ent=entropia(1);
		double suma= (double)1/orden;
		double cotasup= ent + suma;
		return ent<= l1 &&  l1 < cotasup; 
	}
	
	public double rendimiento() {
		return this.entropia(1)/this.longitudMedia(1);
	}
	
	public double redundancia() {
		return 1-this.rendimiento();
	}

}
