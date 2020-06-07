package packPruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import juegoProyecto.Bar;
import juegoProyecto.Carta;
import juegoProyecto.Cola;
import juegoProyecto.EnumColor;
import juegoProyecto.Fuera;
import juegoProyecto.Humano;
import juegoProyecto.Mono;

class JugadorTest {

	@Test
	public void cogerCartaTest() {
		Humano h = new Humano("DavidPedro", 0, 0, 0, 0, "pedroDavid");
		h.crearBaraja(EnumColor.rojo);
		h.barajarMazo();
		assertEquals(h.getMano().size(),0); 
		assertEquals(h.getMazo().size(),12);

		//Cogemos una sola carta
		h.cogerCarta();
		
		assertEquals(h.getMano().size(),1); 
		assertEquals(h.getMazo().size(),11);
		
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		
		//Ahora tratamos de coger otra carta pero al no haber mas no ocurrira nada
		h.cogerCarta();
		assertEquals(h.getMano().size(),12); 
		assertEquals(h.getMazo().size(),0);
	}
	@Test
	public void echarCartaTest() {
		Humano h = new Humano("DavidPedro", 0, 0, 0, 0, "pedroDavid");
		h.crearBaraja(EnumColor.rojo);
		h.barajarMazo();
		assertEquals(h.getMano().size(),0); 
		assertEquals(h.getMazo().size(),12);
		Cola.getCola().reiniciarLista();
		//Repartimos la mano
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		h.cogerCarta();
		assertEquals(h.getMano().size(),4); 
		assertEquals(h.getMazo().size(),8);
		
		h.echarCarta(h.getMano().cogerCartaAlAzar());
		
		assertEquals(Cola.getCola().size(),1);
		assertEquals(h.getMazo().size(),8); 


		//Ahora tratamos de coger otra carta pero al no haber mas no ocurrira nada
	}
	@Test
	public void ejecutarColaLlenaTest() {
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		Cola.getCola().reiniciarLista();
		Carta carta1 = new Mono(EnumColor.rojo);
		Carta carta2 = new Mono(EnumColor.verde);
		Carta carta3 = new Mono(EnumColor.azul);
		Carta carta4 = new Mono(EnumColor.verde);
		Carta carta5 = new Mono(EnumColor.rojo);
		Cola.getCola().anadirCarta(carta1);
		Cola.getCola().anadirCarta(carta2);
		Cola.getCola().anadirCarta(carta3);
		Cola.getCola().anadirCarta(carta4);
		
		Cola.getCola().ejecutarEstaLlena();
		assertEquals(Cola.getCola().size(),4);
		assertEquals(Bar.getBar().size(),0);
		assertEquals(Fuera.getFuera().size(),0);

		Cola.getCola().anadirCarta(carta5);
		
		Cola.getCola().ejecutarEstaLlena();

		assertEquals(Cola.getCola().size(),2);
		assertEquals(Bar.getBar().size(),2);
		assertEquals(Fuera.getFuera().size(),1);

		//Ahora tratamos de coger otra carta pero al no haber mas no ocurrira nada
	}
	@Test
	public void hacerAnimaladaTest() {
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		Cola.getCola().reiniciarLista();
		Carta carta1 = new Mono(EnumColor.rojo);
		Carta carta2 = new Mono(EnumColor.verde);
		Carta carta3 = new Mono(EnumColor.azul);
		Carta carta4 = new Mono(EnumColor.verde);
		Carta carta5 = new Mono(EnumColor.rojo);
		Cola.getCola().anadirCarta(carta1);
		Cola.getCola().anadirCarta(carta2);
		Cola.getCola().anadirCarta(carta3);
		Cola.getCola().anadirCarta(carta4);
		
		Cola.getCola().ejecutarEstaLlena();
		assertEquals(Cola.getCola().size(),4);
		assertEquals(Bar.getBar().size(),0);
		assertEquals(Fuera.getFuera().size(),0);

		Cola.getCola().anadirCarta(carta5);
		
		Cola.getCola().ejecutarEstaLlena();

		assertEquals(Cola.getCola().size(),2);
		assertEquals(Bar.getBar().size(),2);
		assertEquals(Fuera.getFuera().size(),1);

		//Ahora tratamos de coger otra carta pero al no haber mas no ocurrira nada
	}

}
