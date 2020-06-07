package juegoProyecto;

public abstract class Jugador {
	protected ListaCartas mano;
	private ListaCartas mazo;
	protected EnumColor color;
	private boolean turno;
	private String username;
	
	private int pGanadas;
	private int pJugadas;
	private Puntuacion puntuacion;
	
	public Jugador(String pUsername, int pPGanadas, int pPJugadas, int pCartasMetidas, int pPuntos) {
		mano = new ListaCartas();
		mazo = new ListaCartas();
		turno = false;
		username = pUsername;
		pGanadas = pPGanadas;
		pJugadas = pPJugadas;
		puntuacion = new Puntuacion(pCartasMetidas, pPuntos);
	}
	public String imprimirLista() {
		return mano.imprimirNombres();
	}
	public void asignarColor(EnumColor pColor) {
		color = pColor;
	}
	public String getNombre() {
		return username;
	}
	public String imprimirCartas() {
		return mano.imprimirCartas();
	}
	public boolean esSuTurno() {
		return turno;
	}
	public ListaCartas getMano() {
		return mano;
	}
	public EnumColor devolverColor() {
		return color;
	}
	public void reiniciar() {
		mano.vaciar();
		mazo.vaciar();
	}
	public ListaCartas getMazo() {
		return mazo;
	}
	public void jugarCarta(Carta pCarta) {
		echarCarta(pCarta);
		Sonido.getSonido().reproducirSonido(pCarta.imprimirNombre());
		int size = Cola.getCola().size();
		Carta unaCarta = Cola.getCola().getCartaEnPos(size);
		unaCarta.hacerAnimalada();
		if(!(unaCarta instanceof Eleccion)) {
			cogerCarta();
			Partida.getPartida().cartaJugada(unaCarta);
		}
	}
	public void crearBaraja(EnumColor pColor) {
		mazo.crearBaraja(pColor);
	}
	public void echarCarta(Carta pCarta) {
		Cola.getCola().anadirCarta(pCarta);
		mano.borrarCarta(pCarta);
	}
	public void robarMano() {
		for(int ind = 4; ind>0; ind--) {
			cogerCarta();
		}
	}
	public void cogerCarta() {
		if(!mazo.vacia()) {
			Carta unaCarta = mazo.cogerCartaAlAzar();
			mano.agregarCarta(unaCarta);
			System.out.println("A�adida carta");
		}
	}	
	public int getpGanadas() { //SE USA EN COMPARARGANDAS
		return pGanadas;
	}

	public String getUsername() { //SE USA EN ANADIRJUG DE LISTAJUGADORES
		return username;
	}

	public String imprimirGuardadoJug() {
		String st = null;
		if(this instanceof Humano){
			st = (username + " " + ((Humano) this).imprimirGuardadoContraseina() + " " + pGanadas  + " " + pJugadas + " " + puntuacion.imprimirGuardadoPuntuacion());
		}else if(this instanceof IaUsuario){
			st = (username + " " + null + " " + pGanadas  + " " + pJugadas + " " + puntuacion.imprimirGuardadoPuntuacion());
		}
		return st;
	}

	public String imprimirRanking() {
		String st = null;
		st = (username + " " + pGanadas  + " " + pJugadas + " " + getPuntuacion());
		return st;
	}
	public boolean sinCartas() {
		return mano.vacia();
	}

	public void barajarMazo() {
		mazo.barajar();
	}

	public String carta(int pInd) {
		return mano.getCartaEnPos(pInd).imprimirNombre();
	}
	public String getPuntuacion() {
		return puntuacion.imprimirGuardadoPuntuacion();
	}
	public int getpJugadas() {
		return pJugadas;
	}
	public void resetPunt() {
		puntuacion.reset();
	}
	public void anadirPuntuacion(Carta pCarta) {
		puntuacion.anadirPuntuacion(pCarta);
	}
	public int CompararPuntuacion(Jugador pJug) {
		int p = puntuacion.compararPuntuacion(pJug);// TODO Auto-generated method stub
		return p;
	}
	public void setPuntuacion(String pPuntuacion) {
		puntuacion.setPuntuacion(pPuntuacion);
	}
}
