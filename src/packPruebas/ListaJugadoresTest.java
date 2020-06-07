package packPruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import juegoProyecto.Fichero;
import juegoProyecto.ListaJugadores;

public class ListaJugadoresTest {

	@Test
	public void iniciarSesionTest() {
		Fichero.getFichero().cargarJugadoresDesdeFichero();
		assertTrue(ListaJugadores.getListaJugadores().iniciarSesion("mikel", "bestial"));
		assertFalse(ListaJugadores.getListaJugadores().iniciarSesion("mikel", "besti"));
	}

	@Test
	public void crearJugadorTest() {
		assertTrue(ListaJugadores.getListaJugadores().crearJugador("mike", "pruebatest"));
		assertTrue(ListaJugadores.getListaJugadores().iniciarSesion("mike", "pruebatest"));
		assertFalse(ListaJugadores.getListaJugadores().crearJugador("mikel", "pruebatest"));
	}
	
}
