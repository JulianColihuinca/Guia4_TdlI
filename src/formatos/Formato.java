package formatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import cod.Codigo;
import fuente.Fuente;
import funcion.Huffman;
import funcion.ShannonFano;
import ordenador.Ordenador;

public class Formato {
	
	private static  HashMap<String,Codigo> hashmap;
	public static void porArchivo(String direccion) {
		Fuente f= new Fuente(direccion,true);
		f.muestra();
		int orden=1;
		System.out.println("\n"+String.format("Entropia: %.3f", f.entropia(1)));
		System.out.println("\n"+String.format("Longitud Media: %.3f", f.longitudMedia(orden)));
		if (f.cumpleShannon(orden))
			System.out.println("\nCumple Shannon");
		else
			System.out.println("\nNo Cumple Shannon");
		
		System.out.println("\n"+String.format("Rendimiento: %.3f", f.rendimiento()));
		System.out.println("\n"+String.format("Redundancia: %.3f", f.redundancia()));
	}
	
	public static void porCadena(String cadena) {
		Fuente f= new Fuente(cadena,false);
		f.muestra();
	}
	
	
	public static void huffmanArchivo(String direccion) {
		ArrayList<String> simbolos;
		ArrayList<Double> probabilidades;
		try {
			Scanner arch= new Scanner(new File(direccion));
			simbolos= new ArrayList<String>();
			probabilidades= new ArrayList<Double>();
			while (arch.hasNext()) {
				simbolos.add(arch.next());
				probabilidades.add(Double.parseDouble(arch.next()));
			}
			arch.close();
			Ordenador.ordenaDecreciente2(simbolos, probabilidades);
			Huffman hufmman= new Huffman(simbolos,probabilidades);
			System.out.println(hufmman.getResumen());
			hashmap= hufmman.getHashMap();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo: " + direccion);
		}
	}
	
	public static void huffmanArchivo2(String direccion) {
		ArrayList<String> simbolos;
		ArrayList<Double> probabilidades;
		try {
			Scanner arch= new Scanner(new File(direccion));
			simbolos= new ArrayList<String>();
			probabilidades= new ArrayList<Double>();
			int cant=0;
			while (arch.hasNext()) {
				String simbolo= arch.next();
				if (simbolos.contains(simbolo)) {
					int index= simbolos.indexOf(simbolo);
					probabilidades.set(index, probabilidades.get(index)+1 );
				}
				else {
					simbolos.add(simbolo);
					probabilidades.add(1.0);
				}
				cant++;
			}
			arch.close();
			for (int i=0;i<probabilidades.size() ;i++) {
				probabilidades.set(i, probabilidades.get(i)/cant );
			}
			Ordenador.ordenaDecreciente2(simbolos, probabilidades);
			Huffman hufmman= new Huffman(simbolos,probabilidades);
			System.out.println(hufmman.getResumen());
			hashmap=hufmman.getHashMap();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo: " + direccion);
		}
	}
	
	public static void shannonFanoArchivo(String direccion) {
		ArrayList<String> simbolos;
		ArrayList<Double> probabilidades;
		try {
			Scanner arch= new Scanner(new File(direccion));
			simbolos= new ArrayList<String>();
			probabilidades= new ArrayList<Double>();
			while (arch.hasNext()) {
				simbolos.add(arch.next());
				probabilidades.add(Double.parseDouble(arch.next()));
			}
			arch.close();
			Ordenador.ordenaDecreciente2(simbolos, probabilidades);
			ShannonFano sf= new ShannonFano(simbolos,probabilidades);
			System.out.println(sf.getResumen());
			hashmap=sf.getHashMap();
		} catch (FileNotFoundException e) {
			System.out.println("No se encontro el archivo: " + direccion);
		}
	}
	
	public static HashMap<String,Codigo> getHashMapCodigo() {
		return hashmap;
	}

}
