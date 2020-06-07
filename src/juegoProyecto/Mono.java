package juegoProyecto;
import java.util.ArrayList;

public class Mono extends Carta {
	public Mono(EnumColor pColor) {
		super(4,"mono",pColor);
	}
	public void hacerAnimalada() {
		Cola.getCola().aMono();
	}
}
