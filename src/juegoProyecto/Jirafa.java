package juegoProyecto;

public class Jirafa extends Carta implements Recurrencia {
	public Jirafa(EnumColor pColor) {
		super(8,"jirafa",pColor);
	}
	public void recurrir(int pPos) {
		Cola.getCola().aJirafaR(pPos);	
	}
	public void hacerAnimalada() {
		Cola.getCola().aJirafa();	
	}
}
