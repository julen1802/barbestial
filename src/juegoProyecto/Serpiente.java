package juegoProyecto;

public class Serpiente extends Carta{
	public Serpiente(EnumColor pColor) {
		super(9,"serpiente",pColor);
	}
	public void hacerAnimalada() {
		Cola.getCola().aSerpiente();
	}
}
