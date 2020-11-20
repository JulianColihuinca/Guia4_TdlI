package maximo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import cod.Codigo;

public class Operaciones {
	
	public static int maximo(HashMap<String, Codigo> hashmap) {
		int max=0;
		Iterator<Entry<String,Codigo>> it= hashmap.entrySet().iterator();
		
		while (it.hasNext()) {
			Codigo value=it.next().getValue();
			if (value.getCodigo().length()>max)
				max= value.getCodigo().length();
		}
		return max;
	}
	
	public static int getMinimaLongitud(HashMap<String,Codigo> codigos) {
		int minima=5000;
		Iterator<Entry<String, Codigo>> it= codigos.entrySet().iterator();
		while (it.hasNext()) {
			Codigo c= it.next().getValue();
			if (c.getCodigo().length()<minima) {
				minima= c.getCodigo().length();
			}
		}
		return minima;
	}
	
	public static int getMaximaLongitud(HashMap<String,Codigo> codigos) {
		int maxima=0;
		Iterator<Entry<String, Codigo>> it= codigos.entrySet().iterator();
		while (it.hasNext()) {
			Codigo c= it.next().getValue();
			if (c.getCodigo().length()>maxima) {
				maxima= c.getCodigo().length();
			}
		}
		return maxima;
	}
	
	public static String contiene(String codigo, HashMap<String,Codigo> codigos) {
		Iterator<Entry<String, Codigo>> it= codigos.entrySet().iterator();
		boolean contiene=false;
		String res="";
		while (it.hasNext() && !contiene) {
			Codigo c= it.next().getValue();
			contiene= c.getCodigo().equalsIgnoreCase(codigo);
			if (contiene) {
				res= c.getSimbolo();
			}
		}
		return res;
		
	}

}
