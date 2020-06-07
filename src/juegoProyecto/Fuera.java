package juegoProyecto;

public class Fuera {
	private ListaCartas fuera;
	private static Fuera miFuera;
	public Fuera() {
		
	}
	public static Fuera getFuera() {
		if(miFuera==null) {
			miFuera = new Fuera();
		}
		return miFuera;
	}
	public void reiniciarLista() {
		fuera = new ListaCartas();
	}
	public void anadirCarta(Carta pCarta) {
		fuera.agregarCarta(pCarta);
	}
	public String getEchada() {
		return fuera.getCartaEnPos(fuera.size()).imprimirCarta();
	}
	public int size() {
		return fuera.size();
	}
}
