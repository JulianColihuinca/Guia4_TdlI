package ordenador;

import java.util.ArrayList;

import cod.Codigo;

public class Ordenador {
		public static void ordenaDecreciente(ArrayList<String> simbolos, ArrayList<Integer> frecuencias,ArrayList<Double> probabilidades) {
			int i,j;
			for (i=0;i<probabilidades.size()-1;i++) {
				int maximo= i;
				for (j=i+1;j<probabilidades.size();j++) 
					if (probabilidades.get(j)> probabilidades.get(maximo))
						 maximo=j;
				if (maximo!=i) {
					String auxSimbolo= simbolos.get(i);
					int auxFrecuencia= frecuencias.get(i);
					double auxProbabilidad= probabilidades.get(i);
					simbolos.set(i, simbolos.get(maximo));
					frecuencias.set(i, frecuencias.get(maximo));
					probabilidades.set(i, probabilidades.get(maximo));
					simbolos.set(maximo, auxSimbolo);
					frecuencias.set(maximo, auxFrecuencia);
					probabilidades.set(maximo, auxProbabilidad);
				}
			}
			
		}
		
		public static void ordenaDecreciente2(ArrayList<String> simbolos,ArrayList<Double> probabilidades) {
			int i,j;
			for (i=0;i<probabilidades.size()-1;i++) {
				int maximo= i;
				for (j=i+1;j<probabilidades.size();j++) 
					if (probabilidades.get(j)> probabilidades.get(maximo))
						 maximo=j;
				if (maximo!=i) {
					String auxSimbolo= simbolos.get(i);
					double auxProbabilidad= probabilidades.get(i);
					simbolos.set(i, simbolos.get(maximo));
					probabilidades.set(i, probabilidades.get(maximo));
					simbolos.set(maximo, auxSimbolo);
					probabilidades.set(maximo, auxProbabilidad);
				}
			}
			
		}
		
		public static void ordenaDecrecienteCodigo(ArrayList<Codigo> codigo) {
			int i,j;
			for (i=0;i<codigo.size()-1;i++) {
				int maximo= i;
				for (j=i+1;j<codigo.size();j++) 
					if (codigo.get(j).getProbabilidad()> codigo.get(maximo).getProbabilidad())
						 maximo=j;
				if (maximo!=i) {
					Codigo auxCod= codigo.get(i);
					codigo.set(i, codigo.get(maximo));
					codigo.set(maximo, auxCod);
				}
			}
			
		}
}
