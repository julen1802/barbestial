package juegoProyecto;
public enum EnumColor {
	rojo,azul,verde,amarillo,rosa,negro,naranja,gris,magenta,cyan,grisclaro,grisoscuro;
	public EnumColor getColor(int pColor) {
		if(pColor==1) {
			return rojo;
		}
		else if(pColor==2) {
			return azul;
		}
		else if(pColor==3) {
			return verde;
		}
		else if(pColor==4) {
			return amarillo;
		}
		else if(pColor==5) {
			return rosa;
		}
		else if(pColor==6) {
			return naranja;
		}
		else if(pColor==7) {
			return gris;
		}
		else if(pColor==8) {
			return negro;
		}
		else if(pColor==9) {
			return cyan;
		}
		else if(pColor==10) {
			return magenta;
		}
		else if(pColor==11) {
			return grisclaro;
		}
		else if(pColor==12) {
			return grisoscuro;
		}
		else {
			return null;
		}
		
	}
}
