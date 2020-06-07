package juegoProyecto;

public class Mofeta extends Carta{
	public Mofeta(EnumColor pColor) {
		super(1,"mofeta",pColor);
	}
	public void hacerAnimalada() {
		Cola.getCola().aMofeta();
	}
}
