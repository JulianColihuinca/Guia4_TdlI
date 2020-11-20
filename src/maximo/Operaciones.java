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

}
