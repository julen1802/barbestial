package juegoProyecto;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Teclado {
	private static Teclado miTeclado = new Teclado();
	private Scanner sc;

	private Teclado() {
		this.sc = new Scanner(System.in);
	}

	public static Teclado getTeclado() {
		return miTeclado;
	}

	public int leerNum(String pMensaje) {
		System.out.println(pMensaje);
		int leer = sc.nextInt();
		return leer;
	}

	public String leerString(String pMensaje) {
		System.out.println(pMensaje);
		String leer = sc.nextLine();
		return leer;
	}

	public void mostrarMensaje(String pMensaje) {

		JOptionPane.showMessageDialog(null, pMensaje);
	}

}
