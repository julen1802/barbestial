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
import juegoProyecto.EnumColor;
import juegoProyecto.Leon;
import juegoProyecto.Cocodrilo;
import juegoProyecto.Mofeta;


class CocodriloTest {

	@Test
	void testHacerAnimalada() {
		// El cocodrilo se come a todas las de la lista
		// por ser m�s d�biles que �l.
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		assertEquals(Fuera.getFuera().size(),0);
		Cola.getCola().reiniciarLista();
		
		Carta canguro = new Canguro(EnumColor.rojo);
		Carta mofeta = new Mofeta(EnumColor.cyan);
		Carta mono = new Mono(EnumColor.azul);
		Carta cocodrilo = new Cocodrilo(EnumColor.verde);
		
		Cola.getCola().anadirCarta(canguro);
		assertEquals(Cola.getCola().size(),1);
		Cola.getCola().anadirCarta(mofeta);
		assertEquals(Cola.getCola().size(),2);
		Cola.getCola().anadirCarta(mono);
		assertEquals(Cola.getCola().size(),3);
		
		Cola.getCola().anadirCarta(cocodrilo);
		assertEquals(Cola.getCola().size(),4);
		cocodrilo.hacerAnimalada();
		
		assertEquals(Cola.getCola().size(),1);
		
		
		//Ahora el cocodrilo solo podr� ser capaz de comer a 1
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		assertEquals(Fuera.getFuera().size(),0);
		Cola.getCola().reiniciarLista();
		
		Carta leon = new Leon(EnumColor.rojo);
		Carta serpiente = new Serpiente(EnumColor.cyan);
		
		Cola.getCola().anadirCarta(leon);
		assertEquals(Cola.getCola().size(),1);
		Cola.getCola().anadirCarta(serpiente);
		assertEquals(Cola.getCola().size(),2);
			
		Cola.getCola().anadirCarta(cocodrilo);
		assertEquals(Cola.getCola().size(),3);
		cocodrilo.hacerAnimalada();
		assertEquals(Cola.getCola().size(),2);
		
		//Solo est� el cocodrilo, por lo que no comer� a nadie
		Bar.getBar().reiniciarLista();
		Fuera.getFuera().reiniciarLista();
		assertEquals(Fuera.getFuera().size(),0);
		Cola.getCola().reiniciarLista();
		
		Cola.getCola().anadirCarta(cocodrilo);
		assertEquals(Cola.getCola().size(),1);
		
		cocodrilo.hacerAnimalada();
		assertEquals(Cola.getCola().size(),1);
	}

}
