package Prueba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import cod.Codigo;
import excepciones.SimboloNoEncontrado;
import formatos.Formato;
import funcion.Compresion;
import funcion.Descompresion;
import funcion.Hamming;
import funcion.Huffman;
import ordenador.Ordenador;

public class Main {

	public static void main(String[] args) {
		int cant=7;
		Scanner teclado= new Scanner(System.in);
		System.out.print("Ingrese palabra: ");
		String palabra= teclado.nextLine();
		Formato.HuffmanTexto(palabra);
		
	}

}
