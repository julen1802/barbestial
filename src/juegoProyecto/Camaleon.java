package juegoProyecto;

public class Camaleon extends Carta implements Eleccion{
	Carta animalCopiado;
	public Camaleon(EnumColor pColor) {
		super(5,"camaleon",pColor);
	}
	public void hacerAnimalada() {
		if((Cola.getCola().size()-Cola.getCola().getApariciones(5).size())>0) {
			int pos =Cola.getCola().getPosicion(this);
			Partida.getPartida().elegirDeCola(pos);
		}
		else {
			Partida.getPartida().cartaJugada(this);

		}
	}
	public void hacerAnimaladaD(int pDec) {
		Cola.getCola().aCamaleon(pDec);
		Partida.getPartida().cartaJugada(this);
	}
	
}
