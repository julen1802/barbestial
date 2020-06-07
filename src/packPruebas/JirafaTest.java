package packPruebas;


import static org.junit.Assert.*;

import org.junit.Test;

import juegoProyecto.Bar;
import juegoProyecto.Fuera;
import juegoProyecto.Cola;
import juegoProyecto.Carta;
import juegoProyecto.Canguro;
import juegoProyecto.Serpiente;
import juegoProyecto.Mono;
import juegoProyecto.Jirafa;
import juegoProyecto.EnumColor;
import juegoProyecto.Leon;
import juegoProyecto.Cebra;
import juegoProyecto.Loro;
import juegoProyecto.Cocodrilo;



class JirafaTest {

	@Test
	void testHacerAnimalada() {
		//Adelanta al mono
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		assertEquals(Fuera.getFuera().size(),0);
		Cola.getCola().reiniciarLista();
		
		Carta canguro = new Canguro(EnumColor.rojo);
		Carta serpiente = new Serpiente(EnumColor.cyan);
		Carta mono = new Mono(EnumColor.azul);
		Carta jirafa = new Jirafa(EnumColor.verde);
		
		Cola.getCola().anadirCarta(canguro);
		assertEquals(Cola.getCola().size(),1);
		Cola.getCola().anadirCarta(serpiente);
		assertEquals(Cola.getCola().size(),2);
		Cola.getCola().anadirCarta(mono);
		assertEquals(Cola.getCola().size(),3);
		
		Cola.getCola().anadirCarta(jirafa);
		assertEquals(Cola.getCola().size(),4);
		jirafa.hacerAnimalada();
		
		assertSame(Cola.getCola().getCartaEnPos(Cola.getCola().size()),mono);
		assertEquals(Cola.getCola().size(),4);	
		
		//No adelanta a la serpiente
		jirafa.hacerAnimalada();
		//System.out.println(Cola.getCola().getCartaEnPos((Cola.getCola().size())-1).imprimirNombre());
		assertSame(Cola.getCola().getCartaEnPos((Cola.getCola().size())-1),jirafa);
		assertEquals(Cola.getCola().size(),4);	
		}

	@Test
	void testRecurrir() {
		//La jirafa es la �nica recurrente
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		assertEquals(Fuera.getFuera().size(),0);
		Cola.getCola().reiniciarLista();
		
		Carta canguro = new Canguro(EnumColor.rojo);
		Carta serpiente = new Serpiente(EnumColor.cyan);
		Carta mono = new Mono(EnumColor.azul);
		Carta jirafa = new Jirafa(EnumColor.verde);
		
		Cola.getCola().anadirCarta(canguro);
		assertEquals(Cola.getCola().size(),1);
		Cola.getCola().anadirCarta(serpiente);
		assertEquals(Cola.getCola().size(),2);
		Cola.getCola().anadirCarta(mono);
		assertEquals(Cola.getCola().size(),3);
		
		
		Cola.getCola().anadirCarta(jirafa);
		assertEquals(Cola.getCola().size(),4);
		jirafa.hacerAnimalada();
		Cola.getCola().hacerRecurrencia(Cola.getCola().getCartaEnPos(Cola.getCola().size()));
		
		System.out.println(Cola.getCola().getCartaEnPos((Cola.getCola().size())).imprimirNombre());
		assertSame(Cola.getCola().getCartaEnPos(Cola.getCola().size()),mono);
		assertEquals(Cola.getCola().size(),4);	
		
		// Hay varios animales recurrentes.
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		assertEquals(Fuera.getFuera().size(),0);
		Cola.getCola().reiniciarLista();
			
		Carta leon = new Leon(EnumColor.rojo);
		Carta leon2 = new Leon(EnumColor.rosa);
		Carta cebra = new Cebra(EnumColor.cyan);
		Carta cebra2 = new Cebra(EnumColor.magenta);
		Carta loro = new Loro(EnumColor.naranja);
		Carta loro2 = new Loro(EnumColor.azul);
		Carta cocodrilo = new Cocodrilo(EnumColor.grisclaro);
				
		Cola.getCola().anadirCarta(leon);
		assertEquals(Cola.getCola().size(),1);
		Cola.getCola().anadirCarta(cebra);
		assertEquals(Cola.getCola().size(),2);
		Cola.getCola().anadirCarta(jirafa);
		assertEquals(Cola.getCola().size(),3);
		Cola.getCola().anadirCarta(loro);
		assertEquals(Cola.getCola().size(),4);
		Cola.getCola().anadirCarta(leon2);
		assertEquals(Cola.getCola().size(),5);
		Cola.getCola().anadirCarta(cebra);
		assertEquals(Cola.getCola().size(),6);
		Cola.getCola().anadirCarta(mono);
		assertEquals(Cola.getCola().size(),7);
		Cola.getCola().anadirCarta(cocodrilo);
		assertEquals(Cola.getCola().size(),8);
		Cola.getCola().anadirCarta(loro2);
		assertEquals(Cola.getCola().size(),9);
		Cola.getCola().hacerRecurrencia(Cola.getCola().getCartaEnPos(Cola.getCola().size()));
		
		System.out.println(Cola.getCola().getCartaEnPos((Cola.getCola().size())).imprimirNombre());
		assertSame(Cola.getCola().getCartaEnPos(1),leon);
		assertSame(Cola.getCola().getCartaEnPos(2),jirafa); //Ha adelantado a la cebra
		assertSame(Cola.getCola().getCartaEnPos(3),cebra);
		assertSame(Cola.getCola().getCartaEnPos(4),loro);
		assertSame(Cola.getCola().getCartaEnPos(5),leon2);
		assertSame(Cola.getCola().getCartaEnPos(6),cebra); //No se ha dejado adelantar por el cocodrilo
		assertSame(Cola.getCola().getCartaEnPos(7),cocodrilo); //El cocodrilo se ha comido al mono
		assertSame(Cola.getCola().getCartaEnPos(8),loro2);
		
	}

}
