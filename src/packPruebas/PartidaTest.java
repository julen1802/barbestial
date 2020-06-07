package packPruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import juegoProyecto.Fichero;
import juegoProyecto.Partida;

public class PartidaTest {
	
	@Test
	public void crearIAsTest() {
		Fichero.getFichero().cargarJugadoresDesdeFichero();
		assertEquals(Partida.getPartida().getNJugadores(),0); 
		Partida.getPartida().inicializarTipoPartida(0);
		Partida.getPartida().crearIAs(2, 2);
		assertEquals(Partida.getPartida().getNJugadores(),2);
	}

	@Test
	public void crearHumanosTest() {
		assertEquals(Partida.getPartida().getNJugadores(),2); 
		String[] s = {"DavidPedro 0 0 0 0 pedroDavid"};
		//Partida.getPartida().crearHumanos(s);
		//assertEquals(Partida.getPartida().getNJugadores(),2);
	}
	
}
