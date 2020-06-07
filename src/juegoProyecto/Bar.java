package juegoProyecto;
import java.util.ArrayList;

public class Bar {
	private ListaCartas bar;
	private static Bar miBar;
	public Bar() {
		
	}
	public static Bar getBar() {
		if(miBar==null) {
			miBar = new Bar();
		}
		return miBar;
	}
	public void reiniciarLista() {
		bar = new ListaCartas();
	}
	public void anadirCarta(Carta pCarta) {
		bar.agregarCarta(pCarta);
	}
	public ArrayList<Jugador> contarPuntos(ArrayList<Jugador> pLJugadores) {
		for (int i = 0; i<pLJugadores.size();i++) {
			pLJugadores.get(i).resetPunt();
		}
		for(int j = 1; j<=bar.size();j++) {
			Carta c = bar.getCartaEnPos(j);
			for (int i = 0; i<pLJugadores.size();i++) {
				if(pLJugadores.get(i).color == c.color) {
					pLJugadores.get(i).anadirPuntuacion(c);
				}
			}
		}
		return pLJugadores;
	}
	public String getEntrantes() {
		int size = bar.size();
		String dosCartas = bar.getCartaEnPos(size).imprimirCarta() + " " + bar.getCartaEnPos(size-1).imprimirCarta();
		return dosCartas;
	}
	public int size() {
		return bar.size();
	}
	
}
