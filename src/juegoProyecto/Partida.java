package juegoProyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import packInterfaz.Cartas;
import packInterfaz.FinTurno;
import packInterfaz.IniciarSesion;
import packInterfaz.RankGanador;
import packInterfaz.VentanaConfig;
import packInterfaz.VentanaJuego;
import packInterfaz.VentanaPortada;

public class Partida extends Observable {
	private ArrayList<Jugador> lJugadores;
	private ArrayList<Observer> observadores;
	private static Partida mPartida;
	private int tipoPartida;

	private Partida() {
		lJugadores = new ArrayList<Jugador>();
		observadores = new ArrayList<Observer>();
	}

	public static Partida getPartida() {
		if (mPartida == null) {
			mPartida = new Partida();
		}
		return mPartida;
	}

	public int getNJugadores() {
		return lJugadores.size();
	}

	public void iniciarInterfazPortada() {
		VentanaPortada.getVentanaPortada().iniciar(); // dentro de la clase interfaz
	}

	public void iniciarInterfazConfig() {
		VentanaConfig.getVentanaConfig().iniciar();
		IniciarSesion.getIniciarSesion();
	}

	public void iniciarInterfazJuego() {
		VentanaJuego.getVentanaJuego();
		FinTurno.getFinTurno();
	}

	public void inicializarTipoPartida(int pTipoPartida) {
		lJugadores = new ArrayList<Jugador>();
		this.tipoPartida = pTipoPartida;
	}

	public void prepararMesa() {
		Cola.getCola().reiniciarLista();
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		// La partida por defecto definida en el enunciado es la 0
		barajar();
		tipoP();

		System.out.println("Mesa preparada");

	}

	public void crearIAs(int pNJug, int pNIAs) {
		while (pNIAs > 0) {
			EnumColor color = EnumColor.amarillo;
			color = color.getColor(pNJug); // Cambiar tema EnumColor
			IaUsuario jug = ListaJugadores.getListaJugadores().getIaLibre();
			if(jug!=null) {
				jug.asignarColor(color);
				jug.reiniciar();
				jug.crearBaraja(color); // crearBaraja desde jugador
				lJugadores.add(jug);
				pNIAs--;
				pNJug--;
			}
		}
	}

	public void crearHumanos(String[] pUsuarios) {
		for (int nJug = pUsuarios.length; nJug > 0; nJug--) {
			EnumColor color = EnumColor.amarillo;
			color = color.getColor(nJug);
			String nombre = pUsuarios[nJug - 1];
			Humano jug = ListaJugadores.getListaJugadores().getHumano(nombre);
			jug.asignarColor(color);
			jug.reiniciar();
			jug.crearBaraja(color);
			lJugadores.add(jug);
		}
		System.out.println("Humanos Creados");
		prepararMesa();

	}

	public void barajar() { // Metodo para barajar la lista de cartas
		Random aleat = new Random();
		for (int primera = 0; primera < lJugadores.size(); primera++) {
			int segunda = aleat.nextInt(lJugadores.size() - 1);
			Jugador temp = lJugadores.get(primera);
			lJugadores.set(primera, lJugadores.get(segunda));
			lJugadores.set(segunda, temp);

		}
		System.out.println("Jugadores barajeados");

	}

	public void cambiarTurno() {
		ArrayList<Jugador> list = new ArrayList<Jugador>();
		Iterator<Jugador> itr = lJugadores.iterator();
		if (itr.hasNext()) {
			Jugador aux = itr.next();
			while (itr.hasNext()) {
				list.add(itr.next());
			}
			list.add(aux);
		}
		lJugadores = list;
		if (lJugadores.get(0).sinCartas()) {
			finalizarPartida();
		} else {
			notificarJugador();
		}

	}

	public void notificarJugador() {
		Jugador j1 = lJugadores.get(0);
		if (!j1.sinCartas()) {
			if (j1 instanceof Humano) {
				notificarHumano();
			} else {
				notificarIA();
			}
		} else {
			setChanged();
			notifyObservers("fin");
		}
	}

	public void notificarIA() {
		Jugador j1 = lJugadores.get(0);
		setChanged();
		notifyObservers("bot" + " " + "IA" + " " + j1.color + " " + j1.imprimirLista());
	}

	public void notificarHumano() {
		Jugador j1 = lJugadores.get(0);
		if (j1 instanceof Humano) {
			String nombre = ((Humano) j1).getUsername();
			setChanged();
			notifyObservers("jugador" + " " + nombre + " " + j1.color + " " + j1.imprimirLista());
		}
	}

	public void addObserver(Object pObserver) {
		Observer o = (Observer) pObserver;
		observadores.add(o);
	}

	public Jugador getJugador(int pPos) {
		return lJugadores.get(pPos);
	}

	public void elecciones(int pPos) {
		Cartas.getCartas().elegir(4);
	}

	private Iterator<Jugador> getIterator() {
		return lJugadores.iterator();
	}

	public void tipoP() {
		System.out.println("Partida preparada");
		if (tipoPartida == 0) {
			// Partida Normal - Min 2 jug
			// Partida normal. 12 cartas por jugador.
		} else if (tipoPartida == 1) {
			// Partida de Eleccion - Min 3 jug
			// �Eres un estratega? En este modo de juego cada uno debera elegir 4 cartas de
			// sumano y descartarlas directamente, quedandose para jugar con unicamente 8
			// cartas.
			Iterator<Jugador> itr = getIterator();
			while(itr.hasNext()) {
				elecciones(4);

			}
		} else if (tipoPartida == 2) {
			// Partida Mundial - Min 10 jug
			// Esta partida es una de las partidas mas largas.

		}
		Jugador jugadorActual;
		Iterator<Jugador> iterTurno = getIterator();
		while (iterTurno.hasNext()) {
			jugadorActual = iterTurno.next();
			jugadorActual.barajarMazo();
			jugadorActual.robarMano();
		}
		iniciarInterfazJuego();
		comenzar();
	}

	private void comenzar() {
		setChanged();
		notificarJugador();
	}

	public void finalizarPartida() {
		lJugadores = Bar.getBar().contarPuntos(lJugadores);
		ordenarPuntuacion();
		ganador();
		ListaJugadores.getListaJugadores().guardarPuntuaciones(lJugadores);
		String s = "ganador";
		for(int i = 0; i<lJugadores.size();i++) {
			s = s + " " + lJugadores.get(i).getNombre() + " " +lJugadores.get(i).getPuntuacion();
		}
		RankGanador.getRankingGanador().ganadores(s);
		//setChanged();
		//notifyObservers(s);
	}
	private void ordenarPuntuacion() {
		Collections.sort(lJugadores, new CompararPuntuacion());
	}

	public void ganador() {
		Iterator<Jugador> itr = lJugadores.iterator();
		while(itr.hasNext()) {
			Jugador j= itr.next();
			System.out.println("----------------------------");
			System.out.println(j.getNombre());
			System.out.println(j.getPuntuacion());
		}
	}

	public void juegaBot() {
		Jugador j = lJugadores.get(0);
		if (j instanceof IaUsuario) {
			((IaUsuario) j).elegirCartaBot();
		}
	}

	public void turnoJugador(int pInd) {
		Jugador j = lJugadores.get(0);
		System.out.println("Eleccion realizada");
		if (j instanceof Humano) {
			((Humano) j).elegirCarta(pInd);
		}
	}

	public void animaladaI(int pInd) {
		Carta c = Cola.getCola().getUltimaCarta();
		if (c instanceof Eleccion) {
			((Eleccion) c).hacerAnimaladaD(pInd);
		}
	}

	public void elegirDeCola(int pInd) {
		Carta c = Cola.getCola().getCartaEnPos(pInd);
		Jugador j = lJugadores.get(0);
		if (j instanceof IaUsuario) {
			((IaUsuario) j).elegir(c);
		} else {
			if (c.getFuerza() == 3) {
				setChanged();
				notifyObservers("eleccion salto");
			} else {
				setChanged();
				notifyObservers("eleccion cola");
			}
		}
	}

	public void cartaJugada(Carta pUnaCarta) {
		Cola.getCola().notificar();
		Cola.getCola().hacerRecurrencia(pUnaCarta);
		Cola.getCola().ejecutarEstaLlena();
		if(pUnaCarta instanceof Eleccion) {
			lJugadores.get(0).cogerCarta();
		}
		Cola.getCola().notificar();
		imprimirDialogo(pUnaCarta);
	}

	public void imprimirDialogo(Carta pUnaCarta) { // Imprimira el juego realizado este turno
		String cartasDelBar = "";
		String cartaDeFuera = "";
		String llena = "no";
		if (Cola.getCola().seHaVaciado()) {
			cartasDelBar = Bar.getBar().getEntrantes();
			cartaDeFuera = Fuera.getFuera().getEchada();
			Cola.getCola().resetearBooleano();
			llena = "llena";
		}
		setChanged();
		notifyObservers("turnofinalizado" + " " + pUnaCarta.imprimirCarta() + " " + llena + " " + cartasDelBar + " " + cartaDeFuera);
	}

	public boolean estaIniciada(String pNombre) {
		boolean b =false;
		int i = 0;
		while(i<lJugadores.size() && !b) {
			if(lJugadores.get(i).getNombre().equals(pNombre)) {
				b = true;
			}
			i++;
		}
		return b;	
	}
	
}
