package monticulo;

import arbol.Arbol;

public class Monticulo {
	
	private Arbol[] vector= new Arbol[10000];
	private int cantIngresados=0;
	
	
	public void agregar(Arbol nuevo){
	    boolean verificacion= this.cantIngresados>0;
	    this.vector[this.cantIngresados]= nuevo;
	    this.cantIngresados++;
	    if (verificacion){ // Verifica si el numero ingresado es menor o mayor que la raiz de los subarboles.
	        boolean terminar=false;
	        int posicion= this.cantIngresados;
	        int comparar;
	        while (!terminar){
	            comparar= enteroProx(posicion/2);
	            if (  (comparar==0 && posicion==1 ) || this.vector[posicion-1].getRaiz()>=this.vector[comparar-1].getRaiz())
	               terminar=true;
	            else if (this.vector[posicion-1].getRaiz()<this.vector[comparar-1].getRaiz()){
	                    Arbol aux= this.vector[comparar-1];
	                    this.vector[comparar-1]= this.vector[posicion-1] ;
	                    this.vector[posicion-1]= aux;
	                    posicion= comparar;
	            }
	        }
	    }
	}

	private int enteroProx(double numero){ // entero mas proximo
	    int num= (int) numero;
	    if (numero-num<=0.5)
	         return num;
	    else return num+1;
	}
	
	public Arbol sacarPrimero() {
		Arbol retorno=null;
		if (this.cantIngresados>0) {
			retorno= this.vector[0];
			for (int i=1;i<this.cantIngresados;i++)
				  this.vector[i-1]=this.vector[i];
			this.cantIngresados--;
			boolean verificacion= (this.cantIngresados>0);
			if (verificacion){ // Verifica si el numero ingresado es menor o mayor que la raiz de los subarboles.
		        boolean terminar=false;
		        int posicion= this.cantIngresados;
		        int comparar;
		        while (!terminar){
		            comparar= enteroProx(posicion/2);
		            if ( (comparar==0 && posicion==1 ) || this.vector[posicion-1].getRaiz()>=this.vector[comparar-1].getRaiz())
		               terminar=true;
		            else if (this.vector[posicion-1].getRaiz()<this.vector[comparar-1].getRaiz()){
		                    Arbol aux= this.vector[comparar-1];
		                    this.vector[comparar-1]= this.vector[posicion-1] ;
		                    this.vector[posicion-1]= aux;
		                    posicion= comparar;
		            }
		        }
		    }
		}
		return retorno;
	}

}
