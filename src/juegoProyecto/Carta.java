package juegoProyecto;
public abstract class Carta {
	protected int fuerza;
	protected EnumColor color;
	private String nombre;
	public Carta(int pFuerza, String pNombre, EnumColor pColor) {
		fuerza = pFuerza;
		color = pColor;
		nombre = pNombre;
	}
	public abstract void hacerAnimalada();
	public void verDescripcion() {
		//Metodo a implementar en interfaz
	}
	public int getFuerza() {
		return fuerza;
	}
	public EnumColor getColor() {
		return color;
	}
	public String imprimirCarta() {
		return (nombre + " " + color);
	}
	public String imprimirNombre() {
		return nombre;
	}
}
