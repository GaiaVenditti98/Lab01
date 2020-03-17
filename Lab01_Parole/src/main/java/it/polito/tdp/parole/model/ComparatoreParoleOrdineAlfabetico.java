package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ComparatoreParoleOrdineAlfabetico  implements Comparator<String>{

	
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

}
