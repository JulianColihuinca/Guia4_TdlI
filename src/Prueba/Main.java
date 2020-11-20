package Prueba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import cod.Codigo;
import excepciones.SimboloNoEncontrado;
import formatos.Formato;
import funcion.Compresion;
import funcion.Descompresion;
import funcion.Huffman;
import ordenador.Ordenador;

public class Main {

	public static void main(String[] args) {
		Scanner teclado= new Scanner(System.in);
		//String cadena="05987463258784784512536669895745123656253698989656452121702300223659";
		//Formato.porCadena(cadena);
		String direccion="Huffman.txt";
		Formato.huffmanArchivo(direccion);
		HashMap<String,Codigo> codigos= Formato.getHashMapCodigo();
		System.out.print("\n\nIngrese mensaje: ");
		String mensaje= teclado.nextLine();
		Compresion compresion=new Compresion(codigos);
		try {
			System.out.println("\n\nEl mensaje codificado es:\n " + compresion.comprimir(mensaje));
			System.out.println("\n\nEl mensaje comprimido por RLC es:\n " + compresion.getComprimidoRLC());
			System.out.println("\n\nMensaje RLC descomprimido:\n " + Descompresion.descomprimirRLC(compresion.getComprimidoRLC()) );
			System.out.println("\n\nMensaje descomprimido:\n " + Descompresion.descomprimir(compresion.comprimir(mensaje), Formato.getHashMapCodigo()) );
		} catch (SimboloNoEncontrado e) {
			System.out.println(e.getMessage());
		}
	}

}
