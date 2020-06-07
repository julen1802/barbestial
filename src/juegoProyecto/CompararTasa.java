package juegoProyecto;

import java.util.Comparator;

public class CompararTasa implements Comparator<Jugador>{

	@Override
	public int compare(Jugador pJ1, Jugador pJ2) {
		// Auto-generated method stub
		double j1 = 0.0,j2 = 0.0,j1G = 0.0,j2G = 0.0,j1J = 0.0,j2J = 0.0;
		if(pJ1.getpJugadas()>0) {
			j1G = pJ1.getpGanadas();
			j1J = pJ1.getpJugadas();
			j1 = (j1G/j1J);
		}
		if(pJ2.getpJugadas()>0) {
			j2G = pJ2.getpGanadas();
			j2J = pJ2.getpJugadas();
			j2 = (j2G/j2J);
		}
		double dif = j2-j1;
		if(dif==0.0) {
			return 0;
		}
		else if(dif<0.0){
			return - 1;
		}
		else {
			return 1;
		}
	}

	
}
