package juegoProyecto;

public class Cocodrilo extends Carta implements Recurrencia {
	public Cocodrilo(EnumColor pColor) {
		super(10,"cocodrilo",pColor);
	}
	public void recurrir(int pPos) {
		Cola.getCola().aCocodriloR(pPos);
	}
	public void hacerAnimalada() {
		Cola.getCola().aCocodrilo();	
	}
}
