package juegoProyecto;
public class Canguro extends Carta implements Eleccion{
	public Canguro(EnumColor pColor) {
		super(3,"canguro",pColor);
	}
	public void hacerAnimalada() {
		int size = Cola.getCola().size();
		if(size==2) {
			Cola.getCola().aCanguro(1);
			Partida.getPartida().cartaJugada(this);
		} else if(size>2){
			int pos =Cola.getCola().getPosicion(this);
			Partida.getPartida().elegirDeCola(pos);
		} else {
			Partida.getPartida().cartaJugada(this);
		}
	}
	public void hacerAnimaladaD(int pDec) {
		Cola.getCola().aCanguro(pDec);
		Partida.getPartida().cartaJugada(this);
	}
}
