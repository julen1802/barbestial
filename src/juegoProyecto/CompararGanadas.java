package juegoProyecto;

import java.util.Comparator;

public class CompararGanadas implements Comparator<Jugador>{

	@Override
	public int compare(Jugador pJ1, Jugador pJ2) {
		// Auto-generated method stub
		return pJ2.getpGanadas() - pJ1.getpGanadas();
	}

	
}
