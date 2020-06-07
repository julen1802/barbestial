package juegoProyecto;
public class CartaFactory {
	private static CartaFactory mCartaFactory;
	public CartaFactory() {}
	public static CartaFactory getCartaFactory() {
		if(mCartaFactory == null) {
			mCartaFactory = new CartaFactory();
		}
		return mCartaFactory;
	}
	public Carta crearCarta(String tipo, EnumColor pColor) {
		Carta unaCarta = null;
		if(tipo.equals("Camaleon")) {
			unaCarta = new Camaleon(pColor);
		}
		else if(tipo.equals("Canguro")) {
			unaCarta = new Canguro(pColor);
		}
		else if(tipo.equals("Cocodrilo")) {
			unaCarta = new Cocodrilo(pColor);
		}
		else if(tipo.equals("Foca")) {
			unaCarta = new Foca(pColor);
		}
		else if(tipo.equals("Hipopotamo")) {
			unaCarta = new Hipopotamo(pColor);
		}
		else if(tipo.equals("Jirafa")) {
			unaCarta = new Jirafa(pColor);
		}
		else if(tipo.equals("Leon")) {
			unaCarta = new Leon(pColor);
		}
		else if(tipo.equals("Loro")) {
			unaCarta = new Loro(pColor);
		}
		else if(tipo.equals("Mofeta")) {
			unaCarta = new Mofeta(pColor);
		}
		else if(tipo.equals("Mono")) {
			unaCarta = new Mono(pColor);
		}
		else if(tipo.equals("Serpiente")) {
			unaCarta = new Serpiente(pColor);
		}
		else if(tipo.equals("Zebra")) {
			unaCarta = new Cebra(pColor);	
		}
		return unaCarta;
	}
}
