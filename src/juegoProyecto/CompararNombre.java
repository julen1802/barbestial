package juegoProyecto;

import java.util.Comparator;

public class CompararNombre implements Comparator<Jugador>{

	@Override
	public int compare(Jugador pJ1, Jugador pJ2) {
		// Auto-generated method stub
		return pJ1.getUsername().compareTo(pJ2.getUsername());
	}

	
}
