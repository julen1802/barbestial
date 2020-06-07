package juegoProyecto;

public class Puntuacion {

	private int cartasMetidas;
	private int puntos;
	
	public Puntuacion(int pCartasMetidas, int pPuntos){
		cartasMetidas = pCartasMetidas;
		puntos = pPuntos;
	}

	public String imprimirGuardadoPuntuacion() {
		return (cartasMetidas + " " + puntos);
	}
	
	public void cambiarPuntuacion(int pCartasMetidas, int pPuntos) {
		cartasMetidas = pCartasMetidas;
		puntos = pPuntos;
	}

	public void reset() {
		cartasMetidas = 0;
		puntos = 0;
	}

	public void anadirPuntuacion(Carta pCarta) {
		if(pCarta!=null) {
			cartasMetidas++;
			puntos = puntos+pCarta.fuerza;
		}
	}

	public int compararPuntuacion(Jugador pJug) {
		int p = 0;
		String[] pJ2 = pJug.getPuntuacion().split(" ");

		if(cartasMetidas>Integer.parseInt(pJ2[0])) {
			p = 1;
		}
		else if(cartasMetidas<Integer.parseInt(pJ2[0])) {
			p = -1;
		} else {
			if(puntos>Integer.parseInt(pJ2[1])) {
				p = 1;
			}
			else if(puntos<Integer.parseInt(pJ2[1])) {
				p = -1;
			}
			else {
				p=0;	
			}
		}
		return p;
	}

	public void setPuntuacion(String pPuntuacion) {
		String[] punt2 = pPuntuacion.split(" ");
		cartasMetidas = Integer.parseInt(punt2[0]);
		puntos = Integer.parseInt(punt2[1]);
	}
}
