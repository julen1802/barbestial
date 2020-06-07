package juegoProyecto;

public class Foca extends Carta {
	public Foca( EnumColor pColor) {
		super(6,"foca",pColor);
	}
	
	public void hacerAnimalada() {
		Cola.getCola().aFoca();
	}
}
