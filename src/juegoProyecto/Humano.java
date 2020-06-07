package juegoProyecto;


public class Humano extends Jugador{
	
	private String contrasena;
	
	public Humano(String pUsername, int pPGanadas, int pPJugadas, int pCartasMetidas, int pPuntos, String pContrasena) {
		super(pUsername, pPGanadas, pPJugadas, pCartasMetidas, pPuntos);
		contrasena = pContrasena;
	}
	
	public void elegirCarta(int pInd) {	
		Carta pCarta = mano.getCartaEnPos(pInd);
		jugarCarta(pCarta);
	}
	
	public boolean igualContrasena(String pContrasena) {
		boolean igual = false;
		if(this.contrasena.equals(pContrasena)){
			igual = true;
		}
		return igual;
	}

	public String imprimirGuardadoContraseina(){
		return contrasena;
	}
	
}
