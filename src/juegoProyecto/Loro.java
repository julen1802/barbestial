package juegoProyecto;
public class Loro extends Carta implements Eleccion{
		public Loro(EnumColor pColor) {
			super(2,"loro",pColor);
		}
		public void hacerAnimalada() {
			// Mostrar las cartas
			if(Cola.getCola().size()>1) {
				int pos =Cola.getCola().getPosicion(this);
				Partida.getPartida().elegirDeCola(pos);
			}
			else {
				Partida.getPartida().cartaJugada(this);

			}
		}
		@Override
		public void hacerAnimaladaD(int pDec) {
			Cola.getCola().aLoro(pDec);
			Partida.getPartida().cartaJugada(this);
		}
}
