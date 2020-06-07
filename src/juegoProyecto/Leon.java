package juegoProyecto;

public class Leon extends Carta{
 
	public Leon(EnumColor pColor) {
		super(12,"leon",pColor);
	}
	public void hacerAnimalada() {
		Cola.getCola().aLeon();
	}
}
