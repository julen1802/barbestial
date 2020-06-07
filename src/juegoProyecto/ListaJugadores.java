package juegoProyecto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Random;


public class ListaJugadores extends CompararGanadas {

	private HashMap<String, Jugador> listaJugs;
	private static ListaJugadores mListaJugadores;

	private ListaJugadores() {
		listaJugs = new HashMap<String, Jugador>();
	}

	public static ListaJugadores getListaJugadores() {
		if (mListaJugadores == null) {
			mListaJugadores = new ListaJugadores();
		}
		return mListaJugadores;
	}

	public void anadirJug(Jugador pJug) {
		if (!listaJugs.containsKey(pJug.getUsername())) {
			listaJugs.put(pJug.getUsername(), pJug); // indicador que no exista
		}
	}
	public Jugador getJugador(String pJug) {
		Jugador j;
		j = listaJugs.get(pJug); // listaJugs.get(pPos);
		return j;
	}

	public Humano getHumano(String pUsuario) {
		Humano h;
		h = (Humano) listaJugs.get(pUsuario); // listaJugs.get(pPos);
		return h;
	}

	public String imprimirGuardadoJug(Jugador pJug) {
		String st = pJug.imprimirGuardadoJug();
		return st;
	}

	public boolean existeJugador(Jugador pJug) {
		return listaJugs.containsKey(pJug);
	}

	public int getNJugs() {
		return listaJugs.size();
	}

	// iniciarSesion
	public boolean iniciarSesion(String pUsuario, String pContrasena) { // Devolvera un True si ha iniciado
																		// correctamente
		boolean p = false;
		if (listaJugs.containsKey(pUsuario)) {
			if (pContrasena != null) {
				Humano h = getHumano(pUsuario);
				if (h.igualContrasena(pContrasena)) {
					p = true;
					System.out.println("Se ha iniciado sesion como jugador humano con el usuario y contrasena.");
				}
			}
		} else {
			p = crearJugador(pUsuario, pContrasena);
		}
		return p;
	}

	public boolean crearJugador(String pUsuario, String pContrasena) { // devolvera un true si el jugador se ha creado
		boolean p = false;
		if (listaJugs.containsKey(pUsuario)) { // if(existe ese usuario){
			p = false;
		} else {
			Humano h = new Humano(pUsuario, 0, 0, 0, 0, pContrasena);
			anadirJug(h);
			p = true;
		}
		return p;
	}
	public ArrayList<Jugador> convertirHashMap(){
		ArrayList<Jugador> listaJ = new ArrayList<Jugador>(listaJugs.values());
		return listaJ;
	}

	private ArrayList<Jugador> ordenarGanadas() {
		ArrayList<Jugador> jugadoresOrdenados = convertirHashMap();
		// jugadoresOrdenados es una Colección de Jugadores sin ordenar

		Collections.sort(jugadoresOrdenados, new CompararGanadas());
		// Esto ordena los Jugadores de la Coleccion jugadoresOrdenados
		return jugadoresOrdenados;

	}

	private ArrayList<Jugador> ordenarNombre() {
		ArrayList<Jugador> jugadoresOrdenados = convertirHashMap();
		// jugadoresOrdenados es una Colección de Jugadores sin ordenar

		Collections.sort(jugadoresOrdenados, new CompararNombre());
		// Esto ordena los Jugadores de la Coleccion jugadoresOrdenados
		return jugadoresOrdenados;
	}

	private ArrayList<Jugador> ordenarPuntuacion() {
		ArrayList<Jugador> jugadoresOrdenados = convertirHashMap();
		// jugadoresOrdenados es una Colección de Jugadores sin ordenar

		Collections.sort(jugadoresOrdenados, new CompararPuntuacion());
		// Esto ordena los Jugadores de la Coleccion jugadoresOrdenados
		return jugadoresOrdenados;

	}

	private ArrayList<Jugador> ordenarTasa() {
		ArrayList<Jugador> jugadoresOrdenados = convertirHashMap();
		// jugadoresOrdenados es una Colección de Jugadores sin ordenar

		Collections.sort(jugadoresOrdenados, new CompararTasa());
		// Esto ordena los Jugadores de la Coleccion jugadoresOrdenados
		return jugadoresOrdenados;

	}

	public String[] getPuntuaciones(String pTipo) {
		ArrayList<Jugador> jugadoresRank= new ArrayList<Jugador>();
		String[] s = new String[1];
		if (pTipo.equals("Partidas Ganadas")) {
			jugadoresRank = ordenarGanadas();
			s = new String[15];
		} else if (pTipo.equals("Nombre A-Z")) {
			jugadoresRank = ordenarNombre();
			s = new String[listaJugs.size()];
		} else if (pTipo.equals("Puntuacion")) {
			jugadoresRank = ordenarPuntuacion();
			s = new String[15];
		} else if (pTipo.equals("Tasa de Victorias")) {
			jugadoresRank = ordenarTasa();
			s = new String[15];
		}
		s[0] = "ranking";
		for(int i = 0; i<s.length-1;i++) {
			s[i+1] = jugadoresRank.get(i).imprimirRanking();
		}
		return s;
	}

	public IaUsuario getIaLibre() {
		ArrayList<Jugador> l = convertirHashMap();
		Random r = new Random();
		IaUsuario a = null;
		int i = r.nextInt(l.size()-1);
		if(l.get(i) instanceof IaUsuario){
			if(!Partida.getPartida().estaIniciada(l.get(i).getNombre())) {
				a = (IaUsuario) l.get(i);
			}
		}
		return a;
	
	}
	public void guardarPuntuaciones(ArrayList<Jugador> pLJugadores) {
		for(int i = 0; i<pLJugadores.size();i++) {
			Jugador j1 = pLJugadores.get(i);
			Jugador j2 = getJugador(j1.getNombre());
			int p = j1.CompararPuntuacion(j2);
			if(p==-1) {
				j2.setPuntuacion(j1.getPuntuacion());
			}
			listaJugs.replace(j2.getNombre(), j2);
		}
		Fichero.getFichero().guardarPartida();
	}

}