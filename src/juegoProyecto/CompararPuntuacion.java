package juegoProyecto;

import java.util.Comparator;

public class CompararPuntuacion implements Comparator<Jugador>{

	@Override
	public int compare(Jugador pJ1, Jugador pJ2) {
		// Auto-generated method stub
		String[] s1 = pJ1.getPuntuacion().split(" ");
		String[] s2 = pJ2.getPuntuacion().split(" ");
		int i = Integer.parseInt(s2[0])-Integer.parseInt(s1[0]);
		if(i==0) {
			i = Integer.parseInt(s2[1])-Integer.parseInt(s1[1]);
		}
		return i;

	}

	
}
