package juegoProyecto;

import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
	private static Sonido miSonido;
	private InputStream path;
	
	//Constructora
	private Sonido() {}
	//Métodos
	public static Sonido getSonido() {
		if (miSonido == null) {
			miSonido = new Sonido();
		}
		return miSonido;
	}
	public void reproducirSonido(String pNombre) {
		String nombreAnimal = pNombre;
		path=getClass().getResourceAsStream("/Sonidos/"+nombreAnimal+".wav");
		try {
			Clip sonido=AudioSystem.getClip();
			sonido.open(AudioSystem.getAudioInputStream(path));
			sonido.start();
		}
		catch(Exception fallo) {
			System.out.println(fallo);
		}
	}
}