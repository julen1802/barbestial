package juegoProyecto;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Cola extends Observable {
	private ListaCartas cola;
	private ArrayList<Observer> observadores;
	private static Cola miCola;
	private boolean llena;

	public Cola() {
		observadores = new ArrayList<Observer>();
		cola = new ListaCartas();
		llena = false;
	}
	public void setLlena() {
		llena = !llena;
	}
	public static Cola getCola() {
		if (miCola == null) {
			miCola = new Cola();
		}
		return miCola;
	}

	public int size() {
		return cola.size();
	}

	public void addObserver(Object e) {
		Observer o = (Observer) e;
		observadores.add(o);
	}

	public int cartaNumColor(EnumColor pColor, int pFuerza) {
		return cola.cartaNumColor(pColor, pFuerza);
	}

	public int sumarPuntos() {
		return cola.sumarPuntos();
	}

	public int numCartasMenoresQue(int pFuerza) {
		return cola.numCartasMenoresQue(pFuerza);
	}

	public void eliminarAparicion(int pNum) {
		cola.eliminarAparicion(pNum);//

	}

	public void eliminarApariciones(int pNum) {
		cola.eliminarApariciones(pNum);
		// Notificamos el cambio realizado
	}

	public void reiniciarLista() {
		cola.reiniciarLista();
		// Notificamos el cambio realizado
	}

	public void ordenar() {
		cola.ordenar();
		// Notificamos el cambio realizado
	}

	public int posOrden(int pFuerza) {
		// Dada una lista ordenada y una fuerza devuelve la posicion en la que se le
		// a�adiria en la lista
		return cola.posOrden(pFuerza);
	}
	public int posCarta(int pFuerza) {
		// Dada una lista ordenada y una fuerza devuelve la posicion en la que se le
		// a�adiria en la lista
		return cola.posCarta(pFuerza);
	}

	public int buscarMayorFuerza() {
		return cola.buscarMayorFuerza();
	}

	public boolean esta(int pFuerza) {
		return cola.esta(pFuerza);
	}

	public void anadirInd(int pIndex, Carta pCarta) {
		cola.anadirInd(pIndex, pCarta);
		// Notificamos el cambio realizado
	}

	public ArrayList<Integer> getApariciones(int pFuerza) {
		return cola.getApariciones(pFuerza);
	}

	public Carta getCartaEnPos(int pInd) {
		return cola.getCartaEnPos(pInd);
	}

	public void moverCarta(int pIndInic, int pIndDest) {
		cola.moverCarta(pIndInic, pIndDest);
		// Notificamos el cambio realizado
	}

	public void anadirCarta(Carta pCarta) {
		cola.anadirCarta(pCarta);
		// Notificamos el cambio realizado
	}

	public void hacerRecurrencia(Carta pCarta) {
		cola.hacerRecurrencia(pCarta);
		// Notificamos el cambio realizado
	}

	public ListaCartas invertirOrden() {
		return cola.invertirOrden();
	}

	public void editarCola(ArrayList<Carta> pLista) {
		cola.editarCola(pLista);

	}

	public int getPosicion(Carta pCarta) {
		return cola.getPosicion(pCarta);
	}

	public void eliminarCarta(Carta pCarta) {
		cola.eliminarCarta(pCarta);
	}

	public void notificar() {
		System.out.println("Enviado");
		setChanged();
		notifyObservers("cola" + " " + cola.imprimirCartas());
		System.out.println("Recibido");
	}

	public void ejecutarEstaLlena() {
		cola.estaLlena();
	}


	public Carta eliminarCartaEnPos(int pPos) {
		return cola.eliminarCartaEnPos(pPos);
	}

	public Carta getUltimaCarta() {
		int size = Cola.getCola().size();
		return getCartaEnPos(size);
	}

	public boolean seHaVaciado() {
		return llena;
	}

	public void resetearBooleano() {
		llena = false;
	}

	public int cartasDeColor(EnumColor pColor) {
		return cola.cartasDeColor(pColor);
	}

	public int mismoColorDosPrimerosEnFila(EnumColor pColor) {
		return cola.mismoColorDosPrimerosEnFila(pColor);
	}

	public boolean hayRecurrentes() {
		return cola.hayRecurrentes();
	}

	public void aMofeta() {
		cola.aMofeta();
	}

	public void aLoro(int pPos) {
		cola.aLoro(pPos);
	}

	public void aCanguro(int pS) {
		cola.aCanguro(pS);

	}

	public void aMono() {
		cola.aMono();

	}

	public void aCamaleon(int pC) {
		cola.aCamaleon(pC);

	}

	public void aFoca() {
		ListaCartas pLista = invertirOrden();
		cola = pLista;	

	}
	public void aJirafa() {
		cola.aJirafa();

	}

	public void aSerpiente() {
		cola.aSerpiente();

	}

	public void aCocodrilo() {
		cola.aCocodrilo();

	}

	public void aHipopotamo() {
		cola.aHipopotamo();

	}

	public void aLeon() {
		cola.aLeon();

	}

	public void aCocodriloR(int pPos) {
		cola.aCocodriloR(pPos);
	}

	public void aHipopotamoR(int pPos) {
		cola.aHipopotamoR(pPos);
		
	}
	public void aJirafaR(int pPos) {
		cola.aJirafaR(pPos);
		
	}

	public ArrayList<Integer> recurrentesColor(EnumColor pColor) {
		return cola.recurrentesColor(pColor);
	}
}
