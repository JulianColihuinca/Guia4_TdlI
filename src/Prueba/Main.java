package Prueba;

import java.util.ArrayList;

import formatos.Formato;
import funcion.Huffman;
import ordenador.Ordenador;

public class Main {

	public static void main(String[] args) {
		//String cadena="05987463258784784512536669895745123656253698989656452121702300223659";
		//Formato.porCadena(cadena);
		String direccion="Shannon.txt";
		Formato.shannonFanoArchivo(direccion);
	}

}
