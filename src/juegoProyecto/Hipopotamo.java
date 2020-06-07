package juegoProyecto;

 public class Hipopotamo extends Carta implements Recurrencia {
	public Hipopotamo(EnumColor pColor) {
		super(11,"hipopotamo",pColor);
	}
	public void recurrir(int pPos) {
		Cola.getCola().aHipopotamoR(pPos);
	}
	public void hacerAnimalada() {
		Cola.getCola().aHipopotamo();

		
	}
	
}
